package decide;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * Class with testes of all LICs.
 */
public class LicTest extends LIC {

  @Test
  public void testLIC1TrueWhenPointsHaveGreaterDistanceThanLength1() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(
        Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

    final int length1 = 3;

    assertTrue(lic1(testPoints, length1));
  }

  @Test
  public void testLIC1FalseWhenPointsHaveShorterDistanceThanLength1() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(
        Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

    final int length1 = 5;

    assertFalse(lic1(testPoints, length1));
  }

  @Test
  public void testLIC1FalseWhenPointsHaveEqualDistanceToLength1() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(
        Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

    final int length1 = 4;

    assertFalse(lic1(testPoints, length1));
  }

  @Test(expected = AssertionError.class)
  public void testLIC1ExceptionThrownWhenLengthLessThan0() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(
        Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

    final int length1 = -1;

    lic1(testPoints, length1);
  }

  @Test
  public void testLIC2TrueWhenPointsNotContainedInCircle() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(2, 0),
        new Point(0, 2),
        new Point(2, 2)));
    final double radius1 = 1;

    assertTrue(lic2(testPoints, radius1));
  }

  @Test
  public void testLIC2FalseWhenPointsContainedInCircle() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(2, 0),
        new Point(0, 2),
        new Point(2, 2)));
    final double radius1 = 2;

    assertFalse(lic2(testPoints, radius1));
  }

  @Test
  public void testLIC2FalseWhenPointsOnCircle() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(1, 0),
        new Point(2, 0),
        new Point(0, 0)));
    final double radius1 = 1;

    assertFalse(lic2(testPoints, radius1));
  }

  @Test(expected = AssertionError.class)
  public void testLIC2ExceptionThrownWhenRadiusLessThan0() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(2, 0),
        new Point(0, 2),
        new Point(2, 2)));
    final double radius1 = -1;

    lic2(testPoints, radius1);
  }

  @Test
  public void testLic4TrueWhenPointsHaveAreaGreaterThanArea1() {
    final ArrayList<Point> testPoints = new ArrayList<>(
        Arrays.asList(new Point(1, 1), new Point(1, -5), new Point(-1, -5)));
    final int area1 = 5;

    assertTrue(lic4(testPoints, area1));
  }

  @Test
  public void testLic4FalseWhenPointsDoesntHaveAreaGreaterThanArea1() {
    final ArrayList<Point> testPoints = new ArrayList<>(
        Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));
    final int area1 = 4;

    assertFalse(lic4(testPoints, area1));
  }

  @Test
  public void testLIC5TrueWhenEnoughPointsOnQuadrants() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(1, -1),
        new Point(1, 1),
        new Point(-1, 1),
        new Point(-1, -1)));

    final int QUADS = 2;
    final int Q_PTS = 3;
    final int NUMPOINTS = 4;

    assertTrue(lic5(testPoints, Q_PTS, QUADS, NUMPOINTS));
  }

  @Test
  public void testLIC5FalseWhenPointsAreNotOnQUADSQuadrants() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(-1, 1),
        new Point(1, 0),
        new Point(-1, 1)));

    final int QUADS = 3;
    final int Q_PTS = 3;
    final int NUMPOINTS = 4;

    assertFalse(lic5(testPoints, Q_PTS, QUADS, NUMPOINTS));
  }

  @Test(expected = AssertionError.class)
  public void testLIC5ThrowsExceptionWhenInvalidInput() {
    final ArrayList<Point> testPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(1, 1),
        new Point(1, 0),
        new Point(-1, 1)));

    final int QUADS = 4;
    final int Q_PTS = 5;
    final int NUMPOINTS = 4;

    lic5(testPoints, Q_PTS, QUADS, NUMPOINTS);
  }

  @Test
  public void testLIC11TrueWhenPointsBetweenE_PTSAndF_PTSHaveAreaGreaterThanAREA1() {
    final ArrayList<Point> testPoints = new ArrayList<>(
        Arrays.asList(new Point(1, 1), new Point(1, -5), new Point(1, 1), new Point(-1, -5), new Point(1, 1)));
    final int NUMPOINTS = testPoints.size();

    final int AREA1 = 5;
    final int E_PTS = 1;
    final int F_PTS = 2;

    assertTrue(lic11(testPoints, NUMPOINTS, AREA1, E_PTS, F_PTS));
  }

  @Test
  public void testLIC11FalseWhenPointsBetweenE_PTSAndF_PTSDoesntHaveAreaGreaterThanAREA1() {
    final ArrayList<Point> testPoints = new ArrayList<>(
        Arrays.asList(new Point(1, 1), new Point(1, 2), new Point(1, 3), new Point(1, 4), new Point(1, 5)));
    final int NUMPOINTS = testPoints.size();

    final int AREA1 = 5;
    final int E_PTS = 2;
    final int F_PTS = 1;

    assertFalse(lic11(testPoints, NUMPOINTS, AREA1, E_PTS, F_PTS));
  }

  @Test
  public void testLIC15TrueWhenPointsBetweenE_PTSAndF_PTSHaveAreaGreaterThanAREA1AndLesserThanAREA2() {
    final ArrayList<Point> testPoints = new ArrayList<>(
        Arrays.asList(new Point(1, 1), new Point(1, -5), new Point(1, 1), new Point(-1, -5), new Point(1, 1)));
    final int NUMPOINTS = testPoints.size();

    final int AREA1 = 3;
    final int AREA2 = 10;
    final int E_PTS = 1;
    final int F_PTS = 2;

    assertTrue(lic15(testPoints, NUMPOINTS, AREA1, AREA2, E_PTS, F_PTS));
  }

  @Test
  public void testLIC15FalseWhenPointsBetweenE_PTSAndF_PTSDoesntHaveAreaGreaterThanAREA1OrLesserThanAREA2() {
    final ArrayList<Point> testPoints = new ArrayList<>(
        Arrays.asList(new Point(1, 1), new Point(1, 2), new Point(1, 3), new Point(1, 4), new Point(1, 5)));
    final int NUMPOINTS = testPoints.size();

    final int AREA1 = 5;
    final int AREA2 = 5;
    final int E_PTS = 2;
    final int F_PTS = 1;

    assertFalse(lic15(testPoints, NUMPOINTS, AREA1, AREA2, E_PTS, F_PTS));
  }
}
