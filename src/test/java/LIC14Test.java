import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class LIC14Test {
  Parameters params = new Parameters();
  
  
  @Test
    /*
    * It tests that LIC14 returns false when the parameters are incorrect
  **/

  public void testLIC14Inputs(){
    Parameters params = new Parameters();
    params.AREA2 = 0;

    //Test AREA2 input
    Point[] dp = new Point[] { new Point(1, 1), new Point(1, 1), new Point(1, 1), new Point(1, 1), new Point(1, 1) };
    CMV cmv = new CMV(params, dp);
    cmv.populate();

    assertFalse(cmv.get()[14]);
    
    //Test points input
    params.AREA2 = 10;
    dp = new Point[] { new Point(1, 1), new Point(1, 1)};
    cmv = new CMV(params, dp);

    assertFalse(cmv.get()[14]);

  }

  @Test
  /*
  * It tests that LIC14 is True when the correct conditions are met
  */
  public void testLIC14True(){

    Parameters params = new Parameters();
    params.AREA1 = 1;
    params.AREA2 = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    Point[] dp = new Point[] { new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(5, 0), new Point(-5, 0) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertTrue(cmv.get()[14]);

  }

  @Test
  /*
  * It tests that LIC14 is False when conditions are not met
  */

  public void testLIC14False(){

    Parameters params = new Parameters();

    params.AREA1 = 1;
    params.AREA2 = 3;
    params.E_PTS = 1;
    params.F_PTS = 1;

    //tests that AREA1 < works
    Point[] dp = new Point[] { new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(0, 1), new Point(0, 0)};

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertFalse(cmv.get()[14]);

    //tests that AREA2 > works
    dp = new Point[] { new Point(0, 0), new Point(5, 0), new Point(0, 5), new Point(3, 0), new Point(0, 0)};

    cmv = new CMV(params, dp);
    cmv.populate();

    assertFalse(cmv.get()[14]);


  }

	  @Test
  /*
  * It tests a Edge case
	* Tests if LIC14 can calculate AREAS correctly close to the end the Array.
  */
	  public void testLIC14EdgeCase(){

  Parameters params = new Parameters();

    params.AREA1 = 1;
    params.AREA2 = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;

    Point[] dp = new Point[] { new Point(0, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(-2, 0), new Point(2,0)};

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertTrue(cmv.get()[14]);


  }
}