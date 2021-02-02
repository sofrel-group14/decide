import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LIC7 description:
 * There exists at least one set of two data points
 * separated by exactly K_PTS consecutive intervening
 * points that are a distance greater than the length,
 * LENGTH1, apart. The condition is not met when
 * NUMPOINTS < 3.
 * 1 ≤ K_PTS ≤ (NUMPOINTS−2)
 */
final public class LIC7Test {
  Parameters params = new Parameters();

  @Test
  /**
   * Tests that two data points K_PTS points apart, with distance
   * greater than LENGTH1, yields 'True' from LIC7-function.
   */
  public void pointsDistanceGreaterYieldsTrue() {
    Point[] points = new Point[]{
      new Point(0, 0),    // First point
      new Point(3, 4),    // Intervening point
      new Point(5, 6),    // Intervening point
      new Point(0, 11),   // Second point, distance 11 from first point
    };

    params.LENGTH1 = 10;
    params.K_PTS = 2;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[7]);
  }

  @Test
  /**
   * Tests that two data points K_PTS points apart, with distance
   * less than or equal to LENGTH1, yields 'False' from LIC7-function.
   */
  public void pointsDistanceLessOrEqualsYieldsFalse() {
    params.LENGTH1 = 10;
    params.K_PTS = 2;

    // Less than
    Point[] points1 = new Point[]{
      new Point(0, 0),    // First point
      new Point(3, 4),    // Intervening point
      new Point(5, 6),    // Intervening point
      new Point(0, 9),    // Second point, distance 9 from first point
    };

    CMV cmv1 = new CMV(params, points1);
    cmv1.populate();
    assertFalse(cmv1.get()[7]);

    // Equals
    Point[] points2 = new Point[]{
      new Point(0, 0),    // First point
      new Point(3, 4),    // Intervening point
      new Point(5, 6),    // Intervening point
      new Point(0, 10),   // Second point, distance 10 from first point
    };

    CMV cmv2 = new CMV(params, points2);
    cmv2.populate();
    assertFalse(cmv2.get()[7]);
  }

  @Test
  /**
   * Tests that an invalid value for NUMPOINTS (i.e. < 3)
   * or invalid value for K_PTS (i.e. < 1 or > NUMPOINTS - 2)
   * yields 'False' from LIC0-function.
   */
  public void invalidParamYieldsFalse() {

    // NUMPOINTS < 3
    Point[] points1 = new Point[]{
      new Point(0, 0),    // First point
      new Point(0, 11),   // Second point
    };

    params.K_PTS = 5; // Has to be set, since otherwise defaults to 0

    CMV cmv1 = new CMV(params, points1);
    cmv1.populate();
    assertFalse(cmv1.get()[7]);

    // K_PTS < 1
    Point[] points2 = new Point[]{
      new Point(0, 0),    // First point
      new Point(0, 11),   // Second point
      new Point(3, 9),   // Third point
    };

    params.K_PTS = 0;

    CMV cmv2 = new CMV(params, points2);
    cmv2.populate();
    assertFalse(cmv2.get()[7]);

    // K_PTS > NUMPOINTS - 2
    Point[] points3 = new Point[]{
      new Point(0, 0),    // First point
      new Point(0, 11),   // Second point
      new Point(3, 9),   // Third point
    };

    params.K_PTS = 10;

    CMV cmv3 = new CMV(params, points3);
    cmv3.populate();
    assertFalse(cmv3.get()[7]);
  }

  @Test
  /**
   * Tests edge-case logic for:
   * NUMPOINTS = 3,
   * K_PTS = 1,
   * K_PTS = NUMPOINTS-2
   */
  public void edgeCasesYieldsCorrect() {

    // All three edge cases
    Point[] points1 = new Point[]{
      new Point(77, 15),    // First point
      new Point(14, 2),     // Intervening point
      new Point(3, 0),      // Second point, distance > 2 to first point
    };

    params.LENGTH1 = 2;
    params.K_PTS = 1;

    CMV cmv1 = new CMV(params, points1);
    cmv1.populate();
    assertTrue(cmv1.get()[7]);
  }

}
