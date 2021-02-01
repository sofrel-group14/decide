
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
    else if (this.x <= 0 && this.y >= 0) return 2;
    else if (this.x <= 0 && this.y <= 0) return 3;
    else if (this.x >= 0 && this.y <= 0) return 4;

    return -1;
  }
}
