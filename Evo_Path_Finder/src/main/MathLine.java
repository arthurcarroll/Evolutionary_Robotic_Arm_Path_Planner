package main;

import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

/**
 *
 * @author Arthur Carroll
 */
public class MathLine {

    public static Vector3f getCenter(Spatial start, Spatial end) {
        float x1 = start.getLocalTranslation().getX();
        float y1 = start.getLocalTranslation().getY();
        float z1 = start.getLocalTranslation().getZ();

        float x2 = end.getLocalTranslation().getX();
        float y2 = end.getLocalTranslation().getY();
        float z2 = end.getLocalTranslation().getZ();

        return new Vector3f((x1 + x2) / 2, (y1 + y2) / 2, (z1 + z2) / 2);
    }

    public static float getDistance(Spatial start, Spatial end) {
        float x1 = start.getLocalTranslation().getX();
        float y1 = start.getLocalTranslation().getY();
        float z1 = start.getLocalTranslation().getZ();

        float x2 = end.getLocalTranslation().getX();
        float y2 = end.getLocalTranslation().getY();
        float z2 = end.getLocalTranslation().getZ();

        float xx = (float) Math.pow((x1 - x2), 2);
        float yy = (float) Math.pow((y1 - y2), 2);
        float zz = (float) Math.pow((z1 - z2), 2);

        return (float) Math.pow(xx + yy + zz, 0.5);
    }
    // 3D midpoint formula
    //((x1 + x2) / 2, (y1 + y2) / 2, (z1 + z2) / 2)
    // 3D distance formula
    // D = [(x1 - x2)^2 + (y1 - y2)^2 + (z1 - z2)^2]^1/2
    // length of box is 2 / distance of the line
    // make static methods is mathline to find the distance and midpoint
    // maybe can use get direction to find x, y, and z
    // not sure what units this is returning in
}
