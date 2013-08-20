package RobotModel;

/**
 * The meta variables for the genetic algorithm
 * @author Arthur Carroll
 */
public class EvoSimConfiguration implements java.io.Serializable {

    private int maxMutationAmmount;
    private double mutationProbability;
    private int populationSize;
    private int moveWeight = 1;
    private int collisionWeight = 1;
    private int stuckTimes = 1;
    private int knotPoints = 1;
    private boolean randomKnots = false;
    private boolean useWorstPath = false;

    public EvoSimConfiguration() {
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

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getCollisionWeight() {
        return collisionWeight;
    }

    public void setCollisionWeight(int collisionWeight) {
        this.collisionWeight = collisionWeight;
    }

    public int getMoveWeight() {
        return moveWeight;
    }

    public void setMoveWeight(int moveWeight) {
        this.moveWeight = moveWeight;
    }

    public int getStuckTimes() {
        return stuckTimes;
    }

    public void setStuckTimes(int stuckTimes) {
        this.stuckTimes = stuckTimes;
    }

    public int getKnotPoints() {
        return knotPoints;
    }

    public void setKnotPoints(int knotPoints) {
        this.knotPoints = knotPoints;
    }

    public boolean isRandomKnots() {
        return randomKnots;
    }

    public void setRandomKnots(boolean randomKnots) {
        this.randomKnots = randomKnots;
    }

    public boolean isUseWorstPath() {
        return useWorstPath;
    }

    public void setUseWorstPath(boolean useWorstPath) {
        this.useWorstPath = useWorstPath;
    }
}
