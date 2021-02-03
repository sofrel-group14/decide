import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class LIC13Test {
  Parameters params = new Parameters();
  
  
  @Test
    /*
    * It tests that LIC13 returns false when the parameters are incorrect
  **/

  public void testLIC13Inputs(){
    Parameters params = new Parameters();
    params.RADIUS2 = -1;

    Point[] dp = new Point[] { new Point(1, 1), new Point(1, 1), new Point(1, 1), new Point(1, 1), new Point(1, 1) };
    CMV cmv = new CMV(params, dp);
    cmv.populate();

    assertFalse(cmv.get()[13]);
    
    //Test points input
    params.RADIUS2 = 10;
    dp = new Point[] { new Point(1, 1), new Point(1, 1)};
    cmv = new CMV(params, dp);

    assertFalse(cmv.get()[13]);

  }

  @Test
  /*
  * It tests that LIC13 is True when the correct conditions are met
  */
  public void testLIC13True(){

    Parameters params = new Parameters();
    params.RADIUS1 = 1;
    params.RADIUS2 = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    Point[] dp = new Point[] { new Point(1, 0), new Point(1, 0), new Point(-1, 0), new Point(0, 0), new Point(0, 1), new Point(0, 1) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertTrue(cmv.get()[13]);

  }

  @Test
  /*
  * It tests that LIC13 is False when conditions are not met
  */

  public void testLIC13False(){

    Parameters params = new Parameters();
    params.RADIUS1 = 0.5;
    params.RADIUS2 = 0.5;
    params.A_PTS = 1;
    params.B_PTS = 1;
    Point[] dp = new Point[] { new Point(1, 0), new Point(1, 0), new Point(-1, 0), new Point(0, 0), new Point(0, 1), new Point(0, 1) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertFalse(cmv.get()[13]);



  }
  
  
  @Test
  /*
  * It tests a Edge case for LIC13
  * Check if it works with the smallest possible radius
  */
  public void testLIC13EdgeCase(){

    Parameters params = new Parameters();
    params.RADIUS1 = 0.5;
    params.RADIUS2 = 0.36;
    params.A_PTS = 1;
    params.B_PTS = 1;
    Point[] dp = new Point[] { new Point(1, 0), new Point(0, 0.5), new Point(-1, 0), new Point(0, 0), new Point(0, 0), new Point(0.5, 0) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertTrue(cmv.get()[13]);


  }
}