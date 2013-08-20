package Tests;

import com.jme3.input.controls.ActionListener;
import main.Simulation;

/**
 *
 * @author Arthur Carroll
 */
public class InputHandler implements ActionListener {

    Simulation sim;

    public InputHandler(Simulation sim) {
        this.sim = sim;
    }

    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.compareToIgnoreCase("IncreaseSpeed") == 0) {
            sim.IncreaseSpeed();
        }

        if (name.compareToIgnoreCase("DecreaseSpeed") == 0) {
            sim.DecreaseSpeed();
        }
        if(name.compareToIgnoreCase("FaceRobot" ) == 0){
            sim.faceRobot();
        }
    }
}
