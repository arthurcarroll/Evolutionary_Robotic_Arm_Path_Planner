package main;

import RobotModel.PathConfiguration;
import RobotModel.PathPosition;
import RobotModel.Start_Goal_Info;
import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class Path {

    private ArrayList<PathPosition> pathPositions = new ArrayList<PathPosition>();
    private int nextPathPositionIndex = 0; // zero means not been synced with matrix yet
    private int collisionCount = 0;
    float cumulativeDistace = 0;
    int distanceReadings = 0;
    double totalDistanceMoved = 0;
    
    public Path(PathConfiguration pathConfig) {
        ArrayList<Start_Goal_Info> start_goal_list = pathConfig.getStart_Goal_List();


        PathPosition startPosition = new PathPosition();
        PathPosition endPosition = new PathPosition();


        for (Start_Goal_Info sgi : start_goal_list) {
            startPosition.addPathVariable(sgi.getStartPosition(), sgi.getJointVariableType());
            endPosition.addPathVariable(sgi.getGoalPosition(), sgi.getJointVariableType());
        }

        pathPositions.add(startPosition);
        pathPositions.add(endPosition);
    }

    // used for deepclone
    public Path() {
    }

    public ArrayList<PathPosition> getPathPositions() {
        return pathPositions;
    }

    public void setPathPositions(ArrayList<PathPosition> pathPositions) {
        this.pathPositions = pathPositions;
    }

    public int getNextPathPositionIndex() {
        return nextPathPositionIndex;
    }

    public void setNextPathPositionIndex(int currentPathPositionIndex) {
        this.nextPathPositionIndex = currentPathPositionIndex;
    }

    public PathPosition getNextPathPosition() {
        if (nextPathPositionIndex < pathPositions.size()) {
            return pathPositions.get(nextPathPositionIndex);
        } else {
            return null;
        }

    }

    public boolean reachedLastGoal() {
        if (nextPathPositionIndex == pathPositions.size()) {
            return true;
        }
        return false;
    }

    public void addIntermediateGoal(PathPosition pp) {
        pathPositions.add(pathPositions.size() - 1, pp);
    }

    public void printPath() {
        for (PathPosition pp : pathPositions) {
            System.out.println("----------------------");
            pp.printPath();
        }
    }

    public void addCollision() {
        collisionCount++;
    }

    public static Path deepClonePath(Path pathToClone) {
        Path newPath = new Path();
        // add all the path positions
        for (PathPosition pp : pathToClone.getPathPositions()) {
            newPath.getPathPositions().add(PathPosition.deepClone(pp));
        }

        return newPath;
    }

    public void resetFitness() {
        this.collisionCount = 0;
        cumulativeDistace = 0;
        distanceReadings = 0;
        totalDistanceMoved = 0;
    }

    public double getFitness(int collisionWeight, int moveWeight) {
        //double averageDistance = (cumulativeDistace / distanceReadings);
        //return cumulativeDistace + totalDistanceMoved;
        if (distanceReadings != 0) {
            return ((cumulativeDistace / distanceReadings) * collisionWeight) + (totalDistanceMoved * moveWeight);
        } else {
            return totalDistanceMoved * moveWeight;
        }
    }

    public void addDistance(float distance) {
        cumulativeDistace += distance;
        distanceReadings++;
    }

    public double getCollisions() {
        return cumulativeDistace;
    }
}
