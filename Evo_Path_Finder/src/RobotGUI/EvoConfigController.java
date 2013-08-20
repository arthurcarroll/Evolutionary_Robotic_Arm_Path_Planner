package fattaco.dyndns.org.evo_path_planner;

import RobotModel.EvoSimConfiguration;
import RobotModel.SimulationConfiguration;

/**
 *
 * @author Arthur Carroll
 */
public class EvoConfigController {

    void setEvoValues(SimulationConfiguration simConfig) {
    }

    void setEvoValues(RobotView view, SimulationConfiguration simConfig) {
        EvoSimConfiguration config = simConfig.getEvoConfig();
        config.setMaxMutationAmmount(Integer.parseInt(view.getMaxMutAmountTextField().getText()));
        config.setMutationProbability(Double.parseDouble(view.getMutProbTextField().getText()));
        config.setPopulationSize(Integer.parseInt(view.getPopSizeTextField().getText()));

        config.setMoveWeight(Integer.parseInt(view.getMoveWeightTextField().getText()));
        config.setCollisionWeight(Integer.parseInt(view.getCollisionWeightTextField().getText()));
        config.setStuckTimes(Integer.parseInt(view.getStuckTimesTextField().getText()));
        config.setKnotPoints(Integer.parseInt(view.getKnotPointsTextField().getText()));
        if (view.getRandomKnotPointsCheckBox().isSelected()) {
            config.setRandomKnots(true);
        } else {
            config.setRandomKnots(false);
        }

        if (view.getUseWorstPathCheckBox().isSelected()) {
            config.setUseWorstPath(true);
        } else {
            config.setUseWorstPath(false);
        }
    }
}
