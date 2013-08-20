package fattaco.dyndns.org.evo_path_planner;

import RobotModel.Start_Goal_Info;
import RobotModel.JointVariableType;
import javax.swing.JList;

/**
 *
 * @author Arthur Carroll
 */
public class Start_GoalConfigController {

    public Start_GoalConfigController() {
    }

    public void addJointVariableButtonCallback(SimulationConfigController simcontroller, RobotView view) {
        Start_Goal_Info nextStart_Goal = new Start_Goal_Info();
        try {
            String s = "Goal: " + simcontroller.getSimConfig().getPathConfig().getStart_Goal_List().size();

            // set joint identifier
            nextStart_Goal.setName(s);
            // start value
            nextStart_Goal.setStartPosition(Float.parseFloat(view.getAddJointVariableStartPosition().getText()));
            // goal value
            nextStart_Goal.setGoalPosition(Float.parseFloat(view.getAddJointVariableGoalPosition().getText()));

            String choice = (String) view.getJointVariableChoice().getSelectedItem();
            if (choice.compareToIgnoreCase("Theta i") == 0) {
                nextStart_Goal.setJointVariableType(JointVariableType.THETA_I);
            } else {
                nextStart_Goal.setJointVariableType(JointVariableType.D_I);
            }

            // add the start and goal to the list
            simcontroller.getSimConfig().getPathConfig().getStart_Goal_List().add(nextStart_Goal);
            // add to list start and goal model
            simcontroller.getJointVariablesListModel().addElement(s);
            // update the view
            view.validate();

        } catch (NumberFormatException ex) {
        }
    }

    public void jointVariableListCallback(SimulationConfigController simcontroller, RobotView view) {
        JList goalList = view.getJointVariablesList();
        int currentGoalNumber = goalList.getSelectedIndex();

        if (currentGoalNumber >= 0) {
            Start_Goal_Info currentStart_Goal = simcontroller.getSimConfig().getPathConfig().getStart_Goal_List().get(currentGoalNumber);

            view.getEditJointVariableStartPosition().setText(String.valueOf(currentStart_Goal.getStartPosition()));
            view.getEditJointVariableGoalPosition().setText(String.valueOf(currentStart_Goal.getGoalPosition()));

            if (currentStart_Goal.getJointVariableType() == JointVariableType.THETA_I) {
                view.getEditJointVariableChoice().setSelectedIndex(0);
            } else {
                view.getEditJointVariableChoice().setSelectedIndex(1);
            }


            view.validate();
        }
    }

    public void deleteJointVariableCallback(SimulationConfigController simcontroller, RobotView view) {
        // get the joint variable list
        JList jointVariableList = view.getJointVariablesList();
        int currentGoalNumber = jointVariableList.getSelectedIndex();

        // remove it from boths lists
        if (currentGoalNumber > -1 && currentGoalNumber < simcontroller.getJointVariablesListModel().size()
                && currentGoalNumber < simcontroller.getSimConfig().getPathConfig().getStart_Goal_List().size()) {
            // remove it from the model
            simcontroller.getSimConfig().getPathConfig().getStart_Goal_List().remove(currentGoalNumber);
            // remove it from the view
            simcontroller.getJointVariablesListModel().remove(currentGoalNumber);
        }
        view.validate();
    }

    public void updateJointVariableCallback(SimulationConfigController simcontroller, RobotView view) {
        JList jointVariablesList = view.getJointVariablesList();
        int currentGoalNumber = jointVariablesList.getSelectedIndex();
        if (currentGoalNumber >= 0) {
            Start_Goal_Info currentGoal = simcontroller.getSimConfig().getPathConfig().getStart_Goal_List().get(currentGoalNumber);

            // start position
            currentGoal.setStartPosition(Float.parseFloat(view.getEditJointVariableStartPosition().getText()));
            // goal postion
            currentGoal.setGoalPosition(Float.parseFloat(view.getEditJointVariableGoalPosition().getText()));
            // name

            String choice = (String) view.getJointVariableChoice().getSelectedItem();
            if (choice.compareToIgnoreCase("Theta i") == 0) {
                currentGoal.setJointVariableType(JointVariableType.THETA_I);
            } else {
                currentGoal.setJointVariableType(JointVariableType.D_I);
            }
            // update the view
            view.validate();
        }
    }
}
