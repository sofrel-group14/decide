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
    cmv[4] = LIC4();
    cmv[10] = LIC10();
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
    // TODO: Implementation.
    return false;
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
}