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
}
