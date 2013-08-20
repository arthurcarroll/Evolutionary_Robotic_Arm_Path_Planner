package Tests;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author Arthur Carroll
 */
public class PhysicsTest {

    RobotSim app;
    int currentBox = 0;

    public PhysicsTest(RobotSim app) {
        this.app = app;
    }

    public final void makeBoxes(Vector3f pos) {
        SimpleApplication sapp = (SimpleApplication) app;
        Box box = new Box(pos, 2, 2, 2);
        String s = "box" + Integer.toString(currentBox);
        currentBox++;
        Geometry geo = new Geometry(s, box);

        Material wall_mat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        wall_mat.setColor("m_Color", ColorRGBA.Red);
        geo.setMaterial(wall_mat);
        sapp.getRootNode().attachChild(geo);

        RigidBodyControl brick_phy = new RigidBodyControl(0f);

        /** Add physical brick to physics space. */
        geo.addControl(brick_phy);
        app.bulletapp.getPhysicsSpace().add(brick_phy);
    }

    public final void makeFloor() {
        SimpleApplication sapp = (SimpleApplication) app;
        Box box = new Box(new Vector3f(-10f, 0, -10f), 20f, 0.1f, 20f);
        Geometry geo = new Geometry("floor", box);

        Material wall_mat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        wall_mat.setColor("m_Color", ColorRGBA.Blue);

        geo.setMaterial(wall_mat);
        sapp.getRootNode().attachChild(geo);

        RigidBodyControl brick_phy = new RigidBodyControl(0f);

        // add the physics control to the geometry
        geo.addControl(brick_phy);
        /** Add physical brick to physics space. */
        app.bulletapp.getPhysicsSpace().add(brick_phy);
    }

    public final void ghostTest() {
        Box box2 = new Box(new Vector3f(1, 3, 1), 1, 1, 1);
        Geometry green = new Geometry("Box", box2);
        Material mat2 = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Green);
        green.setMaterial(mat2);

        GhostControl gc = new GhostControl(new BoxCollisionShape(new Vector3f(1,1,1)));

        green.addControl(gc);
        app.bulletapp.getPhysicsSpace().add(gc);

    }
}
