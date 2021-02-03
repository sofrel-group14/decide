import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LIC4Test {

  @Test
  /**
  * @Test gives True Boolean Value based on Test  
  * It Test that it can find 3 points in three different quadrants
  * It Test that it can skips the first data points to find the next 3 consecitive data points
  **/
  public void testLIC4True(){

    Parameters params = new Parameters();

    params.Q_PTS = 3;
    params.QUADS = 2;

    Point[] dp = new Point[] { new Point(1, 1), new Point(1, 2), new Point(-1, 1), new Point(-1, -1) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertTrue(cmv.get()[4] == true);

  }

  @Test
  /**
   * @Test gives False Boolean Value based on Test
   * It Test that it can find 3 points in three different quadrants
   * It Test that it can skips the first data points to find the next 3 consecitive data points
   **/
  public void testLIC4False(){
    Parameters params = new Parameters();

    params.Q_PTS = 3;
    params.QUADS = 2;

    Point[] dp = new Point[] { new Point(1, 1), new Point(1, 1), new Point(1, 1), new Point(1, 1) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertFalse(cmv.get()[4]);

  }

}