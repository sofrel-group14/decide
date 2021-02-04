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
      new Point(-2,-9), //
      new Point(2,2), //
      new Point(8,8), //
      new Point(-4,7), //
      new Point(-5,8), //
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
    // Distance between first two points, (-6,0), (-8,-9), is ≈ 9.22, (according to https://www.calculatorsoup.com/calculators/geometry-plane/distance-two-points.php)
    // so no matter where third point is, they cannot all be contained within
    // (or on) a circle of radius ≈ 1.42.
    // => LIC1 should be TRUE
    assertTrue(d.cmv[1]);

    /*
     * LIC2:
     * There exists at least one set of three consecutive data points which
     * form an angle such that:
     * angle < (PI−EPSILON)
     * or
     * angle > (PI+EPSILON)
     * The second of the three consecutive points is always the vertex of
     * the angle. If either the first point or the last point (or both)
     * coincides with the vertex, the angle is undefined and the LIC is
     * not satisfied by those three points.
     */
    // EPSILON ≈ 1.39
    // So, PI-EPSILON ≈ 1.75
    // And PI+EPSILON ≈ 4.53
    // Points (-6, 0), (-8,-9), and (-5,3) yield angle ≈ 1.51° (≈ 0.02 rad) according to https://www.geogebra.org/calculator
    // i.e. angle < PI-EPSILON
    // => LIC2 should be TRUE
    assertTrue(d.cmv[2]);

    /*
     * LIC3:
     * There exists at least one set of three consecutive data points that
     * are the vertices of a triangle with area greater than AREA1.
     */
    // AREA1 ≈ 8.12
    // Points: (-8,-9), (-5,3), and (6,-1) yield area = 72 according to https://www.geogebra.org/calculator
    // => LIC3 should be TRUE
    assertTrue(d.cmv[3]);

    /*
     * LIC4:
     * There exists at least one set of Q_PTS consecutive data points that lie in more than QUADS
     * quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-1,0) is in quadrant II, the point (0,-1) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     * (2 ≤ Q PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
     */
    /*
    Q_PTS = 7
    QUADS = 1
    If we look at the first 7 Points we can see that:
    Point(-6, 0), Q2
    Point(-8,-9), Q3
    Point(-5,3), Q2
    Point(6,-1), Q4
    Point(8,10), Q1
    Point(-3,3), Q3
    Point(8,5), Q1

    Since they are in 4 different quadrants
    /=> LIC4 should be TRUE
    */
    assertTrue(d.cmv[4]);

    /*
     * LIC5:
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
     * that X[j] - X[i] < 0. (where i = j-1)
     */
    // Point 1 Point (-6,-0)
    // Point 2 Point (-8,-9)
    // -8-(-6) = -2
    // => LIC5 should be TRUE
    assertTrue(d.cmv[5]);

    /*
     * LIC6:
     * There exists at least one set of N_PTS consecutive data points such that at least one of the
     * points lies a distance greater than DIST from the line joining the first and last of these N_PTS
     * points. If the first and last points of these N_PTS are identical, then the calculated distance
     * to compare with DIST will be the distance from the coincident point to all other points of
     * the N_PTS consecutive points.
     */
    /*
     * N_PTS = 16
     * DIST ≈ 1.8176
     * First 16 points satisfy: first point is (-6, 0) and last is (-2, -9).
     * Distance from (-8, -9) to this line is ≈ 5.483 > DIST
     * /=> LIC6 should be true
     */
    assertTrue(d.cmv[6]);

    /*
     * LIC9:
     * There exists at least one set of three data points separated by exactly C_PTS and D_PTS
     * consecutive intervening points, respectively, that form an angle such that:
     *
     * angle < (PI−EPSILON)
     * or
     * angle > (PI+EPSILON)
     *
     * The second point of the set of three points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincide with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points.
     */
    /*
     * PI-EPSILON ≈ 1.7506
     * PI+EPSILON ≈ 4.5325
     * Satisfied by (-5, 3), (8, 10) and (-6, -3) (indices 2, 4, and 7). Angle is ≈ 0.2544 < PI-EPSILON
     * /=> LIC9 should be true
     */
    assertTrue(d.cmv[9]);

    /*
     * LIC10:
     * There exists at least one set of three data points separated by exactly E_PTS and F_PTS
     * consecutive intervening points, respectively, that are the vertices of a triangle with
     * area greater than AREA1. The condition is not met when NUMPOINTS < 5.
     */
    // E_PTS = 8
    // F_PTS = 7
    // AREA1 ≈ 8.12
    //
    // Points:
    // (-6,0), <-- first point
    // ... 8 intervening points ...
    // (9,-8), <-- second point
    // ... 7 intervening points ...
    // (8,8) <-- third point
    //
    // yield area = 116 according to https://www.geogebra.org/calculator
    // => LIC10 should be TRUE
    assertTrue(d.cmv[10]);

    /*
     * LIC11:
     * There exists at least one set of two data points, (X[i], Y[i]) and (X[j], Y[j]),
     * separated by exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0.
     * (where i < j) The condition is not met when NUMPOINTS < 3.
     */
    // G_PTS = 4
    //
    // Points:
    // (-5,3), <-- first point
    // ... 4 intervening points ...
    // (-6,-3), <-- second point
    //
    // We have: -6 < -5
    // => LIC11 should be TRUE
    assertTrue(d.cmv[11]);

    /*
     * LIC12:
     * There exists at least one set of two data points, separated by exactly K_PTS points, s.t.
     * their distance apart is greater than LENGTH1
     * AND
     * There exists at least one set of two data points, separated by exactly K_PTS points, s.t.
     * their distance apart is less than LENGTH2.
     */
    /*
     * LENGTH1 ≈ 7.72
     * LENGTH2 ≈ 8.07
     * K_PTS = 4
     *
     * First set : (-8, -9) and (8, 5) (indices 1 and 6). Distance is ≈ 21.26 > LENGTH1
     * Second set: (-6, 0) and (-3, 3) (indices 0 and 5). Distance is ≈  4.24 < LENGTH2
     * /=> LIC12 should be TRUE
     */
    assertTrue(d.cmv[12]);

    // ... more LICs
  }
}
