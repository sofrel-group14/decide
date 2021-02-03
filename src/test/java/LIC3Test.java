import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
final public class LIC3Test {
    @Test
    /**
     * @Test gives True Boolean Value based on Test
     * It Test that the area of three consecutive points as a triangle is larger than specified area
     **/
    public void testLIC3True(){

        Parameters params = new Parameters();

        params.AREA1 = 5;
        Point[] dp = new Point[] { new Point(0, 0), new Point(5, 0), new Point(0, 5)};
        CMV cmv = new CMV(params, dp);
        cmv.populate();

        params.AREA1 = 12;
        CMV cmv2 = new CMV(params, dp);
        cmv2.populate();

        assertTrue(cmv.get()[3]);
        assertTrue(cmv2.get()[3]);
    }

    @Test
    /**
     * @Test gives False Boolean Value based on Test
     * It Test that the area of three consecutive points as a triangle is larger than specified area
     **/
    public void testLIC3False(){

        Parameters params = new Parameters();

        params.AREA1 = 20;
        Point[] dp = new Point[] { new Point(0, 0), new Point(5, 0), new Point(0, 5)};
        CMV cmv = new CMV(params, dp);
        cmv.populate();

        params.AREA1 = 13;
        CMV cmv2 = new CMV(params, dp);
        cmv2.populate();

        assertFalse(cmv.get()[3]);
        assertFalse(cmv2.get()[3]);
    }
}
