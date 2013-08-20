package RobotModel;

import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class PathPosition {

    ArrayList<PathVariable> pathVariables = new ArrayList<PathVariable>();

    public PathPosition() {
    }

    public void addPathVariable(float pathF, JointVariableType jointVariableType) {
        pathVariables.add(new PathVariable(pathF, jointVariableType));
    }

    public void addPathVariable(PathVariable pv) {
        pathVariables.add(pv);
    }

    public ArrayList<PathVariable> getPathVariables() {
        return pathVariables;
    }

    public void setPathVariables(ArrayList<PathVariable> pathVariables) {
        this.pathVariables = pathVariables;
    }

    public void printPath() {
        for (PathVariable pv : pathVariables) {
            pv.print();
        }
    }

    public static PathPosition deepClone(PathPosition pathPositioToClone) {
        PathPosition pp = new PathPosition();
        for (PathVariable pv : pathPositioToClone.getPathVariables()) {
            pp.addPathVariable(PathVariable.deepClone(pv));
        }

        return pp;
    }
}
