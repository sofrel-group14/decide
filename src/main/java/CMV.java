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
   * @param param the parameter instance.
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
    cmv[8] = LIC8();
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
    // TODO: Implementation.
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

    try {
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
    } catch (IndexOutOfBoundsException e) {
      // We try to access outside array, there is no such set.
      return false;
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
}