package RobotMatrix;

import java.util.ArrayList;

/**
 *
 * @author Arthur Carroll
 * @class Holds all the joint and links of the robot arm as a chain of HTransformMatrices
 * and can make a new joint.
 */
public class MatrixChain {

    ArrayList<HTransformMatrix> chain = new ArrayList<HTransformMatrix>();

    public MatrixChain() {
    }

    public void add(HTransformMatrix m) {
        chain.add(m);
    }

    public HTransformMatrix getTransfromZeroToN(int link, boolean printDebug) {
        if (link > chain.size()) {
            throw new IllegalArgumentException("not a link");
        }

        int count = link - 1;
        HTransformMatrix my = chain.get(link);

        while (count >= 0) {
            my = MatrixUtilities.multiply(chain.get(count), my, my.size);
            if (printDebug) {
                System.out.println("matrix: " + count + " to " + (link));
                my.printArray();
            }
            count--;
        }
        return my;
    }

    public void printChain() {

        int count = 1;
        boolean first = true;
        for (HTransformMatrix m : chain) {
            if (!first) {
                System.out.println("matrix: " + count + " in terms of " + (count - 1));
            } else {
                System.out.println("matrix: " + (count));
                first = false;
            }
            count++;
            m.printArray();
        }
    }

    public ArrayList<HTransformMatrix> getChain() {
        return chain;
    }
}
