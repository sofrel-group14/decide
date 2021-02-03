import java.util.Arrays;
import java.awt.geom.Point2D;

/**
 * This class implements the CMV (Conditions Met Vector).
 */
public class CMV {

  // The parameters.
  private Parameters parameters;
  // The conditions met vector.
  private boolean[] cmv = new boolean[15];
  private Point[] points;

  /**
   * Creates a CMV with input parameters.
   * 
   * @param param  the parameter instance.
   * @param points the array with data points
   */
  public CMV(Parameters param, Point[] points) {
    this.parameters = param;
    this.points = points;
  }

  /**
   * Populates the cmv vector, i.e. goes through all LICs.
   * 
   * This function needs to be called before get().
   */
  public void populate() {
    // TODO: Implementation
    cmv[1] = LIC1();
    cmv[0] = LIC0();
    cmv[4] = LIC4();
    cmv[10] = LIC10();
    cmv[7] = LIC7();
    cmv[5] = LIC5();
    cmv[6] = LIC6();
    cmv[8] = LIC8();
    cmv[11] = LIC11();
    cmv[13] = LIC13();
    cmv[14] = LIC14();
  }

  /**
   * Returns the populated cmv vector.
   * 
   * Note that vector is empty before you call populate().
   * 
   * @return the populated vector.
   */
  public boolean[] get() {
    return this.cmv;
  }

  // -----------------------------------------
  // LIC condition functions below

  /**
   * Computes the LIC 0 condition.
   */
  private boolean LIC0() {
    if (parameters.LENGTH1 < 0) {
      return false;
    }

    for (int i = 0; i < points.length - 1; i++) {
      Point p1 = points[i];
      Point p2 = points[i+1];
      double distance = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
      if (distance > parameters.LENGTH1) {
        return true;
      }
    }
    return false;
  }

  /**
   * Computes the LIC 1 condition.
   */
  private boolean LIC1() {
    boolean exists = false;

    if (this.points.length<3){
      return false;
    }

    for (int i = 0;i<this.points.length-2;i++){
      boolean statement = insideCircle(this.points[i],this.points[i+1],this.points[i+2], parameters.RADIUS1);
      if (statement){
        exists = true;
      }
    }
    return exists;
  }

  /**
   * Computes the LIC 2 condition.
   */
  private boolean LIC2() {
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 3 condition.
   */
  private boolean LIC3() {
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 4 condition.
   */
  private boolean LIC4() {

    if (parameters.Q_PTS < 2 && parameters.Q_PTS > points.length) return false;
    if (parameters.QUADS < 1 && parameters.QUADS > 3) return false;

    for (int startPnt = 0; startPnt < points.length - parameters.Q_PTS + 1; startPnt++) {

      boolean[] quad = new boolean[] { false, false, false, false };
      int pntsInDiffQuad = 0;

      for (int consPnt = 0; consPnt < parameters.Q_PTS; consPnt++) {

        int quadrant = points[startPnt + consPnt].quadrant();

        if (!quad[quadrant - 1]) {
          quad[quadrant - 1] = true;
          pntsInDiffQuad++;
        }

      }

      if (pntsInDiffQuad > parameters.QUADS) return true;
    }

    return false;
  }

  /**
   * Computes the LIC 5 condition.
   */
  private boolean LIC5() {
    for(int pnt = 1; pnt < points.length - 1; pnt++){
      if(points[pnt].x - points[pnt - 1].x < 0){
        return true;
      }
    }
    return false;
  }

  /**
   * Computes the LIC 6 condition.
   */
  private boolean LIC6() {

    if (parameters.N_PTS < 3 || parameters.N_PTS > points.length) return false;
    if (parameters.DIST < 0) return false;
    if (points.length < 3) return false;

    for (int i = 0; i < points.length - parameters.N_PTS; i++) {
      Point[] range = Arrays.copyOfRange(points, i, i + parameters.N_PTS);
      var start = range[0];
      var end = range[parameters.N_PTS - 1];

      if (start.equals(end)) {
        // dist = sum of distances to all other points

        for (int j = 1; j < range.length - 1; j++) {
          var dist = Math.sqrt(Math.pow(range[j].x - start.x, 2) + Math.pow(range[j].y - start.y, 2));
          if (dist > parameters.DIST) {
            return true;
          }
        }
      } else {
        // dist = distance to line between start and end

        var line = new Point(end.x - start.x, end.y - start.y); // 'vector' from start to end

        for (int j = 1; j < range.length - 1; j++) {
          var p = range[j];

          var vec = new Point(start.x - p.x, start.y - p.y);
          var len = Math.sqrt(line.x * line.x + line.y * line.y);
          var dist = Math.abs(line.x * vec.y - vec.x * line.y) / len;

          if (dist > parameters.DIST) {
            return true;
          }
        }
      }
    }

    return false;
  }

  /**
   * Computes the LIC 7 condition.
   */
  private boolean LIC7() {
    int K_PTS = parameters.K_PTS;
    if (K_PTS < 1 || K_PTS > (points.length - 2) || points.length < 3) {
      return false;
    }

    for (int i = 0; i < points.length - 1 - K_PTS; i++) {
      Point p1 = points[i];
      Point p2 = points[i + K_PTS + 1];
      double distance = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
      if (distance > parameters.LENGTH1) {
        return true;
      }
    }
    return false;
  }

  /**
   * Computes the LIC 8 condition. Note that the points should NOT be in the area,
   * confused me a bit when writing the code.
   */
  private boolean LIC8() {
    int A_PTS = parameters.A_PTS;
    int B_PTS = parameters.B_PTS;
    double RADIUS = parameters.RADIUS1;

    // Condition is not met when NUMPOINTS < 5
    if (points.length < 5) return false;
    // 1 <= A_PTS, 1 <= B_PTS
    if (A_PTS < 1 || B_PTS < 1) return false;
    // A_PTS + B_PTS <= NUMPOINTS - 3
    if (A_PTS + B_PTS > points.length - 3) return false;

    for (int i = 0; i < points.length - 2 - A_PTS - B_PTS; i++) {
      Point a = points[i];
      Point b = points[i + A_PTS + 1];
      Point c = points[i + A_PTS + 1 + B_PTS + 1];

      // From the set {ab, ac, ba, bc, ca, cb}, there are three unique pairs: ab, ac, bc
      // Check circle centered at a
      boolean ab = b.isInCircle(RADIUS, a.x, a.y);
      boolean ac = c.isInCircle(RADIUS, a.x, a.y);

      // Check circle centered at b
      // Since we've already checked ab, we don't need to check ba (commutation).
      // This also applies to cb: this line checks bc, which is why we don't need to check cb.
      boolean bc = c.isInCircle(RADIUS, b.x, b.y);

      // If any is true, the set is invalid
      if (ab || ac || bc) continue;
      else return true;
    }

    return false;
  }

  /**
   * Computes the LIC 9 condition.
   */
  private boolean LIC9() {
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 10 condition.
   */
  private boolean LIC10() {
    int E_PTS = parameters.E_PTS;
    int F_PTS = parameters.F_PTS;
    double AREA = parameters.AREA1;

    if (points.length < 5) return false;
    if (E_PTS < 1 || F_PTS < 1) return false;
    if (E_PTS + F_PTS > points.length - 3) return false;

    // I don't think the try/catch block is necessary logically, but put it there just in case...
    try {
      for (int i = 0; i < points.length - 2 - E_PTS - F_PTS; i++) {
        Point a = points[i];
        Point b = points[i + E_PTS + 1];
        Point c = points[i + E_PTS + 1 + F_PTS + 1];
  
        // https://www.mathopenref.com/coordtrianglearea.html
        double area = a.x*(b.y - c.y) + b.x*(c.y - a.y) + c.x*(a.y - b.y);
        area = area / 2;
        area = Math.abs(area);
        
        if (area > AREA) return true;
      }
    } catch (IndexOutOfBoundsException e) {
      // No such set
      return false;
    }

    return false;
  }

  /**
   * Computes the LIC 11 condition.
   */
  private boolean LIC11() {
    int G_PTS = parameters.G_PTS;

    if (points.length < 3) return false;
    if (G_PTS < 1 || G_PTS > points.length - 2) return false;

    for (int k = 0; k < points.length - 1 - G_PTS; k++) {
      int i = k;
      int j = k + G_PTS + 1;
      Point a = points[i];
      Point b = points[j];

      if (a.x - b.x < 0) return true;
    }

    return false;
  }

  /**
   * Computes the LIC 12 condition.
   */
  private boolean LIC12() {
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 13 condition.
   */
  private boolean LIC13() {
    if(parameters.RADIUS2 < 0 || points.length < 5) return false;

    boolean containedInCircleRad1 = false;
    boolean containedInCircleRad2 = false;

    int aPts = parameters.A_PTS;
    int bPts = parameters.B_PTS;
    double raduis1 = parameters.RADIUS1;
    double raduis2 = parameters.RADIUS2;

    for(int Pnt = 0; Pnt < points.length - aPts - bPts - 2; Pnt++){
      if(Point.smallestCircle(points[Pnt], points[Pnt + aPts + 1], points[Pnt + aPts + bPts + 2]) <= raduis1) containedInCircleRad1 = true;
      if(Point.smallestCircle(points[Pnt], points[Pnt + aPts + 1], points[Pnt + aPts + bPts + 2]) <= raduis2) containedInCircleRad2 = true;
    }

    return containedInCircleRad1 && containedInCircleRad2;
  }

  /**
   * Computes the LIC 14 condition.
   */
  private boolean LIC14() {
    if(points.length < 5 || parameters.AREA2 < 0) return false;

    boolean greaterThanA1 = false;
    boolean lessThanA2 = false;

    int ePts = parameters.E_PTS;
    int fPts = parameters.F_PTS;
    double AREA1 = parameters.AREA1;
    double AREA2 = parameters.AREA2;

    for(int Pnt = 0; Pnt < points.length - ePts - fPts - 2; Pnt++){
      if(Point.triangleAreaFromPoints(points[Pnt], points[Pnt + ePts + 1], points[Pnt + ePts + fPts + 2]) > AREA1) greaterThanA1 = true;
      if(Point.triangleAreaFromPoints(points[Pnt], points[Pnt + ePts], points[Pnt + ePts + fPts + 2]) < AREA2) lessThanA2 = true;
    }

    

    return greaterThanA1 && lessThanA2;
  }

  private boolean insideCircle(Point a, Point b, Point c, double radius){

    //if all three have the same coords then of course they all fit within the same circle
    if (a.equals(b) && b.equals(c)){
      return true;
    }

    //Start with calculating the length between all three points
    double lengthAB = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    double lengthAC = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2));
    double lengthBC = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2));

    double diameter = 2*radius;

    // we check for collinearity, if true the line must be shorter than the radius
    // We calculate are of triangle, if zero, then it is collinear
    //Area of triangle =  (Ax(By -Cy) + Bx(Cy -Ay) + Cx(Ay - By))/2
    double area = (a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y))/2;
    if (area == 0){
      // if on same line we check total length
      if (lengthAB+lengthBC<diameter){
        return true;
      }
      if ((lengthAC+lengthBC<diameter)){
        return true;
      }
      if (lengthAB+lengthAC<diameter){
        return true;
      }
    }

    //now we check if two points are the same and distance to last one is shorter than diameter
    if (a == b && lengthAC<diameter){
      return true;
    }
    if (a == c && lengthAB < diameter){
      return true;
    }
    if (c == b && lengthAC <diameter){
      return true;
    }

    // lastly we check the circumscribed circle, and check if radius is larger than that

    Point2D.Double centre = new Point2D.Double(0, 0);
    centre.setLocation((a.x + b.x + c.x) / 3.0,(a.y + b.y + c.y)/3.0); // we use the midpoint/avg
    // we use the function distance, which gives us distance from centre to a point
    //if this is under or equal to radius, then it is inside the circle
    if (centre.distance(new Point2D.Double(a.x,a.y))<=radius && centre.distance(new Point2D.Double(b.x,b.y))<=radius && centre.distance(new Point2D.Double(c.x,c.y))<=radius ){
      return true;
    }
    return false;
  }
}
