package RobotModel;

import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class ObstacleConfiguration implements java.io.Serializable {

    ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();

    public ObstacleConfiguration() {
    }

    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public void setObstacleList(ArrayList<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }
}
