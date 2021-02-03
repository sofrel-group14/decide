public class Decide {

  Parameters parameters;
  boolean[] puv = new boolean[15];
  boolean[] cmv;
  boolean[][] pum = new boolean[15][15];
  boolean[] fuv = new boolean[15];
  LCM[][] lcm;

  /**
   * @param parameters, LCM, PUV and datapoints.
   *                    creates all necessary variables that is needed to check if a launch can be made
   */
  public Decide(Parameters parameters, LCM[][] lcm, boolean[] puv, Point[] points) {

    this.parameters = parameters;
    this.lcm = lcm;
    this.puv = puv;
    CMV cmv = new CMV(parameters, points);
    cmv.populate();
    this.cmv = cmv.get();
    setPUM();
    setFUV();
  }

  private void setFUV() {
    for (int i = 0; i < puv.length; i++) {
      if (!puv[i]) {
        fuv[i] = true;
        continue;
      }

      boolean allTrue = true;
      for (int j = 0; j < pum[i].length; j++) {
        allTrue &= pum[i][j];
      }

      if (allTrue) {
        fuv[i] = true;
      }
    }
  }

  private void setPUM() {
    for (int i = 0; i < cmv.length; i++) {
      for (int j = 0; j < cmv.length; j++) {
        LCM op = lcm[i][j];
        switch (op) {

          case ANDD -> pum[i][j] = cmv[i] && cmv[j];
          case ORR -> pum[i][j] = cmv[i] || cmv[j];
          case NOTUSED -> pum[i][j] = true;
        }
      }
    }
  }

  /**
   * Checks all conditions, and if all are met or not, returns a boolean
   *
   * @return a boolean, true if launch is a go, false otherwise
   */
  public boolean Launch() {
    for (boolean condition : fuv) {
      if (!condition) {
        return false;
      }
    }
    return true;
  }

}


