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
    cmv[4] = LIC4();
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
    // TODO: Implementation.
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
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 6 condition.
   */
  private boolean LIC6() {
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 7 condition.
   */
  private boolean LIC7() {
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 8 condition.
   */
  private boolean LIC8() {
    // TODO: Implementation.
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
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 11 condition.
   */
  private boolean LIC11() {
    // TODO: Implementation.
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
    // TODO: Implementation.
    return false;
  }

  /**
   * Computes the LIC 14 condition.
   */
  private boolean LIC14() {
    // TODO: Implementation.
    return false;
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
    if (a==c && lengthAB < diameter){
      return true;
    }
    if (c==b && lengthAC <diameter){
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