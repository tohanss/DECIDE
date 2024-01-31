package decide;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * Class with testes of all LICs.
 */
public class LicTest extends LIC {
    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void testLic3TrueWhenPointsHaveAreaGreaterThanArea1() {
        final ArrayList<Point> testPoints =
            new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, -5), new Point(-1, -5)));
        final int area1 = 5;

        assertTrue(lic3(testPoints, area1));
    }

    @Test
    public void testLic3FalseWhenPointsDoesntHaveAreaGreaterThanArea1() {
        final ArrayList<Point> testPoints =
            new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));
        final int area1 = 4;

        assertFalse(lic3(testPoints, area1));
    }

    @Test
    public void testLIC10TrueWhenPointsBetweenE_PTSAndF_PTSHaveAreaGreaterThanAREA1() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,-5), new Point(1,1), new Point(-1,-5), new Point(1,1)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 5;
        final int E_PTS = 1;
        final int F_PTS = 2;

        assertTrue(lic10(testPoints, NUMPOINTS, AREA1, E_PTS, F_PTS));
    }
    @Test
    public void testLIC10FalseWhenPointsBetweenE_PTSAndF_PTSDoesntHaveAreaGreaterThanAREA1() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,2), new Point(1,3), new Point(1,4), new Point(1,5)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 5;
        final int E_PTS = 2;
        final int F_PTS = 1;

        assertFalse(lic10(testPoints, NUMPOINTS, AREA1, E_PTS, F_PTS));
    }
}
