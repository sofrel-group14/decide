import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class LIC9Test {
  Parameters parameters = new Parameters();

  @Test
  public void LIC9AngleUndefined() {
    var points = new Point[] {
      new Point(0,0),
      new Point(2,2),
      new Point(0,0),
      new Point(0,0),
      new Point(1,1),
      new Point(0,0),
      new Point(1,1),
    };

    parameters.C_PTS = 1;
    parameters.D_PTS = 1;

    CMV cmv = new CMV(parameters, points);
    cmv.populate();

    assertFalse(cmv.get()[9]);
  }

  @Test
  public void LIC9NoAngleSat() {
    var points = new Point[] {
      new Point(1,0),
      new Point(2,2),
      new Point(0,0),
      new Point(0,0),
      new Point(-1,0),
    };

    parameters.C_PTS = 1;
    parameters.D_PTS = 1;
    parameters.EPSILON = 0.1;

    CMV cmv = new CMV(parameters, points);
    cmv.populate();

    assertFalse(cmv.get()[9]);
  }

  @Test
  public void LIC9AngleSat() {
    var points = new Point[] {
      new Point(1,0),
      new Point(2,2),
      new Point(0,0),
      new Point(0,0),
      new Point(-1,0.2),
    };

    parameters.C_PTS = 1;
    parameters.D_PTS = 1;
    parameters.EPSILON = 0.1;

    CMV cmv = new CMV(parameters, points);
    cmv.populate();

    assertTrue(cmv.get()[9]);
  }
}
