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
                    new Point(0,0),
                    new Point(1,0),
                    new Point(2,0),
                    new Point(0,0)
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
}
