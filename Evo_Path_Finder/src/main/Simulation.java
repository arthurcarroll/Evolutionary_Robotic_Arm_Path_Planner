package main;

import RobotModel.Obstacle;
import RobotModel.ObstacleConfiguration;
import RobotModel.ObstacleType;
import com.jme3.app.SimpleApplication;
import RobotModel.SimulationConfiguration;
import Tests.InputHandler;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace.BroadphaseType;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur Carroll
 */
public class Simulation extends SimpleApplication {

    BulletAppState bulletAppState;
    WireProcessor wireProcessor;
    SimulationConfiguration simConfig;
    Population population;
    ArrayList<GhostControl> ghosts = new ArrayList<GhostControl>();
    protected BitmapText gensText;
    protected BitmapText averageFitnessText;
    protected BitmapText maxFitnessText;
    protected BitmapText currentSpeedText;
    protected BitmapText controlsText;
    protected BitmapText pathText;

    public Simulation(SimulationConfiguration config) {
        this.simConfig = config;
    }

    @Override
    public void simpleInitApp() {
        inputManager.setCursorVisible(true);
        
        this.setDisplayFps(false);
        this.setShowSettings(false);
        guiNode.detachChild(this.statsView);

        // setup the physics engine
        bulletAppState = new BulletAppState();
        bulletAppState.setThreadingType(BulletAppState.ThreadingType.PARALLEL);
        bulletAppState.setBroadphaseType(BroadphaseType.AXIS_SWEEP_3_32);
        stateManager.attach(bulletAppState);

        // setup the physics space
        bulletAppState.getPhysicsSpace().setMaxSubSteps(1);
        bulletAppState.getPhysicsSpace().enableDebug(assetManager);
        bulletAppState.getPhysicsSpace().setGravity(Vector3f.ZERO);



        // move the camera a little faster
        this.flyCam.setMoveSpeed(20.0f);
        this.flyCam.setRotationSpeed(2.5f);

        wireProcessor = new WireProcessor(assetManager, ColorRGBA.Blue);
        //viewPort.addProcessor(wireProcessor);

        // You must add a light to make the model visible
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);

        // make a point light
        PointLight pointLight = new PointLight();
        pointLight.setPosition(new Vector3f(0.0f, 0.0f, 0.0f));
        pointLight.setRadius(10.0f);
        rootNode.addLight(pointLight);


        // make the obstacles
        loadObstacles(simConfig.getObstacleConfig());

        population = new Population(bulletAppState);
        population.setup(this, bulletAppState, simConfig);
        population.findPath();
        population.setGhosts(ghosts);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
        }

        InputHandler inputHandler = new InputHandler(this);
        inputManager.addMapping("IncreaseSpeed", new KeyTrigger(KeyInput.KEY_EQUALS));
        inputManager.addMapping("DecreaseSpeed", new KeyTrigger(KeyInput.KEY_MINUS));
        inputManager.addMapping("FaceRobot", new KeyTrigger(KeyInput.KEY_F));

        inputManager.addListener(inputHandler, new String[]{"IncreaseSpeed", "DecreaseSpeed", "FaceRobot"});

        loadText();
    }

    @Override
    public void simpleUpdate(float tpf) {
        population.update(tpf);
        updateText();
        // bulletAppState.update(tpf);
    }

    private void loadObstacles(ObstacleConfiguration oc) {
        for (Obstacle ob : oc.getObstacleList()) {
            if (ob.getType() == ObstacleType.SQUARE) {
                initGhostObject(ob.getSizeVector3f().toJMEVector(), ob.getRotationVector3f().toJMEVector(),
                        ob.getPositionVector3f().toJMEVector());
            }

        }
    }

    private void initGhostObject(Vector3f size, Vector3f rot, Vector3f pos) {

        Material mat = new Material(getAssetManager(), "Common/MatDefs/Misc/WireColor.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        BoxCollisionShape bs = new BoxCollisionShape(size);

        GhostControl ghostControl = new GhostControl(bs);

        Node node = new Node("obstacle");
        node.addControl(ghostControl);
        node.setLocalTranslation(pos);
        node.getLocalRotation().fromAngles(rot.getX(), rot.getY(), rot.getZ());
        rootNode.attachChild(node);
        bulletAppState.getPhysicsSpace().add(ghostControl);

        ghosts.add(ghostControl);
    }

    public void IncreaseSpeed() {
        population.getBaseRobot().IncreaseSpeed();
    }

    public void DecreaseSpeed() {
        population.getBaseRobot().DecreaseSpeed();
    }

    public void loadText() {
        gensText = new BitmapText(guiFont, false);
        gensText.setLocalTranslation(0, this.settings.getHeight() - 10, 0);
        guiNode.attachChild(gensText);

        averageFitnessText = new BitmapText(guiFont, false);
        averageFitnessText.setLocalTranslation(0, this.settings.getHeight() - 30, 0);
        guiNode.attachChild(averageFitnessText);


        maxFitnessText = new BitmapText(guiFont, false);
        maxFitnessText.setLocalTranslation(0, this.settings.getHeight() - 50, 0);
        guiNode.attachChild(maxFitnessText);

        currentSpeedText = new BitmapText(guiFont, false);
        currentSpeedText.setLocalTranslation(0, this.settings.getHeight() - 70, 0);
        guiNode.attachChild(currentSpeedText);

        pathText = new BitmapText(guiFont, false);
        pathText.setLocalTranslation(0, this.settings.getHeight() - 90, 0);
        guiNode.attachChild(pathText);

        controlsText = new BitmapText(guiFont, false);
        controlsText.setText("Controls:\n WASD = move\n Mouse or U,D,L,R = look around\n f= face origin\n +/- = change speed");
        controlsText.setLocalTranslation(0, controlsText.getLineHeight() * 5, 0);
        guiNode.attachChild(controlsText);

    }

    public void updateText() {
        gensText.setText("Generations: " + population.getGenerations());
        averageFitnessText.setText("Average Fitness: " + population.getAverageFitness());
        maxFitnessText.setText("Best Fitness(lower=better): " + population.getMaxFitness());
        currentSpeedText.setText("Current Speed: " + population.getBaseRobot().getMoveSpeed());
        pathText.setText("Child: " + population.getActivepath() + "/" + population.getPaths().size());
    }

    public void faceRobot() {
        flyCam.getCam().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }
}
