import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LIC0 description:
 * There exists at least one set of two consecutive
 * data points that are a distance greater than the
 * length, LENGTH1, apart.
 * (0 ≤ LENGTH1)
 */
final public class LIC0Test {
    Parameters params = new Parameters();

    @Test
    /**
     * Tests that two consecutive data points with distance
     * greater than LENGTH1 yields 'True' from LIC0-function.
     */
    public void pointsDistanceGreaterYieldsTrue() {

        // Points on horizontal axis
        Point[] points1 = new Point[] {
                new Point(0, 0),    // First point
                new Point(0, 11),   // Second point, distance 11 from first point
        };

        params.LENGTH1 = 10;

        CMV cmv1 = new CMV(params, points1);
        cmv1.populate();
        assertTrue(cmv1.get()[0]);

        // "Diagonal" points (from perspective of traditional axes)
        Point[] points2 = new Point[] {
                new Point(0, 0),    // First point
                new Point(4, 3),    // Second point, distance 5 from first point
        };

        params.LENGTH1 = 4;

        CMV cmv2 = new CMV(params, points2);
        cmv2.populate();
        assertTrue(cmv2.get()[0]);
    }

    @Test
    /**
     * Tests that two data points, with distance greater than LENGTH1,
     * that are NOT consecutive yields 'False' from LIC0-function.
     */
    public void nonConsPointsYieldsFalse() {
        Point[] points = new Point[] {
                new Point(0, 0),    // First point
                new Point(0, 5),    // Second point, within distance 10 from first and third point
                new Point(0, 11),   // Third point
        };

        params.LENGTH1 = 10;

        CMV cmv = new CMV(params, points);
        cmv.populate();
        assertFalse(cmv.get()[0]);
    }

    @Test
    /**
     * Tests that an invalid value for LENGTH1 (i.e. < 0)
     * yields 'False' from LIC0-function.
     */
    public void invalidParamYieldsFalse() {
        Point[] points = new Point[] {
                new Point(0, 0),    // First point
                new Point(0, 11),   // Second point
        };

        params.LENGTH1 = -1;

        CMV cmv = new CMV(params, points);
        cmv.populate();
        assertFalse(cmv.get()[0]);
    }

    @Test
    /**
     * Tests edge-case logic for LENGTH1 = 0.
     */
    public void edgeCaseZeroYieldsCorrect() {
        params.LENGTH1 = 0;

        // Two points with distance 0 (should yield false due to strict > in contract)
        Point[] points1 = new Point[] {
                new Point(7, 5),    // First point
                new Point(7, 5),    // Second point
        };

        CMV cmv1 = new CMV(params, points1);
        cmv1.populate();
        assertFalse(cmv1.get()[0]);

        // Two points with distance > 0 (should yield true)
        Point[] points2 = new Point[] {
                new Point(7, 5),    // First point
                new Point(0, 0),    // Second point
        };

        CMV cmv2 = new CMV(params, points2);
        cmv2.populate();
        assertTrue(cmv2.get()[0]);
    }

}
