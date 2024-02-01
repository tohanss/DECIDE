package decide;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Class for the LIC functions.
 */
public class LIC {

  /**
   * Method for LIC 1
   * There exists at least one set of two consecutive data points that
   * are a distance greater than the length, LENGTH1, apart.
   * (0 ≤ LENGTH1)
   *
   * @param points  Array containing the coordinates of data points
   * @param length1 Distance that two points need to be from each other
   * @return True if LIC 1 is met
   */
  protected boolean lic1(final ArrayList<Point> points, final double length1) {
    assert (length1 >= 0);
    for (int i = 0; i < points.size() - 1; i++) {
      Point a = points.get(i);
      Point b = points.get(i + 1);
      Point distVec = new Point(a.x - b.x, a.y - b.y);
      double dist = Math.sqrt(distVec.x * distVec.x + distVec.y * distVec.y);
      if (dist > length1) {
        return true;
      }
    }
    return false;
  }

  /**
   * There exists at least one set of three consecutive data points that
   * cannot all be contained within or on a circle of radius RADIUS1.
   * (0 ≤ RADIUS1)
   *
   * @param points  Array containing the coordinates of data points.
   * @param radius1 Radius of circle that should not cover the points.
   * @return True if LIC2 is met
   */
  @SuppressWarnings("checkstyle:MagicNumber")
  protected boolean lic2(final ArrayList<Point> points, final double radius1) {
    assert (radius1 >= 0);
    Point a;
    Point b;
    Point c;
    for (int i = 0; i < points.size() - 2; i++) {
      a = points.get(i);
      b = points.get(i + 1);
      c = points.get(i + 2);
      Point center = new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
      if (distance(a, center) >= radius1
          && distance(b, center) >= radius1
          && distance(c, center) >= radius1) {
        return true;
      }
    }
    return false;
  }

  /**
   * A method for LIC 4.
   * There exists at least one set of three consecutive data points that are
   * the vertices of a triangle with area greater than AREA1
   *
   * @param points Array containing the coordinates of data points
   * @param area1  Area in LICs
   * @return true iff LIC 4 is met
   */
  protected boolean lic4(final ArrayList<Point> points, final int area1) {
    Point a;
    Point b;
    Point c;
    int area;
    for (int i = 0; i < points.size() - 2; i++) {
      a = points.get(i);
      b = points.get(i + 1);
      c = points.get(i + 2);
      area = Math.abs(
          (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))) / 2;
      if (area > area1) {
        return true;
      }
    }
    return false;
  }

  /**
   * LIC 5
   * There exists at least one set of Q PTS consecutive data points that lie
   * in more than QUADS quadrants. Where there is ambiguity as to which
   * quadrant contains a given point, priority of decision will be by
   * quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
   * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l)
   * is in quadrant III, the point (0,1) is in quadrant I and the point (1,0)
   * is in quadrant I. (2 ≤ Q PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
   *
   * @param points    Array containing the coordinates of data points
   * @param qpts      Number of consecutive points
   * @param quads     Least number of quadrants that should be inhabited minus one
   * @param numpoints Number of points in points array
   * @return True if LIC 5 is met
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic5(
      final ArrayList<Point> points,
      final int qpts,
      final int quads,
      final int numpoints) {
    assert (qpts > 1 && qpts <= numpoints);
    assert (quads > 0 && quads < 4);

    HashSet<Integer> usedQuadrants;

    for (int i = 0; i < numpoints - qpts + 1; i++) {
      usedQuadrants = new HashSet<Integer>();
      for (int j = 0; j < qpts; j++) {
        usedQuadrants.add(getQuadFromPoint(points.get((i + j))));
      }
      if (usedQuadrants.size() > quads) {
        return true;
      }
    }
    return false;
  }

  /**
   * There exists at least one set of two consecutive data points, (X[i], Y[i])
   * and (X[j], Y[j]), such that X[j] - X[i] < 0. (where i = j - 1)
   * 
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @return true iff LIC 6 is met
   */
  protected boolean lic6(final ArrayList<Point> points, final int numpoints) {
    for (int i = 0; i < numpoints - 1; i++) {
      double x1 = points.get(i).getX();
      double x2 = points.get(i + 1).getX();

      if (Double.compare(x2 - x1, 0) == -1)
        return true;
    }
    return false;
  }

  /**
   * There exists at least one set of three data points separated by exactly
   * E PTS and F PTS consecutive intervening points, respectively, that are
   * the vertices of a triangle with area greater
   * than AREA1. The condition is not met when NUMPOINTS &lt; 5.
   *
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @param area1     Area in LICs
   * @param epts      Number of points between the 1st and the 2nd data point
   * @param fpts      Number of points between the 2nd and the 3rd data point
   * @return true iff LIC 10 is met
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic11(
      final ArrayList<Point> points,
      final int numpoints,
      final int area1,
      final int epts,
      final int fpts) {
    if (numpoints < 5) {
      return false;
    }
    Point a;
    Point b;
    Point c;
    int area;
    for (int i = 0; i < numpoints - epts - fpts; i++) {
      a = points.get(i);
      b = points.get(i + epts);
      c = points.get(i + epts + fpts);
      area = Math.abs(
          (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))) / 2;
      if (area > area1) {
        return true;
      }
    }
    return false;
  }

  /**
   * There exists at least one set of three data points, separated by
   * exactly E_PTS and F_PTS consecutive intervening points, respectively,
   * that are the vertices of a triangle with area greater than AREA1.
   * In addition, there exist three data points (which can be the same or
   * different from the three data points just mentioned) separated by
   * exactly E PTS and F PTS consecutive intervening points, respectively,
   * that are the vertices of a triangle with area less than AREA2. Both
   * parts must be true for the LIC to be true. The condition is not met
   * when NUMPOINTS &lt; 5.
   *
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @param area1     1st Area in LICs
   * @param area2     2nd Area in LICs
   * @param epts      Number of points between the 1st and the 2nd data point
   * @param fpts      Number of points between the 2nd and the 3rd data point
   * @return true iff LIC 14 is met
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic15(
      final ArrayList<Point> points,
      final int numpoints,
      final int area1,
      final int area2,
      final int epts,
      final int fpts) {
    if (numpoints < 5) {
      return false;
    }
    Point a;
    Point b;
    Point c;
    double area;
    boolean isGreater = false;
    boolean isLesser = false;
    for (int i = 0; i < points.size() - epts - fpts; i++) {
      a = points.get(i);
      b = points.get(i + epts);
      c = points.get(i + epts + fpts);
      area = Math.abs(
          (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))) / 2.0;
      if (area > area1) {
        isGreater = true;
      }
      if (area < area2) {
        isLesser = true;
      }
    }
    return isGreater && isLesser;
  }

  /**
   * Method to get the signed distance between two points.
   *
   * @param a Point a
   * @param b Point b
   * @return Double
   */
  private double distance(final Point a, final Point b) {
    Point distVec = new Point(a.x - b.x, a.y - b.y);
    return Math.sqrt(distVec.x * distVec.x + distVec.y * distVec.y);
  }

  /**
   * Method to get which quadrant around the origin a point is.
   * 
   * @param point Point
   * @return The quadrant as 1, 2, 3, or 4
   */
  @SuppressWarnings("checkstyle:MagicNumber")
  private int getQuadFromPoint(final Point point) {
    if (point.x >= 0 && point.y >= 0) {
      return 1;
    } else if (point.x < 0 && point.y >= 0) {
      return 2;
    } else if (point.x <= 0 && point.y < 0) {
      return 3;
    } else {
      return 4;
    }
  }

  /**
   * Method to calculate the CMV.
   *
   * @return the CMV
   */
  @SuppressWarnings("checkstyle:magicnumber")
  public boolean[] calculateCmv() {
    boolean[] cmv = new boolean[15];

    return cmv;
  }
}
