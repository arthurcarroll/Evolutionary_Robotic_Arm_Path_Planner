package main;

import fattaco.dyndns.org.evo_path_planner.RobotView;
import RobotModel.SimulationConfiguration;

/**
 *
 * @author Arthur Carroll
 */
public class Driver {

    RobotView view;

    public static void main(String[] args) {
        Driver d = new Driver();
        d.showGUI();
    }

    public void runSimulation(SimulationConfiguration simConfig) {
        view.setVisible(false);
        view.dispose();


        Runnable simThread = new SimulationThread(view.getConfig());


        Thread t = new Thread(simThread);
        t.start();

    }

    public void showGUI() {
        view = new RobotView(this);
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                view.setVisible(true);
            }
        });
    }

    public void freeView() {
        view.dispose();
        view = null;
    }
}
