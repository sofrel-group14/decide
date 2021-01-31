import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
  @Test
  /**
   * @Test if a Point has the correct Values
   **/
  public void testSimpleAssert() {
    Point p = new Point(10, 12);
    assertTrue(p.x == 10 && p.y == 12);
  }

  @Test
  /**
   * @Test if it gives correct quadrant based on a Point.
   **/
  public void testQuadrant() {
    Point pQ1 = new Point(1, 1);
    Point pQ1Origo = new Point(0, 0);
    Point pQ2 = new Point(-1, 1);
    Point pQ3 = new Point(-1, -1);
    Point pQ4 = new Point(1, -1);

    assertTrue(pQ1.quadrant() == 1);
    assertTrue(pQ1Origo.quadrant() == 1);
    assertTrue(pQ2.quadrant() == 2);
    assertTrue(pQ3.quadrant() == 3);
    assertTrue(pQ4.quadrant() == 4);

  }
}