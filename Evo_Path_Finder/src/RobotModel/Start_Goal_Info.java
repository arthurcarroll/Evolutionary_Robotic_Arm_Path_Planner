package RobotModel;

/**
 *
 * @author Arthur Carroll
 */
public class Start_Goal_Info implements java.io.Serializable {

    private String name;
    private float startPosition;
    private float goalPosition;
    private JointVariableType jointVariableType;

    public Start_Goal_Info() {
    }

    public float getGoalPosition() {
        return goalPosition;
    }

    public void setGoalPosition(float goalPosition) {
        this.goalPosition = goalPosition;
    }

    public JointVariableType getJointVariableType() {
        return jointVariableType;
    }

    public void setJointVariableType(JointVariableType jointVariableType) {
        this.jointVariableType = jointVariableType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(float startPosition) {
        this.startPosition = startPosition;
    }
}
