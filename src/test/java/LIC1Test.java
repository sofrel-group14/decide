import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
final public class LIC1Test {
    Parameters params = new Parameters();
    @Test
    /**
     * It Test that it if three data points belong to the same circle, I test 5 different ways according to the method
     **/
    public void testLIC1True() {

        Parameters params = new Parameters();

        params.RADIUS1 = 3;

        Point[] dp = new Point[]{new Point(1, 1), new Point(2, 2), new Point(3, 3)}; //collinear
        Point[] dp1 = new Point[]{new Point(0, 0), new Point(1, 1), new Point(-2, -2)}; //circumscribed circle
        Point[] dp2 = new Point[]{new Point(1, 1), new Point(1, 1), new Point(2, 2)}; // two same points
        Point[] dp3 = new Point[]{new Point(1, 1), new Point(2, 2), new Point(1, 1)}; // two same points
        Point[] dp4 = new Point[]{new Point(4, 4), new Point(4, 4), new Point(4, 4)}; //same point

        CMV cmv = new CMV(params, dp);
        CMV cmv1 = new CMV(params, dp1);
        CMV cmv2 = new CMV(params, dp2);
        CMV cmv3 = new CMV(params, dp3);
        CMV cmv4 = new CMV(params, dp4);

        cmv.populate();
        cmv1.populate();
        cmv2.populate();
        cmv3.populate();
        cmv4.populate();

        assertFalse(cmv.get()[1]);
        assertFalse(cmv1.get()[1]);
        assertFalse(cmv2.get()[1]);
        assertFalse(cmv3.get()[1]);
        assertFalse(cmv4.get()[1]);
    }

    @Test
    /**
     * @Test gives False Boolean Value based on Test
     * It Test that it if three data points belong to the same circle, I test 3 different ways for false according to the method
     **/
    public void testLIC1False() {

        Parameters params = new Parameters();

        params.RADIUS1 = 3;

        Point[] dp = new Point[]{new Point(1, 1), new Point(2, 2), new Point(10, 10)}; //collinear too long
        Point[] dp1 = new Point[]{new Point(0, 0), new Point(5, 5), new Point(0, -2)}; //circumscribed circle
        Point[] dp2 = new Point[]{new Point(1, 1), new Point(1, 1), new Point(8, 8)}; // two same and too long distance
        Point[] dp3 = new Point[]{new Point(1, 1), new Point(-10, -5), new Point(1, 1)}; // same with different coords

        CMV cmv = new CMV(params, dp);
        CMV cmv1 = new CMV(params, dp1);
        CMV cmv2 = new CMV(params, dp2);
        CMV cmv3 = new CMV(params, dp3);

        cmv.populate();
        cmv1.populate();
        cmv2.populate();
        cmv3.populate();
        cmv3.populate();

        assertTrue(cmv.get()[1]);
        assertTrue(cmv1.get()[1]);
        assertTrue(cmv2.get()[1]);
        assertTrue(cmv3.get()[1]);
    }
}
