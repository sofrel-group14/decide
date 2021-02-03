import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PointTest{

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
    Point pQ2Axis = new Point(-1,0);
    Point pQ3Axis = new Point(0,-1);
    Point pQ1Axis1 = new Point(0,1);
    Point pQ1Axis2 = new Point(1,0);


    assertEquals(pQ1.quadrant(), 1);
    assertEquals(pQ1Origo.quadrant(), 1);
    assertEquals(pQ2.quadrant(), 2);
    assertEquals(pQ3.quadrant(), 3);
    assertEquals(pQ4.quadrant(),  4);

    assertEquals(pQ2Axis.quadrant(), 2);
    assertEquals(pQ3Axis.quadrant(), 3);
    assertEquals(pQ1Axis1.quadrant(), 1);
    assertEquals(pQ1Axis2.quadrant(), 1);


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

  @Test
  /**
   * Test the equals() override for Point
   */
  void testEquals() {
    Point a = new Point(1, 1);
    Point b = new Point(1, 1);
    Point c = new Point(1, -1);

    assertEquals(a, b);
    assertEquals(b, a);

    assertNotEquals(a, c);
    assertNotEquals(b, c);

    a.x = 2;
    assertNotEquals(a, b);
  }

  @Test
  /**
   * Test associated hashCode method for equality comparison
   */
  void testHashCode() {
    Point a = new Point(1, 1);
    Point b = new Point(1, 1);
    Point c = new Point(1, -1);

    assertEquals(a.hashCode(), b.hashCode());
    assertEquals(b.hashCode(), a.hashCode());

    assertNotEquals(a.hashCode(), c.hashCode());
    assertNotEquals(b.hashCode(), c.hashCode());

    a.x = 2;
    assertNotEquals(a.hashCode(), b.hashCode());
  }
  
  @Test
  /**
   * Tests Point#isInCircle() for different circle radii and circle positions.
   */
  public void circleInAreaTest() {
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
    assertTrue(p6.isInCircle(1, 1, 1));

    assertFalse(p7.isInCircle(1));
    assertFalse(p8.isInCircle(1));
    assertFalse(p8.isInCircle(1, 4, 4));
  }


  @Test
  /**
   * Tests Points to find what is the raduis of the smallest possible circle
   */
  public void smallestCircle() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(1, 0);
    Point p3 = new Point(-1, 0);
    Point p4 = new Point(0, 1);
    Point p5 = new Point(0, 0);
    Point p6 = new Point(0, 0);


    assertEquals(Point.smallestCircle(p1, p2, p3), 1);
    assertNotEquals(Point.smallestCircle(p1, p3, p4), 1);
    assertEquals(Point.smallestCircle(p1, p5, p6), 0);

  }
}