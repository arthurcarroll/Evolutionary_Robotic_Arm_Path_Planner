package Tests;

import RobotMatrix.HTransformMatrix;
import RobotMatrix.VisualMatrixChain;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import main.WireProcessor;

/**
 *
 * @author Arthur Carroll
 */
public class MatrixTest extends SimpleApplication {

    VisualMatrixChain chain;
    WireProcessor p;
    Spatial robot;
    HTransformMatrix m0;
    HTransformMatrix m1;
    HTransformMatrix m2;
    HTransformMatrix m3 = null;
    Box b;
    private BulletAppState bulletAppState;

    public static void main(String[] args) {
        MatrixTest t = new MatrixTest();
        t.start();
    }

    @Override
    public void simpleInitApp() {
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().enableDebug(assetManager);

        // move the camera a little faster
        this.flyCam.setMoveSpeed(20.0f);
        this.flyCam.setRotationSpeed(2.5f);

        p = new WireProcessor(assetManager, ColorRGBA.Blue);
        //viewPort.addProcessor(p);

        makeChain();
        //loadTestBox();

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

    @Override
    public void simpleUpdate(float tpf) {
        m1.theta += tpf * 20;
        m1.populateMatrixValues(m1.alphaP, m1.aP, m1.d, m1.theta);

        m0.theta += tpf * 2.5f;
        m0.populateMatrixValues(m0.alphaP, m0.aP, m0.d, m0.theta);
        chain.update();

        m2.theta -= tpf * 2.5f;
        m2.populateMatrixValues(m2.alphaP, m2.aP, m2.d, m2.theta);
        chain.update();
        //robot.rotate(0, 0, 2 * tpf);

        if (m3 != null) {
            m3.theta += tpf * 2.5f;
            m3.populateMatrixValues(m3.alphaP, m3.aP, m3.d, m3.theta);
            chain.update();
        }
    }

    public void makeChain() {
        chain = new VisualMatrixChain(this, bulletAppState);
        m0 = new HTransformMatrix(0, 0, 0, 0);
        m1 = new HTransformMatrix(0, 6, 0, 0);
        m2 = new HTransformMatrix(0, 1, 0, 0);
        m3 = new HTransformMatrix(0, 4, 0, 0);

        chain.add(m0);
        chain.add(m1);
        chain.add(m2);
        chain.add(m3);

        chain.makeLines();
    }

    void loadTestBox() {
        float scale = 0.1524f;
        String curDir = System.getProperty("user.dir");
        FileLocator fl = new FileLocator();
        fl.setRootPath(curDir);
        assetManager.registerLocator(curDir, "com.jme3.asset.plugins.FileLocator");
        // Load a model from test_data (OgreXML + material + texture)
        robot = assetManager.loadModel("testBox.mesh.xml");
        robot.scale((1 / scale), (1 / scale), (1 / scale));
        //robot.rotate(0.0f, -3.0f, 0.0f);
        robot.setLocalTranslation(0.0f, -1.0f, 0.0f);
        rootNode.attachChild(robot);
        System.out.println("robot size: " + robot.getWorldBound().toString());
    }
}
