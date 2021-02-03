import java.util.Objects;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public int quadrant() {
    // 1,1 1,-1 -1,1 -1,-1
    if (this.x >= 0 && this.y >= 0) return 1;
    else if (this.x <= 0 && this.y >= 0) return 2;
    else if (this.x <= 0 && this.y <= 0) return 3;
    else if (this.x >= 0 && this.y <= 0) return 4;

    return -1;
  }

  public static double angle(Point a, Point b, Point c){
    // I create two vectors from the vertex
    // https://stackoverflow.com/questions/21483999/using-atan2-to-find-angle-between-two-vectors

    if (b.equals(a) || b.equals(c)){
      return -1;
    }

    Point v1 = new Point(a.x-b.x, a.y-b.y);
    Point v2 = new Point(c.x-b.x, c.y-b.y);

    //atan2(v2.y,v2.x) - atan2(v1.y,v1.x)
    double angle = Math.atan2(v2.y, v2.x) - Math.atan2(v1.y, v1.x);

    //normalize it to the range [0, 2 π):
    if (angle < 0) { angle += 2 * Math.PI; }

    return angle;
  }
  
  /**
   * Function that determines if this point is contained within (or on the edge)
   * of a circle located at (0, 0).
   * 
   * @param radius the radius of the circle (inclusive).
   * @return true if in or on the edge of the circle, false otherwise.
   */
  public boolean isInCircle(double radius) {
    return isInCircle(radius, 0, 0);
  }

  /**
   * Function that determines if this point is contained within (or on the edge)
   * of a circle located at (cx, cy).
   * @param radius the radius of the circle (inclusive).
   * @param cx x coordinate of the circle's center
   * @param cy y coordinate of the circle's center
   * @return true if in or on the edge of the circle, false otherwise.
   */
  public boolean isInCircle(double radius, double cx, double cy) {
    return Math.pow(this.x - cx, 2) + Math.pow(this.y - cy, 2) <= Math.pow(radius, 2);
  }

  /**
   * Returns the area of the triangle created by three points.
   * The order of the points does not matter.
   * 
   * @param a the first point
   * @param b the second point
   * @param c the third point
   * @return the area
   */
  public static double triangleAreaFromPoints(Point a, Point b, Point c) {
    // https://www.mathopenref.com/coordtrianglearea.html
    return Math.abs((a.x*(b.y - c.y) + b.x*(c.y - a.y) + c.x*(a.y - b.y)) / 2);
  }
}
