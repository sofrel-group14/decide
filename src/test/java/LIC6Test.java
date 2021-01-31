import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public final class LIC6Test {
  private final Parameters params = new Parameters();

  @Test
  /**
   * @Test Case where points in the range overlap, and distance is greater
   */
  public void LIC6IdenticalTrue() {
    params.DIST = 5;
    params.N_PTS = 5;

    Point[] points = new Point[]{
      new Point(0, 0),
      new Point(1, 0),
      new Point(0, 2),
      new Point(3, 0),
      new Point(0, 0),
      new Point(1, 0),
      new Point(0, 2),
    };

    CMV cmv = new CMV(params, points);
    cmv.populate();
    Assertions.assertTrue(cmv.get()[6]);
  }

  @Test
  /**
   * @Test Case where points in the range overlap, and distance is smaller
   */
  public void LIC6IdenticalFalse() {
    params.DIST = 7;
    params.N_PTS = 5;

    Point[] points = new Point[]{
      new Point(0, 0),
      new Point(1, 0),
      new Point(0, 2),
      new Point(3, 0),
      new Point(0, 0),
      new Point(1, 0),
      new Point(0, 2),
    };

    CMV cmv = new CMV(params, points);
    cmv.populate();
    Assertions.assertFalse(cmv.get()[6]);
  }

  @Test
  /**
   * @Test Case with measurement of the point-line distance, and distance is greater
   */
  public void LIC6LineTrue() {
    params.DIST = 1;
    params.N_PTS = 5;

    Point[] points = new Point[]{
      new Point(0, 0),
      new Point(1, 0),
      new Point(0, 2),
      new Point(1, 1),
      new Point(5, 0),
      new Point(6, 7),
      new Point(0, 0),
    };

    CMV cmv = new CMV(params, points);
    cmv.populate();
    Assertions.assertTrue(cmv.get()[6]);
  }

  @Test
  /**
   * @Test Case with measurement of the point-line distance, and distance is smaller
   */
  public void LIC6LineFalse() {
    params.DIST = 20;
    params.N_PTS = 5;

    Point[] points = new Point[]{
      new Point(0, 0),
      new Point(1, 0),
      new Point(0, 2),
      new Point(1, 1),
      new Point(5, 0),
      new Point(6, 7),
      new Point(0, 0),
    };

    CMV cmv = new CMV(params, points);
    cmv.populate();
    Assertions.assertFalse(cmv.get()[6]);
  }
}
