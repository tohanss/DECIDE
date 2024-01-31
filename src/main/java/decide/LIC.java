package decide;

import java.awt.Point;
import java.util.ArrayList;

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
   * @param points Array containing the coordinates of data points
   * @param length1 Distance that two points need to be from each other
   * @return True if LIC 1 is met
   */
  protected boolean lic0(final ArrayList<Point> points, final double length1) {
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

  private boolean lic1() {
    return false;
  }

  private boolean lic2() {
    return false;
  }

    /**
     * A method for LIC 3.
     * There exists at least one set of three consecutive data points that are
     * the vertices of a triangle with area greater than AREA1
     *
     * @param points Array containing the coordinates of data points
     * @param area1  Area in LICs
     * @return true iff LIC 3 is met
     */
    protected boolean lic3(final ArrayList<Point> points, final int area1) {
        Point a;
        Point b;
        Point c;
        int area;
        for (int i = 0; i < points.size() - 2; i++) {
            a = points.get(i);
            b = points.get(i + 1);
            c = points.get(i + 2);
            area = Math.abs(
                    (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
            ) / 2;
            if (area > area1) {
                return true;
            }
        }
        return false;
    }

  private boolean lic4() {
    return false;
  }

  private boolean lic5() {
    return false;
  }

  private boolean lic6() {
    return false;
  }

  private boolean lic7() {
    return false;
  }

  private boolean lic8() {
    return false;
  }

  private boolean lic9() {
    return false;
  }

    /**
     * There exists at least one set of three data points separated by exactly
     * E PTS and F PTS consecutive intervening points, respectively, that are
     * the vertices of a triangle with area greater
     * than AREA1. The condition is not met when NUMPOINTS < 5.
     * @param points Array containing the coordinates of data points
     * @param numpoints The number of planar data points
     * @param area1 Area in LICs
     * @param epts Number of points between the 1st and the 2nd data point
     * @param fpts Number of points between the 2nd and the 3rd data point
     * @return true iff LIC 10 is met
     */
    @SuppressWarnings("checkstyle:magicnumber")
    protected boolean lic10(
            final ArrayList<Point> points,
            final int numpoints,
            final int area1,
            final int epts,
            final int fpts
    ) {
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
                    (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
            ) / 2;
            if (area > area1) {
                return true;
            }
        }
        return false;
    }

  private boolean lic11() {
    return false;
  }

  private boolean lic12() {
    return false;
  }

  private boolean lic13() {
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
    * when NUMPOINTS < 5.
    *
    * @param points Array containing the coordinates of data points
    * @param numpoints The number of planar data points
    * @param area1 1st Area in LICs
    * @param area2 2nd Area in LICs
    * @param epts Number of points between the 1st and the 2nd data point
    * @param fpts Number of points between the 2nd and the 3rd data point
    * @return true iff LIC 14 is met
    */
    @SuppressWarnings("checkstyle:magicnumber")
    protected boolean lic14(
        final ArrayList<Point> points,
        final int numpoints,
        final int area1,
        final int area2,
        final int epts,
        final int fpts
    ) {
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
                    (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
            ) / 2.0;
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
   * Method to calculate the CMV.
   *
   * @return the CMV
   */
  @SuppressWarnings("checkstyle:magicnumber")
  public boolean[] calculateCmv() {
    boolean[] cmv = new boolean[15];

    //cmv[0] = lic0();
    cmv[1] = lic1();
    cmv[2] = lic2();
    //cmv[3] = lic3();
    cmv[4] = lic4();
    cmv[5] = lic5();
    cmv[6] = lic6();
    cmv[7] = lic7();
    cmv[8] = lic8();
    cmv[9] = lic9();
    //cmv[10] = lic10();
    cmv[11] = lic11();
    cmv[12] = lic12();
    cmv[13] = lic13();
    //cmv[14] = lic14();

    return cmv;
  }
}
