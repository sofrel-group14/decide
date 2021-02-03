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

  @Test
  /**
   * @Test gives back an angle based on the points
   * It test that it gives back the correct angle
   **/
  public void testAngleTrue(){

    Point pQ1 = new Point(1, 0);
    Point pQ1Origo = new Point(0, 0);
    Point pQ2 = new Point(0, 1);
    Point pQ3 = new Point(-1, 0);

    assertEquals(Point.angle(pQ1,pQ1Origo,pQ2), Math.PI/2);
    assertEquals(Point.angle(pQ1,pQ1Origo,pQ3), Math.PI);
    //if two points are the same then we don't have an angle
    assertEquals(Point.angle(pQ1,pQ1Origo,pQ1Origo), -1);
    assertEquals(Point.angle(pQ1,pQ1Origo,pQ1), 0);
  }
  @Test
  /**
   * This function tests the Point#triangleAreaFromPoints(Point, Point, Point) function
   */
  public void testTriangleFromAreaFunction() {
    Point a = new Point(0, 0);
    Point b = new Point(2, 0);
    Point c = new Point(1, 2);
    assertEquals(2, Point.triangleAreaFromPoints(a, b, c));

    a = new Point(15, 15);
    b = new Point(23, 30);
    c = new Point(50, 25);
    assertEquals(222.5, Point.triangleAreaFromPoints(a, b, c));

    a = new Point(0, 0);
    b = new Point(0, 0);
    c = new Point(0, 0);
    assertEquals(0, Point.triangleAreaFromPoints(a, b, c));
  }
}