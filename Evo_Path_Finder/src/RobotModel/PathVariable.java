package RobotModel;

/**
 *
 * @author Arthur Carroll
 */
public class PathVariable implements java.io.Serializable {

    private float value;
    private JointVariableType jointVariableType;

    public PathVariable(float value, JointVariableType jointVariableType) {
        this.value = value;
        this.jointVariableType = jointVariableType;
    }

    // only used for deep clone
    public PathVariable() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public JointVariableType getJointVariableType() {
        return jointVariableType;
    }

    public void setJointVariableType(JointVariableType jointVariableType) {
        this.jointVariableType = jointVariableType;
    }

    void print() {
        System.out.println("val: " + value + "  type: " + jointVariableType.toString());
    }

    public static PathVariable deepClone(PathVariable pathVariableToClone) {
        PathVariable pv = new PathVariable();
        pv.setValue(pathVariableToClone.getValue());
        pv.setJointVariableType(pathVariableToClone.getJointVariableType());

        return pv;
    }
}
