package decide;

import java.awt.Point;
import java.awt.geom.Point2D;
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
      if (distance(a, center) > radius1
          && distance(b, center) > radius1
          && distance(c, center) > radius1) {
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
   * @param quads     Least number of quadrants that should be covered minus 1
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
   * There exists at least one set of two data points separated by exactly K_PTS
   * consecutive intervening points that are a distance greater than the length,
   * LENGTH1, apart. The condition is not met when NUMPOINTS &lt; 3.
   * 
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @param kpts      Number of intervening points
   * @param length1   Distance that two points need to be from each other
   * @return true iff LIC 8 is met
   */
  protected boolean lic8(final ArrayList<Point> points, final int numpoints, final int kpts, final double length1) {
    if (numpoints < 3)
      return false;

    double distance;

    for (int i = 0; i < numpoints - kpts - 1; i++) {
      distance = distance(points.get(i), points.get(i + kpts + 1));
      if (Double.compare(distance, length1) == 1)
        return true;
    }
    return false;
  }

  /**
   * There exists at least one set of N_PTS consecutive data points such that at
   * least one of the points lies a distance greater than DIST from the line
   * joining the first and last of these N_PTS points. If the first and last
   * points of these N_PTS are identical, then the calculated distance to
   * compare with DIST will be the distance from the coincident point to all
   * other points of the N_PTS consecutive points. The condition is not met
   * when NUMPOINTS < 3.
   * (3 ≤ N_PTS ≤ NUMPOINTS), (0 ≤ DIST)
   *
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @param npts      Number of consecutive points
   * @param dist      Distance
   *
   * @return true iff LIC 7 is satisfied
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic7(
      final ArrayList<Point2D> points,
      final int numpoints,
      final int npts,
      final double dist) {

    if (numpoints < 3) {
      return false;
    }

    if (npts > numpoints || npts < 3) {
      return false;
    }

    if (dist < 0) {
      return false;
    }

    for (int i = 0; i < numpoints - npts + 1; i++) {
      Point2D firstPoint = points.get(i);
      Point2D lastPoint = points.get(i + npts - 1);

      boolean isLine = !firstPoint.equals(lastPoint);

      if (isLine) {
        for (int j = i + 1; j < i + npts - 1; j++) {
          double distance = pointToLineDistance(
              points.get(j),
              firstPoint,
              lastPoint);
          if (Double.compare(distance, dist) == 1) {
            return true;
          }
        }
      } else {
        for (int j = i + 1; j < i + npts - 1; j++) {
          double distance = pointToPointDistance(points.get(j), firstPoint);
          if (Double.compare(distance, dist) == 1) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * There exists at least one set of three data points separated by exactly
   * cpts and dpts consecutive intervening points, respectively,
   * that form an angle such that:
   * angle < (PI − EPSILON) or angle > (PI + EPSILON)
   * The second point of the set of three points is always the vertex
   * of the angle. If either the first point or the last point
   * (or both) coincide with the vertex,
   * the angle is undefined and the LIC
   * is not satisfied by those three points.
   * When numpoints < 5, the condition is not met.
   * 1 ≤ C PTS, 1 ≤ D PTS
   * C PTS+D PTS ≤ numpoints − 3
   *
   * @param cpts      Number of intervening points
   * @param dpts      Number of intervening points
   * @param epsilon   Deviation from pi
   * @param numpoints Number of planar data points
   * @param points    Array containing the coordinates of data points
   * @return true if lic 10 is met
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic10(
      final ArrayList<Point> points,
      final int numpoints,
      final int cpts,
      final int dpts,
      final double epsilon) {
    if (numpoints < 5 || cpts <= 1 || dpts <= 1
        || cpts + dpts > (numpoints - 3)) {
      return false;
    }

    Point a;
    Point b;
    Point c;
    for (int i = 0; i < points.size() - cpts - dpts - 2; i++) {
      a = points.get(i);
      b = points.get(i + cpts + 1);
      c = points.get(i + cpts + dpts + 2);
      if (a.equals(b) || c.equals(b)) {
        return false;
      }
      double ab = a.distance(b);
      double bc = b.distance(c);
      double ac = a.distance(c);
      double angle = Math.acos((ab * ab + bc * bc - ac * ac) / (2 * ab * bc));
      if (angle < Math.PI - epsilon || angle > Math.PI + epsilon) {
        return true;
      }
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
   * There exists at least one set of three data points,
   * separated by exactly A PTS and B PTS
   * consecutive intervening points, respectively,
   * that cannot be contained within or on a circle of
   * radius RADIUS1. In addition, there exists at least
   * one set of three data points (which can be
   * the same or different from the three data points
   * just mentioned) separated by exactly A PTS
   * and B PTS consecutive intervening points, respectively,
   * that can be contained in or on a circle of radius RADIUS2.
   * Both parts must be true for the LIC to be true. The condition is
   * not met when NUMPOINTS is &lt; 5.
   * (0 ≤ RADIUS2)
   *
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @param radius1   1st Radius in LICs
   * @param radius2   2nd Radius in LICs
   * @param apts      Number of points between the 1st and the 2nd data points
   * @param bpts      Number of points between the 2nd and the 3rd data points
   * @return true iff LIC 14 is met
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic14(
      final ArrayList<Point> points,
      final int numpoints,
      final int radius1,
      final int radius2,
      final int apts,
      final int bpts) {
    assert (radius2 >= 0);
    if (numpoints < 5) {
      return false;
    }
    boolean isOutside = false;
    boolean isInside = false;
    for (int i = 0; i < numpoints - apts - bpts; i++) {
      Point a = points.get(i);
      Point b = points.get(i + apts);
      Point c = points.get(i + apts + bpts);
      Point center = new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
      if (distance(a, center) > radius1
          && distance(b, center) > radius1
          && distance(c, center) > radius1) {
        isOutside = true;
      }
      if (distance(a, center) <= radius2
          && distance(b, center) <= radius2
          && distance(c, center) <= radius2) {
        isInside = true;
      }
    }

    return isOutside && isInside;
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
   * Calculates the distance between a point and a line using Heron's formula.
   *
   * @param point
   * @param lineStart
   * @param lineEnd
   * @return the distance
   */
  private double pointToLineDistance(
      final Point2D point,
      final Point2D lineStart,
      final Point2D lineEnd) {
    double i = pointToPointDistance(point, lineStart);
    double j = pointToPointDistance(lineStart, lineEnd);
    double k = pointToPointDistance(point, lineEnd);

    double s = (i + j + k) / 2;
    double area = Math.sqrt(s * (s - i) * (s - j) * (s - k));

    return (2 * area) / j;
  }

  /**
   * Calculates the distance between two points.
   *
   * @param point1
   * @param point2
   * @return the distance
   */
  private double pointToPointDistance(
      final Point2D point1,
      final Point2D point2) {
    double x1 = point1.getX();
    double y1 = point1.getY();

    double x2 = point2.getX();
    double y2 = point2.getY();

    double i = x2 - x1;
    double j = y2 - y1;

    return Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
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
