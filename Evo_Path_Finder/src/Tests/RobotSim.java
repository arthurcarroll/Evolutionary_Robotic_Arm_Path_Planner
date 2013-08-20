package Tests;

/**
 *
 * @author Arthur Carroll
 */
import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import main.CollisionHandler;
import main.WireProcessor;

/**
 * Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys.
 */
public class RobotSim extends SimpleApplication {

    BulletAppState bulletapp;
    FileLocator fl;
    Spatial robot = null;
    long startTime = 0;
    WireProcessor p;
    boolean removed = false;
    public PhysicsTest physicsTest;
    static RobotSim app;

    public static void main(String[] args) {
        app = new RobotSim();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //InputHandler hand = new InputHandler(this);
        bulletapp = new BulletAppState();
        stateManager.attach(bulletapp);
        bulletapp.getPhysicsSpace().addCollisionListener(new CollisionHandler());
        loadFiles();


        this.flyCam.setMoveSpeed(20.0f);
        this.flyCam.setRotationSpeed(2.5f);
        //loadRobot();

        physicsTest = new PhysicsTest(this);

        physicsTest.makeFloor();
        physicsTest.makeBoxes(new Vector3f(1, 0.2f, 1));
        physicsTest.ghostTest();
        loadLights();

        // draw only the wireframe version of the models
        p = new WireProcessor(assetManager, ColorRGBA.Blue);
        viewPort.addProcessor(p);
        startTime = System.currentTimeMillis();

        inputManager.addMapping("AddBox", new KeyTrigger(KeyInput.KEY_SPACE),
                new MouseButtonTrigger(MouseInput.BUTTON_LEFT));

        //inputManager.addListener(hand, new String[]{"AddBox"});
    }

    @Override
    public void simpleUpdate(float tpf) {
        bulletapp.update(tpf);
        //robot.rotate(0, 2 * tpf, 0);
        if (System.currentTimeMillis() - startTime > 10000 && !removed) {
            viewPort.removeProcessor(p);
            removed = true;
        }


    }

    public void loadRobot() {
        // Load a model from test_data (OgreXML + material + texture)
        robot = assetManager.loadModel("robotArm.mesh.xml");
        //robot.scale(0.05f, 0.05f, 0.05f);
        robot.rotate(0.0f, -3.0f, 0.0f);
        robot.setLocalTranslation(0.0f, -5.0f, -2.0f);
        rootNode.attachChild(robot);

    }

    public void loadFiles() {
        String curDir = System.getProperty("user.dir");
        fl = new FileLocator();
        fl.setRootPath(curDir);
        assetManager.registerLocator(curDir, "com.jme3.asset.plugins.FileLocator");
    }

    public void loadLights() {
        // You must add a light to make the model visible
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);

        // make a point light
        PointLight pointLight = new PointLight();
        pointLight.setPosition(new Vector3f(0.0f, 0.0f, 0.0f));
        pointLight.setRadius(10.0f);
        rootNode.addLight(pointLight);
    }
}
