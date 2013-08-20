package RobotModel;

import com.jme3.math.Vector3f;

/**
 *
 * @author Arthur Carroll
 */
public class Vector3fBean implements java.io.Serializable {

    private float x;
    private float y;
    private float z;

    public Vector3fBean() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public static Vector3fBean makeVector(float x, float y, float z) {
        Vector3fBean v3b = new Vector3fBean();
        v3b.setX(x);
        v3b.setY(y);
        v3b.setZ(z);
        return v3b;
    }

    public Vector3f toJMEVector() {
        Vector3f vec3 = new Vector3f(x, y, z);
        return vec3;
    }
}
