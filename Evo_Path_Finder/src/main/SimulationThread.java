package main;

import RobotModel.SimulationConfiguration;

/**
 * A simple thread wrapper for Simulation since the event queue gets messed up
 * for some unknown reason when I don't do it this way.
 * @author Arthur Carroll
 */
public class SimulationThread implements Runnable {

    SimulationConfiguration simconfig;

    public SimulationThread(SimulationConfiguration simconfig) {
        this.simconfig = simconfig;
    }

    public void run() {
        // make the simulation here, it must extend Simple App
        Simulation simulation = new Simulation(simconfig);
        simulation.start();
    }
}
