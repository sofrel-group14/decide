import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class LIC12Test {
  Parameters parameters = new Parameters();

  @Test
  public void LIC12InRange() {
    var points = new Point[] {
      new Point(0,0),
      new Point(0,0),
      new Point(1,0),
      new Point(4,0),
    };

    parameters.LENGTH1 = 3;
    parameters.LENGTH2 = 2;
    parameters.K_PTS = 1;

    CMV cmv = new CMV(parameters, points);
    cmv.populate();

    assertTrue(cmv.get()[12]);
  }

  @Test
  public void LIC12OutOfRange() {
    var points = new Point[] {
      new Point(0,0),
      new Point(0,0),
      new Point(1,0),
      new Point(2,0),
    };

    parameters.LENGTH1 = 3;
    parameters.LENGTH2 = 2;
    parameters.K_PTS = 1;

    CMV cmv = new CMV(parameters, points);
    cmv.populate();

    assertFalse(cmv.get()[12]);
  }
}
