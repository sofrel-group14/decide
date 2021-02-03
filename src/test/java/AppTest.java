import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test the entire functionality of the
 * application (i.e. the DECIDE program).
 * Consists of three main integration tests.
 */
public class AppTest {

  /**
   * Randomized test 1, with inputs randomly generated in random-input.py
   *
   * Parameters:
   * LENGTH1: 7.727017384890802
   * RADIUS1: 1.4161504403487357
   * EPSILON: 1.3909703878060167
   * AREA1: 8.126738282494014
   * Q_PTS: 7
   * QUADS: 1
   * DIST: 1.8175553123622812
   * N_PTS: 16
   * K_PTS: 4
   * A_PTS: 7
   * B_PTS: 1
   * C_PTS: 1
   * D_PTS: 2
   * E_PTS: 8
   * F_PTS: 7
   * G_PTS: 4
   * LENGTH2: 8.073005754021686
   * RADIUS2: 1.8299267470369274
   * AREA2: 5.6006820270923505
   *
   * LCM (symmetric):
   * NOTUSED NOTUSED NOTUSED NOTUSED ANDD    NOTUSED ORR     ORR     NOTUSED ORR     ORR     ANDD    NOTUSED ORR     NOTUSED
   * NOTUSED ANDD    ANDD    ORR     NOTUSED NOTUSED ANDD    ANDD    NOTUSED NOTUSED ORR     NOTUSED ANDD    NOTUSED NOTUSED
   * NOTUSED ANDD    NOTUSED NOTUSED ANDD    ORR     NOTUSED NOTUSED ANDD    ANDD    ANDD    ORR     ORR     NOTUSED NOTUSED
   * NOTUSED ORR     NOTUSED ORR     NOTUSED ANDD    ANDD    NOTUSED NOTUSED ANDD    ORR     ANDD    ANDD    ANDD    ANDD
   * ANDD    NOTUSED ANDD    NOTUSED NOTUSED NOTUSED NOTUSED ORR     ANDD    NOTUSED NOTUSED NOTUSED ORR     ORR     ANDD
   * NOTUSED NOTUSED ORR     ANDD    NOTUSED ORR     ORR     ORR     NOTUSED ANDD    ORR     ANDD    ORR     NOTUSED ORR
   * ORR     ANDD    NOTUSED ANDD    NOTUSED ORR     ORR     ORR     ORR     ANDD    NOTUSED ANDD    NOTUSED ORR     ORR
   * ORR     ANDD    NOTUSED NOTUSED ORR     ORR     ORR     NOTUSED ANDD    ANDD    ORR     NOTUSED ORR     ORR     NOTUSED
   * NOTUSED NOTUSED ANDD    NOTUSED ANDD    NOTUSED ORR     ANDD    ORR     ORR     ANDD    ANDD    ORR     ANDD    ANDD
   * ORR     NOTUSED ANDD    ANDD    NOTUSED ANDD    ANDD    ANDD    ORR     ANDD    NOTUSED ORR     ORR     ORR     NOTUSED
   * ORR     ORR     ANDD    ORR     NOTUSED ORR     NOTUSED ORR     ANDD    NOTUSED NOTUSED NOTUSED NOTUSED ORR     ORR
   * ANDD    NOTUSED ORR     ANDD    NOTUSED ANDD    ANDD    NOTUSED ANDD    ORR     NOTUSED ORR     ORR     ORR     ORR
   * NOTUSED ANDD    ORR     ANDD    ORR     ORR     NOTUSED ORR     ORR     ORR     NOTUSED ORR     ANDD    NOTUSED NOTUSED
   * ORR     NOTUSED NOTUSED ANDD    ORR     NOTUSED ORR     ORR     ANDD    ORR     ORR     ORR     NOTUSED ORR     ANDD
   * NOTUSED NOTUSED NOTUSED ANDD    ANDD    ORR     ORR     NOTUSED ANDD    NOTUSED ORR     ORR     NOTUSED ANDD    ORR
   *
   * PUV:
   * [False, False, True, False, False, False, True, True, True, True, True, False, False, False, True]
   *
   * Points:
   * (-6,0), (-8,-9), (-5,3)
   * (6,-1), (8,10), (-3,3)
   * (8,5), (-6,-3), (-10,3)
   * (9,-8), (10,2), (-4,-10)
   * (8,-2), (-3,6), (4,8)
   * (-2,-9), (2,2), (8,8)
   * (-4,7), (-5,8)println
   * (NUMPOINTS = 20)
   */
  @Test
  public void test1() {

    //<editor-fold desc="Initialize parameters"> // Makes code foldable in IntelliJ (possibly others as well), found here: https://blog.jetbrains.com/idea/2012/03/custom-code-folding-regions-in-intellij-idea-111/
    Parameters params = new Parameters();
    params.LENGTH1 = 7.727017384890802;
    params.RADIUS1 = 1.4161504403487357;
    params.EPSILON = 1.3909703878060167;
    params.AREA1 = 8.126738282494014;
    params.Q_PTS = 7;
    params.QUADS = 1;
    params.DIST = 1.8175553123622812;
    params.N_PTS = 16;
    params.K_PTS = 4;
    params.A_PTS = 7;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 2;
    params.E_PTS = 8;
    params.F_PTS = 7;
    params.G_PTS = 4;
    params.LENGTH2 = 8.073005754021686;
    params.RADIUS2 = 1.8299267470369274;
    params.AREA2 = 5.6006820270923505;
    //</editor-fold>

    //<editor-fold desc="Initialize LCM">
    LCM[][] lcm = {
      {LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.NOTUSED},
      {LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED},
      {LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.ANDD, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.NOTUSED},
      {LCM.NOTUSED, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.ORR, LCM.ANDD, LCM.ANDD, LCM.ANDD, LCM.ANDD},
      {LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ANDD},
      {LCM.NOTUSED, LCM.NOTUSED, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.ORR, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.ORR},
      {LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ORR, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ORR},
      {LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.NOTUSED},
      {LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ANDD, LCM.ORR, LCM.ORR, LCM.ANDD, LCM.ANDD, LCM.ORR, LCM.ANDD, LCM.ANDD},
      {LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.ANDD, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ORR, LCM.NOTUSED},
      {LCM.ORR, LCM.ORR, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.ORR, LCM.ORR},
      {LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.NOTUSED, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ORR, LCM.ORR},
      {LCM.NOTUSED, LCM.ANDD, LCM.ORR, LCM.ANDD, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ANDD, LCM.NOTUSED, LCM.NOTUSED},
      {LCM.ORR, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.ANDD, LCM.ORR, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ORR, LCM.ANDD},
      {LCM.NOTUSED, LCM.NOTUSED, LCM.NOTUSED, LCM.ANDD, LCM.ANDD, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.NOTUSED, LCM.ORR, LCM.ORR, LCM.NOTUSED, LCM.ANDD, LCM.ORR},
    };
    //</editor-fold>

    // Initialize puv
    boolean[] puv = {false, false, true, false, false, false, true, true, true, true, true, false, false, false, true};

    //<editor-fold desc="Initialize points">
    Point[] points = new Point[]{
      new Point(-6, 0),
      new Point(-8,-9),
      new Point(-5,3),
      new Point(6,-1),
      new Point(8,10),
      new Point(-3,3),
      new Point(8,5),
      new Point(-6,-3),
      new Point(-10,3),
      new Point(9,-8),
      new Point(10,2),
      new Point(-4,-10),
      new Point(8,-2),
      new Point(-3,6),
      new Point(4,8),
      new Point(-2,-9),
      new Point(2,2),
      new Point(8,8),
      new Point(-4,7),
      new Point(-5,8),
    };
    //</editor-fold>

    Decide d = new Decide(params, lcm, puv, points);

    /*
    * LIC0:
    * There exists at least one set of two consecutive data points
    * that are a distance greater than the length, LENGTH1, apart.
    */
    // LENGTH1 ≈ 7.72
    // Distance between first two points, (-6,0), (-8,-9), is ≈ 9.22
    // => LIC0 should be TRUE
    assertTrue(d.cmv[0]);

    /*
    * LIC1:
    * There exists at least one set of three consecutive data points that
    * cannot all be contained within or on a circle of radius RADIUS1.
    */
    // RADIUS1 ≈ 1.42
    // Distance between first two points, (-6,0), (-8,-9), is ≈ 9.22,
    // so no matter where third point is, they cannot all be contained within
    // (or on) a circle of radius ≈ 1.42.
    // => LIC0 should be TRUE
    assertTrue(d.cmv[1]);

    // ... more LICs
  }
}
