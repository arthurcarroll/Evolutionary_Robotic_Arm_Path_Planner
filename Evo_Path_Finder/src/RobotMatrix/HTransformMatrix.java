package RobotMatrix;

import com.jme3.math.Vector3f;

/**
 *
 * @author Arthur Carroll
 */
public class HTransformMatrix {

    // the values of the array
    public double[][] array;
    final int size;
    public double alphaP;
    public double aP;
    public double d;
    public double theta;

    public HTransformMatrix(int size, double alphaP, double aP, double d, double theta) {
        this.size = size;
        // create the h transform matrix
        array = new double[size][size];

        resetMatrix();

        for (int n = 0; n < size; n++) {
            array[n][n] = 1;
        }

        this.populateMatrixValues(alphaP, aP, d, theta);
    }

    public final void populateMatrixValues(double alphaP, double aP, double d, double theta) {
        this.alphaP = alphaP;
        this.aP = aP;
        this.d = d;
        this.theta = theta;

        // make a new joint based on the joint variables
        array[0][0] = MatrixUtilities.cosd(theta);
        array[0][1] = -MatrixUtilities.sind(theta);
        array[0][2] = 0;
        array[0][3] = aP;

        array[1][0] = MatrixUtilities.sind(theta) * MatrixUtilities.cosd(alphaP);
        array[1][1] = MatrixUtilities.cosd(theta) * MatrixUtilities.cosd(alphaP);
        array[1][2] = -MatrixUtilities.sind(alphaP);
        array[1][3] = -MatrixUtilities.sind(alphaP) * d;


        array[2][0] = MatrixUtilities.sind(theta) * MatrixUtilities.sind(alphaP);
        array[2][1] = MatrixUtilities.cosd(theta) * MatrixUtilities.sind(alphaP);

        array[2][2] = MatrixUtilities.cosd(alphaP);
        array[2][3] = MatrixUtilities.cosd(alphaP) * d;
    }

    public HTransformMatrix(double alphaP, double aP, double d, double theta) {
        this(4, alphaP, aP, d, theta);
    }

    public void setXYPhi(double x, double y, double phi) {
        resetMatrix();
        array[0][0] = MatrixUtilities.cosd(phi);
        array[0][1] = -MatrixUtilities.sind(phi);
        array[1][0] = MatrixUtilities.sind(phi);
        array[1][1] = MatrixUtilities.cosd(phi);

        array[0][size - 1] = x;
        array[1][size - 1] = y;
    }

    public HTransformMatrix inverseMatrix() {
        HTransformMatrix m = new HTransformMatrix(this.alphaP, this.aP, this.d, this.theta);
        // transpose the rotation matrix
        double[][] R = this.getTransposeRotationMatrix();
        m.setRotaionMatrix(R);

        // inverse the position matrix
        double[] p = inversePostionArray(R, getPositionArray());
        m.setPositionArray(p);

        return m;
    }

    public final void printArray() {
        // print the array
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(MatrixUtilities.getFormattedDouble(array[row][col]) + "  ");
            }
            System.out.println("");
        }
    }

    public double[][] getArray() {
        return array;
    }

    public void setSingleArrayValue(int row, int column, double value) {
        array[row][column] = value;
    }

    public void setAllArrayValues(double[][] newValues) {
        if (!checkArraySize(newValues)) {
            throw new IllegalArgumentException("wrong size");
        }
        for (int row = 0; row < size; row++) {
            System.arraycopy(newValues[row], 0, array[row], 0, size);

        }
    }

    private boolean checkRotationArraySize(double[][] a) {
        // check for rotation/home/arthur/repos/Arthur/classes/Intelligent_Robotics/programs array bounds
        if (a.length == size - 1) {
            if (a[0].length != size - 1) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean checkArraySize(double[][] a) {
        // check entire array bounds
        if (a.length == size) {
            if (a[0].length != size) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private double[] inversePostionArray(double[][] inverseRotationmatrix, double[] positionArray) {

        // inverse the position array
        double[] R = new double[size - 1];

        for (int j = 0; j < size - 1; j++) {
            for (int i = 0; i < size - 1; i++) {
                double[] tempRowA = inverseRotationmatrix[i];
                double s = 0;
                for (int k = 0; k < size - 1; k++) {
                    s += tempRowA[k] * positionArray[k];
                }
                R[i] = s;
            }
        }
        for (int i = 0; i < R.length; i++) {
            R[i] = -R[i];
        }
        return R;
    }

    public double[][] getTransposeRotationMatrix() {
        // transpose the rotation matrix
        double[][] R = new double[size - 1][size - 1];
        for (int row = 0; row < size - 1; row++) {
            for (int col = 0; col < size - 1; col++) {
                R[col][row] = array[row][col];
            }
        }
        return R;
    }

    public double[] getPositionArray() {
        // get the position part of the array
        double[] d = new double[size - 1];
        for (int rows = 0; rows < size - 1; rows++) {
            d[rows] = array[rows][3];
        }
        return d;
    }

    public void setPositionArray(double[] d) {
        for (int rows = 0; rows < size - 1; rows++) {
            array[rows][3] = d[rows];
        }
    }

    public double[][] getRotationMatrix() {
        double[][] R = new double[size - 1][size - 1];
        for (int row = 0; row < size - 1; row++) {
            System.arraycopy(array[row], 0, R[row], 0, size - 1);
        }
        return R;
    }

    public float[][] getRotationMatrixF() {
        float[][] R = new float[size - 1][size - 1];
        for (int row = 0; row < size - 1; row++) {
            for (int col = 0; col < size - 1; col++) {
                R[row][col] = (float) array[row][col];
            }
        }
        return R;
    }

    public void setRotaionMatrix(double[][] m) {
        if (!checkRotationArraySize(m)) {
            throw new IllegalArgumentException("wrong size");
        }
        double[][] R = new double[size - 1][size - 1];
        for (int row = 0; row < size - 1; row++) {
            System.arraycopy(m[row], 0, array[row], 0, size - 1);
        }
    }

    public double[][] deepCopyArray() {
        double[][] R = new double[size][size];
        for (int row = 0; row < size; row++) {
            System.arraycopy(array[row], 0, R[row], 0, size);
        }
        return R;
    }

    public double getX() {
        return array[0][size - 1];
    }

    public double getY() {
        return array[1][size - 1];
    }

    public double getZ() {
        if (size == 4) {
            return array[2][size - 1];
        } else {
            return 1;
        }
    }

    public double getPhi() {
        return MatrixUtilities.arcCosd(array[0][0]);
    }

    public double getRotY() {
        // get the rotation around the y axis
        double r11Sq = Math.pow(array[0][0], 2);
        double r21Sq = Math.pow(array[1][0], 2);
        double r31 = array[2][0];
        double sqrt = Math.sqrt(r11Sq + r21Sq);
        return Math.toDegrees(Math.atan2(-r31, sqrt));
    }

    public double getRotZ() {
        // get the rotation around the z axis
        return Math.toDegrees(Math.atan2(array[1][0] / getRotY(), array[0][0] / getRotY()));
    }

    public double getRotX() {
        // get the rotation around the x axis
        double cosBeta = MatrixUtilities.cosd(getRotY());
        return Math.toDegrees(Math.atan2(array[2][1] / cosBeta, array[2][2] / cosBeta));
    }

    final public void resetMatrix() {
        for (int n = 0; n < size; n++) {
            array[n][n] = 1;
        }
    }

    final public Vector3f getPos() {
        Vector3f v = new Vector3f((float) getX(), (float) getY(), (float) getZ());
        return v;
    }
}
