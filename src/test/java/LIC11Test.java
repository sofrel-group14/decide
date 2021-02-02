import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class LIC11Test {
  Parameters params = new Parameters();
  
  @Test
  public void shouldBeTrue() {
    Point[] points = new Point[] {
      new Point(0, 0),    // First point
      new Point(1, 1),    // G_PTS
      new Point(1, 0),    // Second point
      new Point(42, 69)   // Padding
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
  public void shouldBeFalseWhenPositiveDiff() {
    Point[] points = new Point[] {
      new Point(1, 0),    // First point
      new Point(1, 1),    // G_PTS
      new Point(0, 0),    // Second point
      new Point(42, 69)   // Padding
    };

    params.G_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[11]);
  }
}
