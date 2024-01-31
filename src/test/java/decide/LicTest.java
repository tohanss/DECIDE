package decide;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * A class to test the methods in the Lic-class.
 */
public class LicTest extends LIC{
  @Test
  public void test() {
    assertTrue(true);
  }

  @Test
  public void testLIC5TrueWhenEnoughPointsOnQuadrants() {
    final ArrayList<Point> testPoints =
            new ArrayList<Point>(Arrays.asList(
                    new Point(1, 1),
                    new Point(-1,1),
                    new Point(-1, -1)
            ));

    final int QUADS = 2;
    final int Q_PTS = 3;
    final int NUMPOINTS = 3;

    assertTrue(lic4(testPoints, Q_PTS, QUADS, NUMPOINTS));
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

    assertFalse(lic4(testPoints, Q_PTS, QUADS, NUMPOINTS));
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

    lic4(testPoints, Q_PTS, QUADS, NUMPOINTS);
  }
}
