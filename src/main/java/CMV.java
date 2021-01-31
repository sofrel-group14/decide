import java.util.Arrays;

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
    cmv[6] = LIC6();
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

    if (points.length < 3) return false;

    for (int i = 0; i < points.length - parameters.N_PTS; i++) {
      Point[] range = Arrays.copyOfRange(points, i, i + parameters.N_PTS);
      var start = range[0];
      var end = range[parameters.N_PTS - 1];

      if (start.equals(end)) {
        // dist = sum of distances to all other points

        var dist = 0.0;
        for (int j = 1; j < range.length - 1; j++) {
          dist += Math.sqrt(Math.pow(range[j].x - start.x, 2) + Math.pow(range[j].y - start.y, 2));
        }
        if (dist > parameters.DIST) {
          return true;
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
}
