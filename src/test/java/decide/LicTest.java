package decide;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import java.awt.Point;
import java.util.Arrays;
import org.junit.Test;

/**
 * Class with testes of all LICs.
 */
public class LicTest extends LIC {

    @Test
    public void testLIC1TrueWhenPointsHaveGreaterDistanceThanLength1() {
        final ArrayList<Point> testPoints =
            new ArrayList<Point>(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

        final int length1 = 3;

        assertTrue(lic1(testPoints, length1));
    }

    @Test
    public void testLIC1FalseWhenPointsHaveShorterDistanceThanLength1() {
        final ArrayList<Point> testPoints =
            new ArrayList<Point>(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

        final int length1 = 5;

        assertFalse(lic1(testPoints, length1));
    }

    @Test
    public void testLIC1FalseWhenPointsHaveEqualDistanceToLength1() {
        final ArrayList<Point> testPoints =
            new ArrayList<Point>(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

        final int length1 = 4;

        assertFalse(lic1(testPoints, length1));
    }

    @Test(expected = AssertionError.class)
    public void testLIC1ExceptionThrownWhenLengthLessThan0() {
        final ArrayList<Point> testPoints =
            new ArrayList<Point>(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));

        final int length1 = -1;

        lic1(testPoints, length1);
    }

    @Test
    public void testLIC2TrueWhenPointsNotContainedInCircle() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(0,0),
                        new Point(2,0),
                        new Point(0,2),
                        new Point(2,2)
                ));
        final double radius1 = 1;

        assertTrue(lic2(testPoints, radius1));
    }

    @Test
    public void testLIC2FalseWhenPointsContainedInCircle() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(0,0),
                        new Point(2,0),
                        new Point(0,2),
                        new Point(2,2)
                ));
        final double radius1 = 2;

        assertFalse(lic2(testPoints, radius1));
    }

    @Test
    public void testLIC2FalseWhenPointsOnCircle() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(0,1),
                        new Point(1,0),
                        new Point(0,-1),
                        new Point(-1,0)
                ));
        final double radius1 = 1;

        assertFalse(lic2(testPoints, radius1));
    }

    @Test(expected = AssertionError.class)
    public void testLIC2ExceptionThrownWhenRadiusLessThan0() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(0,0),
                        new Point(2,0),
                        new Point(0,2),
                        new Point(2,2)
                ));
        final double radius1 = -1;

        lic2(testPoints, radius1);
    }

    @Test
    public void testLIC3TrueIfAngleIsLessThanPI(){
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(new Point(0, 0), new Point(1, 1),
                new Point(1, 0)));
        double EPSILON = 1;
        assertTrue(lic3(points, EPSILON));
    }
     @Test
    public void testLIC3FalseIfAngleIsUndefined(){
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, 1),
                new Point(0, 0)));
        double EPSILON = 1;
        assertFalse(lic3(points, EPSILON));
    }
    @Test
    public void testLIC3FalseIfEpsilonNotBetweenPiAndZero(){
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, 1),
                new Point(0, 0)));
        double EPSILON = 5;
        assertFalse(lic3(points, EPSILON));
    }
    @Test
    public void testLIC3FalseIfAngleIsMoreThanPI(){
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 0), new Point(2, 0),
                new Point(3, 0)));
        double EPSILON = 1;
        assertFalse(lic3(points, EPSILON));
    }
    @Test
    public void testLic4TrueWhenPointsHaveAreaGreaterThanArea1() {
        final ArrayList<Point> testPoints =
            new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, -5), new Point(-1, -5)));
        final int area1 = 5;

        assertTrue(lic4(testPoints, area1));
    }

    @Test
    public void testLic4FalseWhenPointsDoesntHaveAreaGreaterThanArea1() {
        final ArrayList<Point> testPoints =
            new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));
        final int area1 = 4;

        assertFalse(lic4(testPoints, area1));
    }


    @Test
    public void testLIC5TrueWhenEnoughPointsOnQuadrants() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(1, -1),
                        new Point(1, 1),
                        new Point(-1,1),
                        new Point(-1, -1)
                ));

        final int QUADS = 2;
        final int Q_PTS = 3;
        final int NUMPOINTS = 4;

        assertTrue(lic5(testPoints, Q_PTS, QUADS, NUMPOINTS));
    }

    @Test
    public void testLIC5FalseWhenPointsAreNotOnQUADSQuadrants() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(0,0),
                        new Point(-1, 1),
                        new Point(1,0),
                        new Point(-1, 1)
                ));

        final int QUADS = 3;
        final int Q_PTS = 3;
        final int NUMPOINTS = 4;

        assertFalse(lic5(testPoints, Q_PTS, QUADS, NUMPOINTS));
    }

    @Test(expected = AssertionError.class)
    public void testLIC5ThrowsExceptionWhenInvalidInput() {
        final ArrayList<Point> testPoints =
                new ArrayList<Point>(Arrays.asList(
                        new Point(0,0),
                        new Point(1, 1),
                        new Point(1,0),
                        new Point(-1, 1)
                ));

        final int QUADS = 4;
        final int Q_PTS = 5;
        final int NUMPOINTS = 4;

        lic5(testPoints, Q_PTS, QUADS, NUMPOINTS);
    }

    @Test
    public void testLIC7FalseWhenPointsHaveShorterDistanceThanDIST() {
        final ArrayList<Point2D> testPoints = new ArrayList<>();
        testPoints.add(new Point2D.Double(60.6843, 92.1812));
        testPoints.add(new Point2D.Double(45.6490, 93.5470));
        testPoints.add(new Point2D.Double(48.5971, 73.8203));
        testPoints.add(new Point2D.Double(63.6430, 72.4545));
        testPoints.add(new Point2D.Double(31.2304, 82.3123));
        testPoints.add(new Point2D.Double(49.1230, 22.3912));

        final int NUMPOINTS = testPoints.size();
        final int N_PTS = 3;
        final int DIST = 40;

        assertFalse(lic7(testPoints, NUMPOINTS, N_PTS, DIST));
    }

    /*Test that lic10 is true when there exist at least three consecutive data points that form
    an angle that is either less than (PI - EPSILON) or more than (PI + EPSILON)*/
    @Test
    public void testLIC10TrueWhenAngleIsMoreThanAdditionOfPiAndEpsilon() {
        final int C_PTS = 3;
        final int D_PTS = 4;
        final double EPSILON = 1;
        final int NUMPOINTS = 10;

        final ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < NUMPOINTS; i++) {
            points.add(i, new Point(i, i));
        }
        points.set(0, new Point(1, 2));
        points.set(C_PTS +1, new Point(1, 1));
        points.set(C_PTS + C_PTS + 2, new Point(2,1));
        assertTrue(lic10(points, NUMPOINTS, C_PTS, D_PTS, EPSILON));
    }
    /*Test that lic10 is false when there does not exist at least three consecutive data points that form
     an angle that is either less than (PI-EPSILON) or more than (PI + EPSILON)*/
    @Test
    public void testLIC10FalseWhenAngleIsLessThanAdditionOfPiAndEpsilon() {
        final int C_PTS = 3;
        final int D_PTS = 4;
        final double EPSILON = 1;
        final int NUMPOINTS = 10;

        final ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < NUMPOINTS-1; i++) {
            points.add(i, new Point(i, i));
        }
        points.set(0, new Point(2, 4));
        points.set(C_PTS +1, new Point(2, 2));
        points.set(C_PTS + C_PTS + 2, new Point(2,0));
        assertFalse(lic10(points, NUMPOINTS, C_PTS, D_PTS, EPSILON));
    }
    @Test
    public void testLIC10FalseWhenVertexSameAsOtherPoint() {
        final int C_PTS = 3;
        final int D_PTS = 4;
        final double EPSILON = 1;
        final int NUMPOINTS = 10;

        final ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            points.add(i, new Point(i, i));
        }
        points.set(0, new Point(1, 1));
        points.set(C_PTS +1, new Point(1, 1));
        points.set(C_PTS + C_PTS + 2, new Point(2,0));
        assertFalse(lic10(points, NUMPOINTS, C_PTS, D_PTS, EPSILON));
    }
    @Test
    public void testLIC10FalseWhenValuesTooSmall() {
        final ArrayList<Point> POINTS = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(2,2), new Point(3,3),
        new Point(4,4), new Point(5,5)));
        final int C_PTS = 1;
        final int D_PTS = 1;
        final double EPSILON = 1;
        final int NUMPOINTS = 5;
        assertFalse(lic10(POINTS,NUMPOINTS, C_PTS, D_PTS, EPSILON));
    }

    @Test
    public void testLIC11TrueWhenPointsBetweenE_PTSAndF_PTSHaveAreaGreaterThanAREA1() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,-5), new Point(1,1), new Point(-1,-5), new Point(1,1)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 5;
        final int E_PTS = 1;
        final int F_PTS = 2;

        assertTrue(lic11(testPoints, NUMPOINTS, AREA1, E_PTS, F_PTS));
    }
    @Test
    public void testLIC11FalseWhenPointsBetweenE_PTSAndF_PTSDoesntHaveAreaGreaterThanAREA1() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,2), new Point(1,3), new Point(1,4), new Point(1,5)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 5;
        final int E_PTS = 2;
        final int F_PTS = 1;

        assertFalse(lic11(testPoints, NUMPOINTS, AREA1, E_PTS, F_PTS));
    }
    @Test
    public void testLIC13TrueWhenDistanceIsGreaterThanLength1andLessThanLength2(){
        final ArrayList<Point> points =
                new ArrayList<>(Arrays.asList(new Point(1,1), new Point(2,2), new Point(3,3), new Point(1,4), new Point(5,5)));
        final int NUMPOINTS = 5;
        final int KPTS = 1;
        final int LENGTH1 = 2;
        final int LENGTH2 = 2;

        assertTrue(lic13(points, KPTS, LENGTH1, LENGTH2, NUMPOINTS));
    }
    @Test
    public void testLIC13FalseWhenDistanceIsLesserThanLength1OrGreaterThanLength2(){
        final ArrayList<Point> points =
                new ArrayList<>(Arrays.asList(new Point(1,1), new Point(2,2), new Point(1,1), new Point(2,2), new Point(1,1)));
        final int NUMPOINTS = 5;
        final int KPTS = 1;
        final int LENGTH1 = 2;
        final int LENGTH2 = 2;

        assertFalse(lic13(points, KPTS, LENGTH1, LENGTH2, NUMPOINTS));
    }
    @Test
    public void testLIC13FalseWhenLength2OrNumpointsTooSmall(){
        final ArrayList<Point> points =
                new ArrayList<>(Arrays.asList(new Point(1,1), new Point(2,2), new Point(3,3), new Point(1,4), new Point(5,5)));
        final int NUMPOINTS = 3;
        final int KPTS = 1;
        final int LENGTH1 = 2;
        final int LENGTH2 = 1;

        assertFalse(lic13(points, KPTS, LENGTH1, LENGTH2, NUMPOINTS));
    }

    @Test
    public void testLIC14TrueWhenPointsBetweenA_PTSAndB_PTSAreOutsideRADIUS1AndInsideRADIUS2() {
        ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 1), new Point(2, -1), new Point(1, 2)));
        final int RADIUS1 = 1;
        final int RADIUS2 = 2;
        final int A_PTS = 2;
        final int B_PTS = 1;
        assertFalse(lic14(testPoints, testPoints.size(), RADIUS1, RADIUS2, A_PTS, B_PTS));
    }

    @Test
    public void testLIC14FalseWhenPointsBetweenA_PTSAndB_PTSAreNotOutsideRADIUS1OrInsideRADIUS2() {
        ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(2,1), new Point(2,-1), new Point(1,2), new Point(2, 2)));
        final int RADIUS1 = 1;
        final int RADIUS2 = 2;
        final int A_PTS = 2;
        final int B_PTS = 2;
        assertFalse(lic14(testPoints, testPoints.size(), RADIUS1, RADIUS2, A_PTS, B_PTS));
    }

    @Test
    public void testLIC15TrueWhenPointsBetweenE_PTSAndF_PTSHaveAreaGreaterThanAREA1AndLesserThanAREA2() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,-5), new Point(1,1), new Point(-1,-5), new Point(1,1), new Point(5, 5)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 3;
        final int AREA2 = 10;
        final int E_PTS = 1;
        final int F_PTS = 2;

        assertTrue(lic15(testPoints, NUMPOINTS, AREA1, AREA2, E_PTS, F_PTS));
    }
    @Test
    public void testLIC15FalseWhenPointsBetweenE_PTSAndF_PTSDoesntHaveAreaGreaterThanAREA1OrLesserThanAREA2() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,2), new Point(1,3), new Point(1,4), new Point(1,5)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 5;
        final int AREA2 = 5;
        final int E_PTS = 2;
        final int F_PTS = 1;

        assertFalse(lic15(testPoints, NUMPOINTS, AREA1, AREA2, E_PTS, F_PTS));
    }
}
