package decide;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * A class to test the methods in the Lic-class.
 */
public class LicTest extends LIC {
  @Test
  public void test() {
    assertTrue(true);
  }

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
}
