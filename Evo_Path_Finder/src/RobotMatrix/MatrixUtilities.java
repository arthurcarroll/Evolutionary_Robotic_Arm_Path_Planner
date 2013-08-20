package RobotMatrix;

import com.jme3.math.Matrix3f;
import java.text.DecimalFormat;

/**
 *
 * @author Arthur Carroll
 */
public class MatrixUtilities {

    public static double cosd(double degreeAngle) {
        return Math.cos(Math.toRadians(degreeAngle));
    }

    public static double sind(double degreeAngle) {
        return Math.sin(Math.toRadians(degreeAngle));
    }

    public static HTransformMatrix multiply(HTransformMatrix A, HTransformMatrix B, int size) {
        // make a new matrix
        HTransformMatrix multMatrix = new HTransformMatrix(size, 0, 0, 0, 0);
        // get the array from the new matrix
        double[][] multArray = multMatrix.getArray();
        // make a new single column array to hold temporary values to multiply
        double[] tempColumnB = new double[size];


        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                tempColumnB[k] = B.array[k][j];
            }
            for (int i = 0; i < size; i++) {
                double[] tempRowA = A.array[i];
                double s = 0;
                for (int k = 0; k < size; k++) {
                    s += tempRowA[k] * tempColumnB[k];
                }
                multArray[i][j] = s;
            }
        }
        return multMatrix;
    }

    public static double arcCosd(double degreeAngle) {
        return Math.toDegrees(Math.acos(degreeAngle));
    }

    public static double arcSind(double degreeAngle) {
        return Math.toDegrees(Math.asin(degreeAngle));
    }

    public static void test() {
        double angle = 45;
        System.out.println("cos: " + angle + "  " + cosd(angle));
        System.out.println("sin: " + angle + "  " + sind(angle));

        System.out.println("arccos: " + cosd(angle) + "  " + arcCosd(cosd(angle)));
        System.out.println("arcsin: " + sind(angle) + "  " + arcSind(sind(angle)));
    }

    public static void printMinorSeperator() {
        System.out.println("------------");
    }

    public static void printMajorSeperator() {
        System.out.println("-----------------------------------------");
    }

    public static String getFormattedDouble(double d) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(d);
    }

    public static double findDeltaAngle(double theta1, double theta2) {
        double difference = theta2 - theta1;
        while (difference < -180) {
            difference += 360;
        }
        while (difference > 180) {
            difference -= 360;
        }
        return difference;
    }

    public static double findAbsDeltaAngle(double theta1, double theta2) {
        return Math.abs(findDeltaAngle(theta1, theta2));
    }

    public static Matrix3f copyRotationMatrixToJMERotationMatrix(HTransformMatrix htm) {
        Matrix3f nM = new Matrix3f();
        nM.set(htm.getRotationMatrixF());
        return nM;
    }
}
