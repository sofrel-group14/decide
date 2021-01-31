public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (other == this) return true;
    if (!(other instanceof Point)) return false;
    Point otherPoint = (Point) other;

    return y == otherPoint.y && x == otherPoint.x;
  }
}
