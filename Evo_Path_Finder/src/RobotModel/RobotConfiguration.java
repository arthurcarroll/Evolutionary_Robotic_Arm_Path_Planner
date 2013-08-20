package RobotModel;

import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class RobotConfiguration implements java.io.Serializable {

    private ArrayList<Joint> joints = new ArrayList<Joint>();

    public RobotConfiguration() {
    }

    public ArrayList<Joint> getJoints() {
        return joints;
    }

    public void setJoints(ArrayList<Joint> joints) {
        this.joints = joints;
    }
}
