import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class LIC5Test {
  Parameters params = new Parameters();

@Test
  /**
  * @Test gives True Boolean Value based on LIC5 
  * It Test that it can find 2 consecitive points has a negative difference
  **/
  public void testLIC5True(){


    Point[] dp = new Point[] { new Point(8, 7), new Point(6, 5), new Point(4, 3), new Point(2, 1) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertTrue(cmv.get()[5]);

  }

  @Test
  /**
  * @Test gives False Boolean Value based on LIC5 
  * It Test that it can find 2 consecitive points has a negative difference
  **/
  public void testLIC5False(){

    Point[] dp = new Point[] { new Point(1, 0), new Point(2,0), new Point(3, 0), new Point(4, 0) };

    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertFalse(cmv.get()[5]);
    
  }

    @Test
  /**
  * @Test gives False Boolean Value based on LIC5 
  * It Test that it can find 2 consecitive points has a negative difference
  * It aslo test an Edge case Where the Difference is 0
  **/
  public void testLIC5Edge(){
    
    
    Point[] dp = new Point[] { new Point(1, 0), new Point(1,0), new Point(1, 0), new Point(1, 0) };
    CMV cmv = new CMV(params, dp);
    cmv.populate();
    assertFalse(cmv.get()[5]);
    
  }
  

}