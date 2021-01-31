public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
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
   * @param cx x coordinate of the circle's center
   * @param cy y coordinate of the circle's center
   * @return true if in or on the edge of the circle, false otherwise.
   */
  public boolean isInCircle(double radius, double cx, double cy) {
    return Math.pow(this.x - cx, 2) + Math.pow(this.y - cy, 2) <= Math.pow(radius, 2);
  }
}
