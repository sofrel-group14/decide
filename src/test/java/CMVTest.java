import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMVTest {
  @Test
  /**
   * Tests LIC8 with padding, i.e. A_PTS and B_PTS set to 1.
   */
  public void lic8ShouldBeTrue1() {
    Point[] points = new Point[] {
      new Point(11, 0), // Should be included
      new Point(20, 0), // Intervening A_PTS
      new Point(0, 11), // Should be included
      new Point(30, -5), // Intervening, B_PTS
      new Point(0, -11), // Should be included
      new Point(0, 2), // Padding since length needs to be >= 5
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 10.0;
    params.A_PTS = 1;
    params.B_PTS = 1;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[8]);
  }

  @Test
  /**
   * Test LIC8 with no padding.
   */
  public void lic8ShouldBeTrue2() {
    Point[] points = new Point[] {
      new Point(15.33, 0), // Should be included
      new Point(0, 16.71), // Should be included
      new Point(10, 13), // Should be included
      new Point(10, 2), // Padding since length needs to be >= 5
      new Point(42, 1337), // Padding since length needs to be >= 5
      new Point(69, 420), // Padding since length needs to be >= 5
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 10.0;
    params.A_PTS = 0;
    params.B_PTS = 0;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertTrue(cmv.get()[8]);
  }

  @Test
  public void lic8ShouldBeFalse() {
    Point[] points = new Point[] {
      new Point(1, 0), // Should be included
      new Point(0, 2), // Should be included
      new Point(3, 3), // Should be included
      new Point(10, 2), // Padding since length needs to be >= 5
      new Point(42, 1337), // Padding since length needs to be >= 5
      new Point(69, 420), // Padding since length needs to be >= 5
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 10.0;
    params.A_PTS = 0;
    params.B_PTS = 0;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[8]);
  }

  @Test
  public void lic8ShouldBeFalseWhenFewerThan5Points() {
    Point[] points = new Point[] {
      new Point(1, 0),
      new Point(0, 2),
      new Point(3, 3),
    };

    Parameters params = new Parameters();
    params.RADIUS1 = 9.0;
    params.A_PTS = 0;
    params.B_PTS = 0;

    CMV cmv = new CMV(params, points);
    cmv.populate();
    assertFalse(cmv.get()[8]);
  }
}