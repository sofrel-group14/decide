
public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public int quadrant() {
    // 1,1 1,-1 -1,1 -1,-1
    if (this.x >= 0 && this.y >= 0) return 1;
    else if (this.x < 0 && this.y > 0) return 2;
    else if (this.x < 0 && this.y < 0) return 3;
    else if (this.x > 0 && this.y < 0) return 4;

    return -1;
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
