package RobotModel;

/**
 *
 * @author Arthur Carroll
 */
public class SimulationConfiguration implements java.io.Serializable {

    private RobotConfiguration robotConfig = new RobotConfiguration();
    private ObstacleConfiguration obstacleConfig = new ObstacleConfiguration();
    private EvoSimConfiguration evoConfig = new EvoSimConfiguration();
    private PathConfiguration pathConfig = new PathConfiguration();

    public SimulationConfiguration() {
    }

    public EvoSimConfiguration getEvoConfig() {
        return evoConfig;
    }

    public void setEvoConfig(EvoSimConfiguration evoConfig) {
        this.evoConfig = evoConfig;
    }

    public ObstacleConfiguration getObstacleConfig() {
        return obstacleConfig;
    }

    public void setObstacleConfig(ObstacleConfiguration obstacleConfig) {
        this.obstacleConfig = obstacleConfig;
    }

    public PathConfiguration getPathConfig() {
        return pathConfig;
    }

    public void setPathConfig(PathConfiguration pathConfig) {
        this.pathConfig = pathConfig;
    }

    public RobotConfiguration getRobotConfig() {
        return robotConfig;
    }

    public void setRobotConfig(RobotConfiguration robotConfig) {
        this.robotConfig = robotConfig;
    }
}
