import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LIC8Test {
  @Test
  /**
   * Tests LIC8 is true for 3 points that do not intersect in a circle with radius 1.
   */
  public void shouldBeTrue1() {
    Point[] points = new Point[] {
      new Point(0, 0), // First point
      new Point(20, 0), // Intervening A_PTS
      new Point(0, 2), // Should be outside the area
      new Point(30, -5), // Intervening, B_PTS
      new Point(0, -2), // Should be outside the area
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 1.0;
    params.A_PTS = 1;
    params.B_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[8]);
  }

  @Test
  /**
   * Test LIC8 is true when A_PTS is greater than 1 and points do not intersect in a circle with radius 1.
   */
  public void shouldBeTrue2() {
    Point[] points = new Point[] {
      new Point(1, 0), // Should be outside the area
      new Point(10, 2), // Intervening point 1 of A_PTS
      new Point(15, 3), // Intervening point 2 of A_PTS
      new Point(0, 3), // Should be outside the area
      new Point(42, 1337), // Intervening point B_PTS
      new Point(3, -3), // Should be outside the area
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 1.0;
    params.A_PTS = 2;
    params.B_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[8]);
  }

  @Test
  /**
   * Test LIC8 is false when 3 points intersect eachother in a circle with radius 1.
   */
  public void shouldBeFalseWhenInsideArea() {
    Point[] points = new Point[] {
      new Point(2, 2), // First point
      new Point(10, 2), // Intervening point
      new Point(2.5, 2), // Should be inside the area
      new Point(10, 2), // Intervening point
      new Point(3, 2), // Should be inside the area
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[8]);
  }

  @Test
  /**
   * Tests if LIC8 is false when A_PTS or B_PTS is less than 1.
   */
  public void shouldBeFalseWhenAptsOrBPtsZero() {
    Point[] points = new Point[] {
      new Point(10, 0), // Should be outside the area
      new Point(0, 20), // Should be outside the area
      new Point(30, 3), // Should be outside the area
      new Point(42, 1337), // Padding since length needs to be >= 5
      new Point(10, 2), // Padding since length needs to be >= 5
      new Point(69, 420), // Padding since length needs to be >= 5
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 1.0;
    params.A_PTS = 0;
    params.B_PTS = 0;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[8]);
  }

  @Test
  /**
   * Tests that LIC8 is false when there are fewer than 5 points.
   */
  public void shouldBeFalseWhenFewerThan5Points() {
    Point[] points = new Point[] {
      new Point(1, 0),
      new Point(0, 2),
      new Point(3, 3),
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 9.0;
    params.A_PTS = 1;
    params.B_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[8]);
  }
}