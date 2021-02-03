import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
final public class LIC2Test {

    @Test
    /**
     * @Test gives True Boolean Value based on Test

     * It Test that it checks if it givves correct boolean value (true) of angle is below (PI-EPSILON) or above
     * (PI+EPSILON)
     **/
    public void testLIC2True(){

        Parameters params = new Parameters();

        params.EPSILON = 1;

        Point[] dp = new Point[] { new Point(1, 0), new Point(0, 0), new Point(0, 1), };
        Point[] dp1 = new Point[] { new Point(1, 0), new Point(0, 0), new Point(0, -1), };
        CMV cmv = new CMV(params, dp);
        CMV cmv1 = new CMV(params, dp1);
        cmv.populate();
        cmv1.populate();;
        //pi/2 is below pi-1
        assertTrue(cmv.get()[2]);
        //4pi/3 is above pi+1
        assertTrue(cmv1.get()[2]);
    }

    @Test
    /**
     * @Test gives False Boolean Value based on Test
     * It Test that it checks if it gives correct boolean value (false) of angle is above (PI-EPSILON), below
     * (PI+EPSILON), or if two points are the same
     **/
    public void testLIC2False(){

        Parameters params = new Parameters();

        params.EPSILON = 2;

        Point[] dp = new Point[] { new Point(1, 0), new Point(0, 0), new Point(0, 1), };
        Point[] dp1 = new Point[] { new Point(1, 0), new Point(0, 0), new Point(0, -1),};
        Point[] dp2 = new Point[] { new Point(0, 0), new Point(0, 0), new Point(0, -1),};
        CMV cmv = new CMV(params, dp);
        CMV cmv1 = new CMV(params, dp1);
        CMV cmv2 = new CMV(params, dp2);
        cmv.populate();
        cmv1.populate();;
        cmv2.populate();
        //pi/2 is above pi-2
        assertFalse(cmv.get()[2]);
        //4pi/3 is below pi+2
        assertFalse(cmv1.get()[2]);
        //two points with same value gives false
        assertFalse(cmv2.get()[2]);
    }
}
