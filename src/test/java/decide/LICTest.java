package decide;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LICTest extends LIC{
    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void testLIC14TrueWhenPointsBetweenE_PTSAndF_PTSHaveAreaGreaterThanAREA1AndLesserThanAREA2() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,-5), new Point(1,1), new Point(-1,-5), new Point(1,1)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 3;
        final int AREA2 = 10;
        final int E_PTS = 1;
        final int F_PTS = 2;

        assertTrue(LIC_14(testPoints, NUMPOINTS, AREA1, AREA2, E_PTS, F_PTS));
    }
    @Test
    public void testLIC14FalseWhenPointsBetweenE_PTSAndF_PTSDoesntHaveAreaGreaterThanAREA1OrLesserThanAREA2() {
        final ArrayList<Point> testPoints = new ArrayList<>(Arrays.asList(new Point(1,1), new Point(1,2), new Point(1,3), new Point(1,4), new Point(1,5)));
        final int NUMPOINTS = testPoints.size();

        final int AREA1 = 5;
        final int AREA2 = 5;
        final int E_PTS = 2;
        final int F_PTS = 1;

        assertFalse(LIC_14(testPoints, NUMPOINTS, AREA1, AREA2, E_PTS, F_PTS));
    }
}
