package RobotModel;

/**
 *
 * @author Arthur Carroll
 */
public class Joint implements java.io.Serializable {

    private String name;
    private float alphaP;
    private float AP;
    private float DI;
    private float thetaI;

    public Joint() {
    }

    public float getAP() {
        return AP;
    }

    public void setAP(float AP) {
        this.AP = AP;
    }

    public float getDI() {
        return DI;
    }

    public void setDI(float DI) {
        this.DI = DI;
    }

    public float getAlphaP() {
        return alphaP;
    }

    public void setAlphaP(float alphaP) {
        this.alphaP = alphaP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getThetaI() {
        return thetaI;
    }

    public void setThetaI(float thetaI) {
        this.thetaI = thetaI;
    }
}
