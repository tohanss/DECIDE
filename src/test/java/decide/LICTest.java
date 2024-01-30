package decide;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class LICTest extends LIC{
    @Test
    public void test() {
        assertTrue(true);
    }

  @Test
  public void testLIC3TrueWhenPointsHaveAreaGreaterThanAREA1() {
    final ArrayList<Point> testPoints =
        new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, -5), new Point(-1, -5)));
    final int AREA1 = 5;

    assertTrue(lic3(testPoints, AREA1));
  }

  @Test
  public void testLIC3FalseWhenPointsDoesntHaveAreaGreaterThanAREA1() {
    final ArrayList<Point> testPoints =
        new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));
    final int AREA1 = 4;

    assertFalse(lic3(testPoints, AREA1));
  }
}
