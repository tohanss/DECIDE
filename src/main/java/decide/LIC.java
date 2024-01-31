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

  /**
   * Method for LIC 1
   * There exists at least one set of two consecutive data points that are a distance greater than
   * the length, LENGTH1, apart.
   * (0 ≤ LENGTH1)
   *
   * @param points Array containing the coordinates of data points
   * @param length1 Distance that two consecutive points need to be apart from each other
   * @return True if LIC 1 is met
   */
  protected boolean LIC1(final ArrayList<Point> points, final double length1) {
    assert (length1 >= 0);
    for (int i = 0; i < points.size() - 1; i++) {
      Point a = points.get(i);
      Point b = points.get(i + 1);
      Point distVec = new Point(a.x - b.x, a.y - b.y);
      double dist = Math.sqrt(distVec.x * distVec.x + distVec.y * distVec.y);
      if (dist > length1) return true;
    }
    return false;
  }

  private boolean lic2() {
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

  /**
   * Method to calculate the CMV.
   *
   * @return the CMV
   */
  @SuppressWarnings("checkstyle:magicnumber")
  public boolean[] calculateCmv() {
    boolean[] cmv = new boolean[15];

    cmv[0] = lic0();
    //cmv[1] = LIC1();
    cmv[2] = lic2();
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
