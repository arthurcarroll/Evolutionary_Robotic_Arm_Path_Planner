package main;

import RobotModel.EvoSimConfiguration;
import RobotModel.JointVariableType;
import RobotModel.PathConfiguration;
import RobotModel.PathPosition;
import RobotModel.PathVariable;
import RobotModel.RobotConfiguration;
import RobotModel.SimulationConfiguration;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.GhostControl;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Arthur Carroll
 */
public class Population {

    private ArrayList<GhostControl> ghosts;
    ArrayList<Path> paths = new ArrayList<Path>();
    Robot baseRobot;
    CollisionHandler collisionHander;
    int populationSize = 15;
    Random random = new Random(System.currentTimeMillis());
    boolean running = false;
    int activepath = 0;
    private double mutationProbability;
    private int maxMutationAmmount;
    private int generations = 0;
    private double averageFitness = 0;
    double maxFitness = 0;
    Path bestPath = null;
    Path worstPath = null;
    int stuckTimes = 0;
    private int knotPoints = 1;
    private int collisionWeight = 1;
    private int moveWeight = 1;
    private int maxStuckTimes = 5;
    boolean randomKnots = false;
    boolean useWorstPath = false;

    public Population(BulletAppState bApp) {
        //collisionHander = new CollisionHandler();
        //bApp.getPhysicsSpace().addCollisionListener(collisionHander);
    }

    public void makeIntitialPath(PathConfiguration pathconfig) {
        // make the first path with two knot points, if there are no collisions then there is
        // no point in evolving anything

        Path initialPath = new Path(pathconfig);


        int pathVariables = initialPath.getPathPositions().get(0).getPathVariables().size();

        // need to find points in between knots
        for (int j = 0; j < knotPoints; j++) {
            PathPosition pp = new PathPosition();
            for (int i = 0; i < pathVariables; i++) {
                int pathPositions = initialPath.getPathPositions().size();
                PathVariable startPV = initialPath.getPathPositions().get(pathPositions - 2).getPathVariables().get(i);
                PathVariable endPV = initialPath.getPathPositions().get(pathPositions - 1).getPathVariables().get(i);
                if (randomKnots) {
                    pp.addPathVariable(random.nextInt(360), JointVariableType.THETA_I);
                } else {
                    pp.addPathVariable((float) findMiddle(startPV.getValue(), endPV.getValue()), JointVariableType.THETA_I);
                }
            }
            initialPath.addIntermediateGoal(pp);
        }


        paths.add(initialPath);
        makeNewPaths(initialPath, populationSize);
    }

    public void makeNewPaths(Path basePath, int ammountToAdd) {
        for (int i = 0; i < ammountToAdd; i++) {
            Path nextpath = Path.deepClonePath(basePath);
            nextpath.resetFitness();
            mutatePath(nextpath, mutationProbability);
            paths.add(nextpath);
        }
    }

    public void makeTestRobot(SimpleApplication app, BulletAppState bApp, RobotConfiguration robotConfig) {
        // extract the robots joint variables and make it into a matrix
        // chain
        baseRobot = new Robot(app, bApp, robotConfig);
    }

    public void update(float tpf) {
        if (running) {
            baseRobot.update(tpf);
            if (baseRobot.reachedGoal) {
                // give the robot a new path
                findPath();
            }
        }

        baseRobot.updateFitness(ghosts);
    }

    public void setup(SimpleApplication app, BulletAppState bApp, SimulationConfiguration simconfig) {
        EvoSimConfiguration evoConfig = simconfig.getEvoConfig();
        populationSize = evoConfig.getPopulationSize();
        mutationProbability = evoConfig.getMutationProbability();
        maxMutationAmmount = evoConfig.getMaxMutationAmmount();
        knotPoints = evoConfig.getKnotPoints();
        collisionWeight = evoConfig.getCollisionWeight();
        moveWeight = evoConfig.getMoveWeight();
        maxStuckTimes = evoConfig.getStuckTimes();
        randomKnots = evoConfig.isRandomKnots();
        useWorstPath = evoConfig.isUseWorstPath();

        makeTestRobot(app, bApp, simconfig.getRobotConfig());
        makeIntitialPath(simconfig.getPathConfig());
    }

    public void changeActivePath(Path currentPath) {
        //collisionHander.setPath(currentPath);

        // tell the robot to follow this, initial path
        baseRobot.setPath(currentPath);
        baseRobot.seekGoal();
    }

    // 1.0 for prob means always mutate
    private void mutatePath(Path pathTomutate, double mutateProbablity) {
        // do not modify the first or last position
        for (int i = 1; i < (pathTomutate.getPathPositions().size() - 1); i++) {
            PathPosition pp = pathTomutate.getPathPositions().get(i);
            for (PathVariable pv : pp.getPathVariables()) {
                if (random.nextDouble() < mutateProbablity) {
                    if (random.nextDouble() > 0.5) {
                        pv.setValue((float) (pv.getValue() - random.nextInt(maxMutationAmmount)));
                        if (pv.getValue() <= 0) {
                            pv.setValue(0);
                        }
                    } else {
                        pv.setValue((float) (pv.getValue() + random.nextInt(maxMutationAmmount)));
                        if (pv.getValue() > 360) {
                            pv.setValue(360);
                        }
                    }
                }
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public static double findMiddle(double one, double two) {
        double val = 0;
        if (one > two) {
            val = ((one - two) / 2) + two;
        } else {
            val = ((two - one) / 2) + one;
        }
        return val;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void findPath() {
        if (activepath < paths.size()) {
            changeActivePath(paths.get(activepath++));
        } else {
            activepath = 0;
            runEvoCycle();
        }
        running = true;
    }

    public void resetPathCollisions() {
        for (Path p : paths) {
            p.resetFitness();
        }
    }

    private void runEvoCycle() {
        generations++;
        averageFitness = 0;

        for (Path p : paths) {
            averageFitness += p.getFitness(collisionWeight, moveWeight);
        }

        averageFitness /= paths.size();

        // the first time just pick any path
        if (bestPath == null || worstPath == null) {
            bestPath = paths.get(0);
            worstPath = paths.get(paths.size() - 1);
        }

        boolean newBest = false;
        // find the best path 
        for (Path p : paths) {
            if (p.getFitness(collisionWeight, moveWeight) < bestPath.getFitness(collisionWeight, moveWeight)) {
                bestPath = p;
                newBest = true;
                stuckTimes = 0;

            }
        }

        if (!newBest) {
            stuckTimes++;

            // stuck in a local minima
            if (stuckTimes == maxStuckTimes) {
                collisionWeight += 2;
                System.out.println("Stuck !!!!");
                // remember these values
                double oldMut = this.mutationProbability;
                int oldMax = this.maxMutationAmmount;

                // make them really big
                maxMutationAmmount = 50;
                mutationProbability = 1;

                // drastically mutate the paths and add a knot point
                //bestPath.addIntermediateGoal(PathPosition.deepClone(bestPath.getPathPositions().get(1)));
                makeNewPaths(bestPath, populationSize);

                // put them back to what they were
                maxMutationAmmount = oldMax;
                mutationProbability = oldMut;

                // forget these old paths
                bestPath = null;
                worstPath = null;
            }

        }

        if (bestPath != null) {
            maxFitness = bestPath.getFitness(collisionWeight, moveWeight);
        }

        if (worstPath != null) {
            // find the worst path
            for (Path p : paths) {
                if (p.getFitness(collisionWeight, moveWeight) > worstPath.getFitness(collisionWeight, moveWeight)) {
                    worstPath = p;
                }
            }
        }

        if (bestPath != null && worstPath != null) {
            System.out.println(generations +", "+ bestPath.getFitness(collisionWeight, moveWeight));
            if(generations > 35){
                System.exit(0);
            }
            paths.clear();


            if (useWorstPath) {
                int bestPaths = (populationSize / 2) + (populationSize / 2) / 2;
                makeNewPaths(bestPath, bestPaths);
                makeNewPaths(worstPath, populationSize - bestPaths);
            } else {
                makeNewPaths(bestPath, populationSize);
            }
        }

    }

    public int getActivepath() {
        return activepath;
    }

    public void setActivepath(int activepath) {
        this.activepath = activepath;
    }

    public double getAverageFitness() {
        return averageFitness;
    }

    public void setAverageFitness(double averageFitness) {
        this.averageFitness = averageFitness;
    }

    public Robot getBaseRobot() {
        return baseRobot;
    }

    public void setBaseRobot(Robot baseRobot) {
        this.baseRobot = baseRobot;
    }

    public CollisionHandler getCollisionHander() {
        return collisionHander;
    }

    public void setCollisionHander(CollisionHandler collisionHander) {
        this.collisionHander = collisionHander;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public ArrayList<GhostControl> getGhosts() {
        return ghosts;
    }

    public void setGhosts(ArrayList<GhostControl> ghosts) {
        this.ghosts = ghosts;
    }

    public double getMaxFitness() {
        return maxFitness;
    }

    public int getMaxMutationAmmount() {
        return maxMutationAmmount;
    }

    public void setMaxMutationAmmount(int maxMutationAmmount) {
        this.maxMutationAmmount = maxMutationAmmount;
    }

    public double getMutationProbability() {
        return mutationProbability;
    }

    public void setMutationProbability(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
