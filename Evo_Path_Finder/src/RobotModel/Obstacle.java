package RobotModel;

/**
 *
 * @author Arthur Carroll
 */
public class Obstacle implements java.io.Serializable {

    String name;
    private ObstacleType type;
    private Vector3fBean positionVector3f;
    private Vector3fBean sizeVector3f;
    private Vector3fBean rotationVector3f;

    public Obstacle() {
    }

    public Vector3fBean getPositionVector3f() {
        return positionVector3f;
    }

    public void setPositionVector3f(Vector3fBean positionVector3f) {
        this.positionVector3f = positionVector3f;
    }

    public Vector3fBean getRotationVector3f() {
        return rotationVector3f;
    }

    public void setRotationVector3f(Vector3fBean rotationVector3f) {
        this.rotationVector3f = rotationVector3f;
    }

    public Vector3fBean getSizeVector3f() {
        return sizeVector3f;
    }

    public void setSizeVector3f(Vector3fBean sizeVector3f) {
        this.sizeVector3f = sizeVector3f;
    }

    public ObstacleType getType() {
        return type;
    }

    public void setType(ObstacleType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
