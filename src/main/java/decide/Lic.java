package decide;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Class for the LIC functions.
 */
public class Lic {

  protected boolean lic0() {
    return false;
  }

  protected boolean lic1() {
    return false;
  }

  protected boolean lic2() {
    return false;
  }

  protected boolean lic3() {
    return false;
  }

  protected boolean lic4() {
    return false;
  }

  protected boolean lic5() {
    return false;
  }

  /**
   * There exists at least one set of N_PTS consecutive data points such that at
   * least one of the points lies a distance greater than DIST from the line
   * joining the first and last of these N_PTS points. If the first and last
   * points of these N_PTS are identical, then the calculated distance to compare
   * with DIST will be the distance from the coincident point to all other points
   * of the N_PTS consecutive points. The condition is not met when NUMPOINTS < 3.
   * (3 ≤ N_PTS ≤ NUMPOINTS), (0 ≤ DIST)
   * 
   * @param points    Array containing the coordinates of data points
   * @param numpoints The number of planar data points
   * @param npts      Number of consecutive points
   * @param dist      Distance
   * 
   * @return true iff LIC 6 is satisfied
   */
  protected boolean lic6(final ArrayList<Point2D> points, final int numpoints, final int npts, final double dist) {

    if (numpoints < 3)
      return false;

    if (npts > numpoints || npts < 3)
      return false;

    if (dist < 0)
      return false;

    for (int i = 0; i < numpoints - npts + 1; i++) {
      Point2D firstPoint = points.get(i);
      Point2D lastPoint = points.get(i + npts - 1);

      boolean isLine = !firstPoint.equals(lastPoint);

      if (isLine)
        for (int j = i + 1; j < i + npts - 1; j++) {
          double distance = pointToLineDistance(points.get(j), firstPoint, lastPoint);
          if (Double.compare(distance, dist) == 1)
            return true;
        }
      else
        for (int j = i + 1; j < i + npts - 1; j++) {
          double distance = pointToPointdistance(points.get(j), firstPoint);
          if (Double.compare(distance, dist) == 1)
            return true;
        }

    }

    return false;

  }

  protected boolean lic7() {
    return false;
  }

  protected boolean lic8() {
    return false;
  }

  protected boolean lic9() {
    return false;
  }

  protected boolean lic10() {
    return false;
  }

  protected boolean lic11() {
    return false;
  }

  protected boolean lic12() {
    return false;
  }

  protected boolean lic13() {
    return false;
  }

  protected boolean lic14() {
    return false;
  }

  /**
   * Method to calculate the CMV.
   * 
   * @param parameters Input parameters matrix
   * @return the CMV
   */
  @SuppressWarnings("checkstyle:magicnumber")
  public boolean[] calculateCmv(final Parameters parameters) {
    boolean[] cmv = new boolean[15];

    return cmv;
  }

  /**
   * Calculates the distance between a point and a line using Heron's formula.
   * 
   * @param point
   * @param lineStart
   * @param lineEnd
   * @return the distance
   */
  private double pointToLineDistance(Point2D point, Point2D lineStart, Point2D lineEnd) {
    double i = pointToPointdistance(point, lineStart);
    double j = pointToPointdistance(lineStart, lineEnd);
    double k = pointToPointdistance(point, lineEnd);

    double s = (i + j + k) / 2;
    double area = Math.sqrt(s * (s - i) * (s - j) * (s - k));

    double distance = (2 * area) / j;
    return distance;
  }

  /**
   * Calculates the distance between two points.
   * 
   * @param point1
   * @param point2
   * @return the distance
   */
  private double pointToPointdistance(Point2D point1, Point2D point2) {
    double x1 = point1.getX(), y1 = point1.getY();
    double x2 = point2.getX(), y2 = point2.getY();

    double i = x2 - x1;
    double j = y2 - y1;

    return Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
  }
}
