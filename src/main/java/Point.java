
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

  public static double angle(Point a, Point b, Point c){
    // I create two vectors from the vertex
    // https://stackoverflow.com/questions/21483999/using-atan2-to-find-angle-between-two-vectors

    Point v1 = new Point(a.x-b.x, a.y-b.y);
    Point v2 = new Point(c.x-b.x, c.y-b.y);

    //atan2(v2.y,v2.x) - atan2(v1.y,v1.x)
    double angle = Math.atan2(v2.y, v2.x) - Math.atan2(v1.y, v1.x);

    //normalize it to the range [0, 2 π):
    if (angle < 0) { angle += 2 * Math.PI; }

    return angle;
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
