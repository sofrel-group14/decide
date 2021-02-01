import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the LIC 10 condition
 */
final public class LIC10Test {

  final Parameters params = new Parameters();
  
  @Test
  public void shouldBeTrue() {
    Point[] points = new Point[] {
      new Point(0, 0),    // First point in triangle
      new Point(1, 1),    // Intervening point
      new Point(2, 0),    // Second point in triangle
      new Point(1, 1),    // Intervening point
      new Point(1, 2),    // Third point in triangle
      new Point(69, 420)  // Padding since #points > 5
    };

    params.AREA1 = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[10]);
  }

  @Test
  public void shouldBeFalseInvalidParams() {
    Point[] points = new Point[] {
      new Point(0, 0),
      new Point(1, 1),
    };

    params.AREA1 = 2;
    params.E_PTS = 0;
    params.F_PTS = 0;

    // Test less than 6 points
    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[10]);

    // Test F_PTS < 1 or E_PTS < 1
    points = new Point[] {
      new Point(0, 0),
      new Point(1, 1),
      new Point(1, 1),
      new Point(1, 1),
      new Point(1, 1),
      new Point(1, 1),
    };
    cmv.populate();
    assertFalse(cmv.get()[10]);
  }

  @Test
  public void shouldBeFalse() {
    Point[] points = new Point[] {
      new Point(0, 0),    // First point in triangle
      new Point(1, 1),    // Intervening point
      new Point(2, 0),    // Second point in triangle
      new Point(1, 1),    // Intervening point
      new Point(1, 2),    // Third point in triangle
      new Point(69, 420)  // Padding since #points > 5
    };

    params.AREA1 = 2;
    params.E_PTS = 1;
    params.F_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[10]);

    params.AREA1 = 3;
    cmv.populate();
    assertFalse(cmv.get()[10]);
  }
}
