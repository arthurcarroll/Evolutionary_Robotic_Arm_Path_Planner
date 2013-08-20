package main;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Line;

/**
 *
 * @author Arthur Carroll
 */
public class LineShapeWrapper {

    Line l;
    Geometry lineGeo;
    RigidBodyControl box_phy;
    Spatial start;
    Spatial end;
    SimpleApplication app;
    BulletAppState bApp;
    Geometry box_geo;
    boolean firstUpdate = true;

    public LineShapeWrapper(BulletAppState bApp, SimpleApplication app, Spatial start, Spatial end) {
        this.start = start;
        this.end = end;
        this.app = app;
        this.bApp = bApp;
        create();
    }

    private void create() {
        l = new Line(start.getLocalTranslation(), end.getLocalTranslation());

        lineGeo = new Geometry("line", l);
        Material mat1 = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Red);
        lineGeo.setMaterial(mat1);
        app.getRootNode().attachChild(lineGeo);
        updateLineOnly();


    }

    public void update() {
        l.updatePoints(start.getLocalTranslation(), end.getLocalTranslation());
        if (firstUpdate) {
            firstUpdate = false;
            /** make the physics box for this line */
            makeBox(MathLine.getCenter(start, end), MathLine.getDistance(start, end));
        } else {
            box_phy.setPhysicsLocation(MathLine.getCenter(start, end));
            box_phy.setPhysicsRotation(start.getLocalRotation());
            box_phy.setEnabled(true);

        }
    }

    public void updateLineOnly() {
        l.updatePoints(start.getLocalTranslation(), end.getLocalTranslation());
    }

    public void remove() {
        app.getRootNode().detachChild(lineGeo);
        if (box_geo != null && box_phy != null) {
            app.getRootNode().detachChild(box_geo);
            bApp.getPhysicsSpace().remove(box_phy);
        }
    }

    public void makeBox(Vector3f center, float length) {
        Box box = new Box(Vector3f.ZERO, length / 2, 0.01f, 0.01f);

        box_geo = new Geometry("robot", box);
        Material mat1 = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        box_geo.setMaterial(mat1);
        app.getRootNode().attachChild(box_geo);

        /** Position the box geometry and activate shadows */
        box_geo.setLocalTranslation(center);
        box_geo.setShadowMode(ShadowMode.CastAndReceive);

        /** Make box physical with a mass > 0.0f. */
        box_phy = new RigidBodyControl(0);

        /** Add physical box to physics space. */
        box_geo.addControl(box_phy);
        bApp.getPhysicsSpace().add(box_phy);
    }

    public RigidBodyControl getBox_phy() {
        return box_phy;
    }

    public void setBox_phy(RigidBodyControl box_phy) {
        this.box_phy = box_phy;
    }
}
