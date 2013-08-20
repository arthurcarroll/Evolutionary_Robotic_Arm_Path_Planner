package fattaco.dyndns.org.evo_path_planner;

import RobotModel.Obstacle;
import RobotModel.ObstacleType;
import RobotModel.Vector3fBean;
import javax.swing.JList;

/**
 *
 * @author Arthur Carroll
 */
public class ObstacleConfigController {

    public void addNewObstacleButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        Obstacle currentObstacle = new Obstacle();
        try {

            String s = "Obstacle: " + simcontroller.getSimConfig().getObstacleConfig().getObstacleList().size();
            // set joint identifier
            currentObstacle.setName(s);
            // position
            float xp = Float.parseFloat(view.getxObstaclePos().getText());
            float yp = Float.parseFloat(view.getyObstaclePos().getText());
            float zp = Float.parseFloat(view.getzObstaclePos().getText());
            currentObstacle.setPositionVector3f(Vector3fBean.makeVector(xp, yp, zp));

            // size vector
            float xs = Float.parseFloat(view.getxObstacleSize().getText());
            float ys = Float.parseFloat(view.getyObstacleSize().getText());
            float zs = Float.parseFloat(view.getzObstacleSize().getText());
            currentObstacle.setSizeVector3f(Vector3fBean.makeVector(xs, ys, zs));

            float xr = 0;
            float yr = 0;
            float zr = 0;

            // only use the rotation values if this is a square
            if (view.getIsSphereObstacle().isSelected()) {
                currentObstacle.setType(ObstacleType.SPHERE);
            } else {
                currentObstacle.setType(ObstacleType.SQUARE);
                // rotation vector
                xr = Float.parseFloat(view.getxObstacleRot().getText());
                yr = Float.parseFloat(view.getyObstacleRot().getText());
                zr = Float.parseFloat(view.getzObstacleRot().getText());
            }

            currentObstacle.setRotationVector3f(Vector3fBean.makeVector(xr, yr, zr));
            // add to obstacle list
            simcontroller.getSimConfig().getObstacleConfig().getObstacleList().add(currentObstacle);
            // add to list jointListModel
            simcontroller.getObstaclesListModel().addElement(s);
            // update the view
            view.validate();

        } catch (NumberFormatException ex) {
        }
    }

    public void updateObstacleButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        JList obstacleList = view.getObstaclesList();
        int currentObstacleNumber = obstacleList.getSelectedIndex();
        if (currentObstacleNumber >= 0) {
            Obstacle currentObstacle = simcontroller.getSimConfig().getObstacleConfig().getObstacleList().get(currentObstacleNumber);
            // position
            float xp = Float.parseFloat(view.getxEditObstaclePos().getText());
            float yp = Float.parseFloat(view.getyEditObstaclePos().getText());
            float zp = Float.parseFloat(view.getzEditObstaclePos().getText());
            currentObstacle.setPositionVector3f(Vector3fBean.makeVector(xp, yp, zp));

            // size vector
            float xs = Float.parseFloat(view.getxEditObstacleSize().getText());
            float ys = Float.parseFloat(view.getyEditObstacleSize().getText());
            float zs = Float.parseFloat(view.getzEditObstacleSize().getText());
            currentObstacle.setSizeVector3f(Vector3fBean.makeVector(xs, ys, zs));

            float xr = 0;
            float yr = 0;
            float zr = 0;

            // only use the rotation values if this is a square
            if (view.getEditObstacleType().getText().compareToIgnoreCase("sphere") == 0) {
                currentObstacle.setType(ObstacleType.SPHERE);
            } else {
                currentObstacle.setType(ObstacleType.SQUARE);
                // rotation vector
                xr = Float.parseFloat(view.getxEditObstacleRot().getText());
                yr = Float.parseFloat(view.getyEditObstacleRot().getText());
                zr = Float.parseFloat(view.getzEditObstacleRot().getText());
            }
            currentObstacle.setRotationVector3f(Vector3fBean.makeVector(xr, yr, zr));
        }

        view.validate();
    }

    public void obstacleListCallback(SimulationConfigController simcontroller, RobotView view) {
        JList obstacleList = view.getObstaclesList();
        int currentObstacleNumber = obstacleList.getSelectedIndex();

        if (currentObstacleNumber >= 0) {
            Obstacle currentObstacle = simcontroller.getSimConfig().getObstacleConfig().getObstacleList().get(currentObstacleNumber);

            // position
            view.getxEditObstaclePos().setText(String.valueOf(currentObstacle.getPositionVector3f().getX()));
            view.getyEditObstaclePos().setText(String.valueOf(currentObstacle.getPositionVector3f().getY()));
            view.getzEditObstaclePos().setText(String.valueOf(currentObstacle.getPositionVector3f().getZ()));

            view.getxEditObstacleSize().setText(String.valueOf(currentObstacle.getSizeVector3f().getX()));
            view.getyEditObstacleSize().setText(String.valueOf(currentObstacle.getSizeVector3f().getY()));
            view.getzEditObstacleSize().setText(String.valueOf(currentObstacle.getSizeVector3f().getZ()));

            view.getxEditObstacleRot().setText(String.valueOf(currentObstacle.getRotationVector3f().getX()));
            view.getyEditObstacleRot().setText(String.valueOf(currentObstacle.getRotationVector3f().getY()));
            view.getzEditObstacleRot().setText(String.valueOf(currentObstacle.getRotationVector3f().getZ()));

            if (currentObstacle.getType() == ObstacleType.SQUARE) {
                view.getEditObstacleType().setText("Square");
            } else {
                view.getEditObstacleType().setText("Sphere");
            }
            view.validate();
        }
    }

    public void deleteObstacleButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        JList obstacleList = view.getObstaclesList();
        int currentObstacleNumber = obstacleList.getSelectedIndex();

        if (currentObstacleNumber > -1 && currentObstacleNumber < simcontroller.getObstaclesListModel().size()
                && currentObstacleNumber < simcontroller.getSimConfig().getObstacleConfig().getObstacleList().size()) {
            simcontroller.getSimConfig().getObstacleConfig().getObstacleList().remove(currentObstacleNumber);
            simcontroller.getObstaclesListModel().remove(currentObstacleNumber);
        }
    }
}
