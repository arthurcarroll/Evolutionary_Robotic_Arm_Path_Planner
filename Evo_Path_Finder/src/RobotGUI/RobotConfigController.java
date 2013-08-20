package fattaco.dyndns.org.evo_path_planner;

import RobotModel.Joint;
import javax.swing.JList;

/**
 *
 * @author Arthur Carroll
 */
public class RobotConfigController {

    public RobotConfigController() {
    }

    public void addNewJointButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        Joint currentJoint = new Joint();
        try {

            String s = "Joint: " + simcontroller.getSimConfig().getRobotConfig().getJoints().size();
            // set joint identifier
            currentJoint.setName(s);
            // alphaP
            currentJoint.setAlphaP(Float.parseFloat(view.getAddAlphaP().getText()));
            // aP
            float aP = Float.parseFloat(view.getAddAP().getText());
            if (aP == 0) {
                aP = 0.1f;
            }
            currentJoint.setAP(aP);
            // di
            currentJoint.setDI(Float.parseFloat(view.getAddDi().getText()));
            // theta i
            currentJoint.setThetaI(Float.parseFloat(view.getAddThetai().getText()));
            // add to joint list
            simcontroller.getSimConfig().getRobotConfig().getJoints().add(currentJoint);
            // add to list jointListModel
            simcontroller.getJointListModel().addElement(s);
            // update the view
            view.validate();

        } catch (NumberFormatException ex) {
        }
    }

    public void updateJointButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        JList jointList = view.getJointList();
        int currentJointNumber = jointList.getSelectedIndex();
        if (currentJointNumber >= 0) {
            Joint currentJoint = simcontroller.getSimConfig().getRobotConfig().getJoints().get(currentJointNumber);

            // alphaP
            currentJoint.setAlphaP(Float.parseFloat(view.getEditAlphaP().getText()));
            // aP
            float aP = Float.parseFloat(view.getEditAP().getText());
            if (aP == 0) {
                aP = 0.1f;
            }
            currentJoint.setAP(aP);
            // di
            currentJoint.setDI(Float.parseFloat(view.getEditDi().getText()));
            // theta i
            currentJoint.setThetaI(Float.parseFloat(view.getEditThetai().getText()));
            // update the view
            view.validate();
        }

    }

    public void jointListCallback(SimulationConfigController simcontroller, RobotView view) {
        JList jointList = view.getJointList();
        int currentJointNumber = jointList.getSelectedIndex();

        if (currentJointNumber >= 0) {
            Joint currentJoint = simcontroller.getSimConfig().getRobotConfig().getJoints().get(currentJointNumber);

            view.getEditAlphaP().setText(String.valueOf(currentJoint.getAlphaP()));
            view.getEditAP().setText(String.valueOf(currentJoint.getAP()));
            view.getEditDi().setText(String.valueOf(currentJoint.getDI()));
            view.getEditThetai().setText(String.valueOf(currentJoint.getThetaI()));
            view.validate();
        }
    }

    public void deleteJointButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        JList jointList = view.getJointList();
        int currentJointNumber = jointList.getSelectedIndex();
        if (currentJointNumber > -1 && currentJointNumber < simcontroller.getJointListModel().size()
                && currentJointNumber < simcontroller.getSimConfig().getRobotConfig().getJoints().size()) {
            // remove from the model
            simcontroller.getSimConfig().getRobotConfig().getJoints().remove(currentJointNumber);
            // remove from the view
            simcontroller.getJointListModel().remove(currentJointNumber);
        }
        view.validate();
    }
}
