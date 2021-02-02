import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class LIC11Test {
  Parameters params = new Parameters();
  
  @Test
  /**
   * Tests that LIC11 is true when two points are separated by G_PTS and the x of the first is less than x of the second.
   */
  public void shouldBeTrue() {
    Point[] points = new Point[] {
      new Point(0, 0),    // First point
      new Point(1, 1),    // G_PTS
      new Point(1, 0),    // Second point
    };

    params.G_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[11]);
  }

  @Test
  /**
   * Test when less than 3 points.
   */
  public void shouldBeFalseWhenInvalidArgs() {
    Point[] points = new Point[] {
      new Point(0, 1),
      new Point(1, 1),
    };

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[11]);
  }

  @Test
  /**
   * Tests that LIC11 is false when the difference between the two points is positive.
   */
  public void shouldBeFalseWhenPositiveDiff() {
    Point[] points = new Point[] {
      new Point(1, 0),    // First point
      new Point(1, 1),    // G_PTS
      new Point(0, 0),    // Second point
    };

    params.G_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[11]);
  }
}
