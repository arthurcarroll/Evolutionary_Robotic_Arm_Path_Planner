package fattaco.dyndns.org.evo_path_planner;

import RobotModel.Start_Goal_Info;
import RobotModel.Joint;
import RobotModel.Obstacle;
import RobotModel.SimulationConfiguration;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Arthur Carroll
 */
public class SimulationConfigController {

    SimulationConfiguration simConfig = new SimulationConfiguration();
    DefaultListModel jointListModel;
    DefaultListModel jointVariablesListModel;
    DefaultListModel obstaclesListModel;
    boolean randomGoals = false;
    RobotConfigController robotConfigController = new RobotConfigController();
    Start_GoalConfigController goalConfigController = new Start_GoalConfigController();
    ObstacleConfigController obstacleController = new ObstacleConfigController();
    EvoConfigController evoController = new EvoConfigController();

    public void addNewJointButtonCallback(RobotView view) {
        robotConfigController.addNewJointButtonCallback(this, view);
    }

    public void updateJointButtonCallback(RobotView view) {
        robotConfigController.updateJointButtonCallback(this, view);
    }

    public void jointListCallback(RobotView view) {
        robotConfigController.jointListCallback(this, view);
    }

    public void deleteJointButtonCallback(RobotView view) {
        robotConfigController.deleteJointButtonCallback(this, view);
    }

    /****************************************************************
     * Adds a new joint variables to the start and goal list
     *
     * @param view The Robotview with needed properties
     */
    public void addJointVariableButtonCallback(RobotView view) {
        goalConfigController.addJointVariableButtonCallback(this, view);
    }

    public void jointVariableListCallback(RobotView view) {
        goalConfigController.jointVariableListCallback(this, view);
    }

    public void deleteJointVariableCallback(RobotView view) {
        goalConfigController.deleteJointVariableCallback(this, view);
    }

    public void updateJointVariableCallback(RobotView view) {
        goalConfigController.updateJointVariableCallback(this, view);
    }

    /**************************************************************
     *
     * obstacle methods
     * @param obstacleType
     * @param simcontroller
     * @param view
     */
    public void addNewObstacleButtonCallback(RobotView view) {
        obstacleController.addNewObstacleButtonCallback(this, view);
    }

    public void updateObstacleButtonCallback(RobotView view) {
        obstacleController.updateObstacleButtonCallback(this, view);
    }

    public void obstacleListCallback(RobotView view) {
        obstacleController.obstacleListCallback(this, view);
    }

    public void deleteObstacleButtonCallback(RobotView view) {
        obstacleController.deleteObstacleButtonCallback(this, view);
    }

    /**************************************************************
     * random methods
     *
     */
    public void setRandomGoals(boolean randomGoals) {
        System.out.println("random: " + randomGoals);
        this.randomGoals = randomGoals;
    }

    public void saveButtonClicked(RobotView view, String fileName) {
        try {
            // Serialize object into XML
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream(fileName)));
            encoder.writeObject(simConfig);
            encoder.close();
        } catch (FileNotFoundException e) {
        }
    }

    public void openButtonClicked(RobotView view, String filename) {
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
                    new FileInputStream(filename)));

            // MyClass is declared in Serializing a Bean to XML
            simConfig = (SimulationConfiguration) decoder.readObject();
            syncronizeListModels(view);
            view.validate();
            decoder.close();
        } catch (FileNotFoundException e) {
        }
    }

    public DefaultListModel getJointListModel() {
        return jointListModel;
    }

    public void setJointListModel(DefaultListModel jointListModel) {
        this.jointListModel = jointListModel;
    }

    public DefaultListModel getJointVariablesListModel() {
        return jointVariablesListModel;
    }

    public void setJointVariablesListModel(DefaultListModel jointVariablesListModel) {
        this.jointVariablesListModel = jointVariablesListModel;
    }

    public RobotConfigController getRobotConfigController() {
        return robotConfigController;
    }

    public void setRobotConfigController(RobotConfigController robotConfigController) {
        this.robotConfigController = robotConfigController;
    }

    public SimulationConfiguration getSimConfig() {
        return simConfig;
    }

    public void setSimConfig(SimulationConfiguration simConfig) {
        this.simConfig = simConfig;
    }

    public Start_GoalConfigController getGoalConfigController() {
        return goalConfigController;
    }

    public void setGoalConfigController(Start_GoalConfigController goalConfigController) {
        this.goalConfigController = goalConfigController;
    }

    public boolean isRandomGoals() {
        return randomGoals;
    }

    public void syncronizeListModels(RobotView view) {

        JList jointList = view.getJointList();
        JList jointVaraiblesList = view.getJointVariablesList();
        JList obstaclesList = view.getObstaclesList();
        // create the list models
        jointListModel = new DefaultListModel();
        jointVariablesListModel = new DefaultListModel();
        obstaclesListModel = new DefaultListModel();

        updateListModels();

        // set them up in the view
        jointList.setModel(jointListModel);
        jointVaraiblesList.setModel(jointVariablesListModel);
        obstaclesList.setModel(obstaclesListModel);

        // setup evo fields
        view.getMaxMutAmountTextField().setText(String.valueOf(simConfig.getEvoConfig().getMaxMutationAmmount()));
        view.getMutProbTextField().setText(String.valueOf(simConfig.getEvoConfig().getMutationProbability()));
        view.getPopSizeTextField().setText(String.valueOf(simConfig.getEvoConfig().getPopulationSize()));

        view.getMoveWeightTextField().setText(String.valueOf(simConfig.getEvoConfig().getMoveWeight()));
        view.getCollisionWeightTextField().setText(String.valueOf(simConfig.getEvoConfig().getCollisionWeight()));
        view.getStuckTimesTextField().setText(String.valueOf(simConfig.getEvoConfig().getStuckTimes()));
        view.getKnotPointsTextField().setText(String.valueOf(simConfig.getEvoConfig().getKnotPoints()));
        if (simConfig.getEvoConfig().isRandomKnots()) {
            view.getRandomKnotPointsCheckBox().setSelected(true);
        } else {
            view.getRandomKnotPointsCheckBox().setSelected(false);
        }

        if (simConfig.getEvoConfig().isUseWorstPath()) {
            view.getUseWorstPathCheckBox().setSelected(true);
        } else {
            view.getUseWorstPathCheckBox().setSelected(false);
        }
    }

    public void updateListModels() {
        for (Joint j : simConfig.getRobotConfig().getJoints()) {
            jointListModel.addElement(j.getName());
        }

        for (Start_Goal_Info g : simConfig.getPathConfig().getStart_Goal_List()) {
            jointVariablesListModel.addElement(g.getName());
        }

        for (Obstacle ob : simConfig.getObstacleConfig().getObstacleList()) {
            obstaclesListModel.addElement(ob.getName());
        }
    }

    public DefaultListModel getObstaclesListModel() {
        return obstaclesListModel;
    }

    public void setObstaclesListModel(DefaultListModel obstaclesListModel) {
        this.obstaclesListModel = obstaclesListModel;
    }

    void setEvoValues(RobotView aThis, SimulationConfiguration simConfig) {
        evoController.setEvoValues(aThis, simConfig);
    }
}
