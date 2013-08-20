package main;

import RobotMatrix.HTransformMatrix;
import RobotMatrix.VisualMatrixChain;
import RobotModel.Joint;
import RobotModel.JointVariableType;
import RobotModel.PathPosition;
import RobotModel.PathVariable;
import RobotModel.RobotConfiguration;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class Robot {

    boolean moving = false;
    boolean atStart = true;
    boolean reachedGoal = false;
    // the current position of this robot
    VisualMatrixChain currentPosition;
    Path path;
    private float moveSpeed = 2500.0f;

    public Robot(SimpleApplication app, BulletAppState bApp, RobotConfiguration robotConfig) {
        currentPosition = new VisualMatrixChain(app, bApp);
        for (Joint j : robotConfig.getJoints()) {
            HTransformMatrix nextMatrix = new HTransformMatrix(j.getAlphaP(), j.getAP(), j.getDI(), j.getThetaI());
            currentPosition.add(nextMatrix);
        }
        currentPosition.makeLines();
    }

    public void update(float tpf) {
        // move a little to the goal position
        // angles are only allowed to be positive so no need to worry about negative angles
        PathPosition nextPathPosition = path.getNextPathPosition();
        if (!reachedPathPoint(nextPathPosition, currentPosition) && moving) {
            move(tpf);
        } else {

            path.setNextPathPositionIndex(path.getNextPathPositionIndex() + 1);
            if (path.reachedLastGoal()) {
                moving = false;
                reachedGoal = true;
            }
        }

        // update the view
        for (HTransformMatrix htm : currentPosition.getChain()) {
            htm.populateMatrixValues(htm.alphaP, htm.aP, htm.d, htm.theta);
            currentPosition.update();
        }

    }

    public void setPath(Path path) {
        this.path = path;

        if (!path.getPathPositions().isEmpty()) {
            PathPosition startPosition = path.getPathPositions().get(0);

            for (PathVariable pv : startPosition.getPathVariables()) {
                // only theta_i works right now
                if (pv.getJointVariableType() == JointVariableType.THETA_I) {
                    HTransformMatrix htm = currentPosition.getChain().get(startPosition.getPathVariables().indexOf(pv));
                    htm.populateMatrixValues(htm.alphaP, htm.aP, htm.d, pv.getValue());

                }
            }
        }

        currentPosition.update();
        path.setNextPathPositionIndex(1);
        atStart = true;
        reachedGoal = false;
    }

    private static boolean reachedPathPoint(PathPosition goalPosition, VisualMatrixChain chain) {
        if (goalPosition == null) {
            return true;
        }
        // check every path variable against its matrix counterpart to see if it has reached it yet
        for (int i = 0; i < goalPosition.getPathVariables().size(); i++) {
            PathVariable pv = goalPosition.getPathVariables().get(i);

            if (pv.getJointVariableType() == JointVariableType.THETA_I) {
                if (pv.getValue() != chain.getChain().get(i).theta) {
                    return false;
                }
            } else if (pv.getJointVariableType() == JointVariableType.D_I) {
                return false;
            }

        }
        return true;
    }

    public double roundDouble(double value) {
        DecimalFormat dc = new DecimalFormat("###.#####");
        return Double.parseDouble(dc.format(value));
    }

    public static boolean closeEnough(double one, double two) {
        if (Math.abs(one - two) < 1.5) {
            return true;
        } else {
            return false;
        }
    }

    private void move(float tpf) {
        atStart = false;
        for (int i = 0; i < path.getNextPathPosition().getPathVariables().size(); i++) {
            PathVariable pv = path.getNextPathPosition().getPathVariables().get(i);
            HTransformMatrix htm = currentPosition.getChain().get(i);
            //System.out.println("pv: " + pv.getValue() + "  htm: " + htm.theta);

            double moveAmmount = moveSpeed * tpf;

            if (htm.theta < pv.getValue()) {
                htm.theta += moveAmmount;
            }
            if (htm.theta > pv.getValue()) {
                htm.theta -= moveAmmount;
            }
            path.totalDistanceMoved += moveAmmount;

            if (closeEnough(htm.theta, pv.getValue())) {
                htm.theta = pv.getValue();
            }
        }
    }

    public void seekGoal() {
        moving = true;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public VisualMatrixChain getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(VisualMatrixChain currentPosition) {
        this.currentPosition = currentPosition;
    }

    void updateFitness(ArrayList<GhostControl> ghosts) {
        for (GhostControl gc : ghosts) {
            Vector3f g = gc.getPhysicsLocation();
            for (LineShapeWrapper l : currentPosition.getLines()) {
                float distance = g.distance(l.getBox_phy().getPhysicsLocation());
                path.addDistance(1/distance);
            }
        }
    }

    void IncreaseSpeed() {
        moveSpeed += 50;
        if (moveSpeed > 2000) {
            moveSpeed = 2000;
        }
    }

    void DecreaseSpeed() {
        moveSpeed -= 50;
        if (moveSpeed <= 0) {
            moveSpeed = 1;
        }
    }
}
