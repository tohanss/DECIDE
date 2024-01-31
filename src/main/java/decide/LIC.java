package decide;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Class for the LIC functions.
 */
public class LIC {
  private boolean lic0() {
    return false;
  }

  private boolean lic1() {
    return false;
  }

  /**
   * There exists at least one set of three consecutive data points that
   * cannot all be contained within or on a circle of radius RADIUS1.
   * (0 ≤ RADIUS1)
   *
   * @param points Array containing the coordinates of data points.
   * @param radius1 Radius of circle that should not cover the points.
   * @return True if LIC2 is met
   */
  protected boolean lic2(final ArrayList<Point> points, final double radius1) {
    assert (radius1 >= 0);
    Point a;
    Point b;
    Point c;
    for (int i = 0; i < points.size() - 2; i++) {
      a = points.get(i);
      b = points.get(i + 1);
      c = points.get(i + 2);
      Point center = new Point((a.x + b.x + c.x)/3, (a.y + b.y + c.y)/3);
      if (
          distance(a, center) >= radius1 &&
          distance(b, center) >= radius1 &&
          distance(c, center) >= radius1
      ) {
        return true;
      }
    }
    return false;
  }

  private boolean lic3() {
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

  private boolean lic10() {
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

  private boolean lic14() {
    return false;
  }

  private double distance(Point a, Point b) {
    Point distVec = new Point(a.x - b.x, a.y - b.y);
    return Math.sqrt(distVec.x * distVec.x + distVec.y * distVec.y);
  }

  /**
   * Method to calculate the CMV.
   *
   * @return the CMV
   */
  @SuppressWarnings("checkstyle:magicnumber")
  public boolean[] calculateCmv() {
    boolean[] cmv = new boolean[15];

    cmv[0] = lic0();
    cmv[1] = lic1();
    //cmv[2] = lic2();
    cmv[3] = lic3();
    cmv[4] = lic4();
    cmv[5] = lic5();
    cmv[6] = lic6();
    cmv[7] = lic7();
    cmv[8] = lic8();
    cmv[9] = lic9();
    cmv[10] = lic10();
    cmv[11] = lic11();
    cmv[12] = lic12();
    cmv[13] = lic13();
    cmv[14] = lic14();

    return cmv;
  }
}
