package RobotMatrix;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import main.LineShapeWrapper;

import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 */
public class VisualMatrixChain extends MatrixChain {

    // the central app to add joints to
    SimpleApplication app;
    BulletAppState bApp;
    // one box per matrix in this chain
    ArrayList<Spatial> joints = new ArrayList<Spatial>();
    ArrayList<LineShapeWrapper> lines = new ArrayList<LineShapeWrapper>();
    ArrayList<ColorRGBA> colors = new ArrayList<ColorRGBA>();
    int currentColor = 0;

    public VisualMatrixChain(SimpleApplication app, BulletAppState bApp) {
        super();
        this.app = app;
        this.bApp = bApp;
        makeColors();
    }

    public void update() {
        for (int i = 0; i < chain.size(); i++) {
            syncBox(i);
        }
        // sync all joints to thier parent matrix positions
        for (LineShapeWrapper lsw : lines) {
            lsw.update();
        }
    }

    @Override
    public void add(HTransformMatrix m) {
        super.add(m);
        makeBox(m);
    }

    public void syncBox(int matrixNumber) {
        HTransformMatrix mt = this.getTransfromZeroToN(matrixNumber, false);
        Spatial g = joints.get(matrixNumber);
        Vector3f pos = new Vector3f((float) mt.getX(), (float) mt.getY(), (float) mt.getZ());
        g.setLocalTranslation(pos);
        g.setLocalRotation(MatrixUtilities.copyRotationMatrixToJMERotationMatrix(mt));
    }

    private void makeBox(HTransformMatrix m) {
        // just make a generic box of the correct size, it will be correctly positioned
        // every time update is called
        float scale = 0.02f;
        Box box1 = new Box(new Vector3f(0, 0, 0), scale, scale, scale);
        Geometry boxGeo = new Geometry("Box", box1);
        Material mat1 = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", nextColor());
        boxGeo.setMaterial(mat1);
        app.getRootNode().attachChild(boxGeo);
        joints.add(boxGeo);
    }

    private void makeColors() {
        colors.add(ColorRGBA.Blue);
        colors.add(ColorRGBA.Green);
        colors.add(ColorRGBA.Orange);
        colors.add(ColorRGBA.Magenta);
        colors.add(ColorRGBA.Yellow);
        colors.add(ColorRGBA.White);
    }

    private ColorRGBA nextColor() {
        if (currentColor == colors.size()) {
            currentColor = 0;
        }

        return colors.get(currentColor++);
    }

    public void makeLines() {
        // clear the lines list
        for (LineShapeWrapper l : lines) {
            l.remove();

        }

        // empty the list and start over
        lines.clear();

        for (int i = 1; i < joints.size(); i++) {
            LineShapeWrapper lsw = new LineShapeWrapper(bApp, app, joints.get(i - 1), joints.get(i));
            lines.add(lsw);
        }
    }

    public ArrayList<Spatial> getJoints() {
        return joints;
    }

    public void setJoints(ArrayList<Spatial> joints) {
        this.joints = joints;
    }

    public ArrayList<LineShapeWrapper> getLines() {
        return lines;
    }

    public void setLines(ArrayList<LineShapeWrapper> lines) {
        this.lines = lines;
    }
}
