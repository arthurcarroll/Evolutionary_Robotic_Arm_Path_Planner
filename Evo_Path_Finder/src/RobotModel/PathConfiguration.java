package RobotModel;

import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class PathConfiguration implements java.io.Serializable {

    ArrayList<Start_Goal_Info> Start_Goal_List = new ArrayList<Start_Goal_Info>();

    public PathConfiguration() {
    }

    public ArrayList<Start_Goal_Info> getStart_Goal_List() {
        return Start_Goal_List;
    }

    public void setStart_Goal_List(ArrayList<Start_Goal_Info> Start_Goal_List) {
        this.Start_Goal_List = Start_Goal_List;
    }
}
