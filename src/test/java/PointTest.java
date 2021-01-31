import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PointTest{
    @Test
    /**
     * @Test if a Point has the correct Values
     **/
    public void testSimpleAssert(){
        Point p = new Point(10,12);
        assertTrue(p.x == 10 && p.y == 12);
    }

    @Test
    /**
     * Tests the Point.isInCircle()-function.
     */
    public void circleInAreaTest1() {
      Point p1 = new Point(0, 0);
      Point p2 = new Point(1, 0);
      Point p3 = new Point(0, 1);
      Point p4 = new Point(-1, 0);
      Point p5 = new Point(0, -1);
      Point p6 = new Point(1, 2);
      Point p7 = new Point(1, 1);
      Point p8 = new Point(2, 0);

      assertTrue(p1.isInCircle(1));
      assertTrue(p2.isInCircle(1));
      assertTrue(p3.isInCircle(1));
      assertTrue(p4.isInCircle(1));
      assertTrue(p5.isInCircle(1));
      assertTrue(p6.isInCircle(4));

      assertFalse(p7.isInCircle(1));
      assertFalse(p8.isInCircle(1));
    }
}