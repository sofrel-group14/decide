public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Function that determines if this point is contained within (or on the edge)
   * of a circle.
   * 
   * @param radius the radius of the circle (inclusive).
   * @return true if in or on the edge of the circle, false otherwise.
   */
  public boolean isInCircle(double radius) {
    // Assumes perfect circle, which (I think??) is a correct assumption in the assignment.
    return Math.pow(this.x, 2) + Math.pow(this.y, 2) <= Math.pow(radius, 2);
  }
}
