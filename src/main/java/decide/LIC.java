package decide;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

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

  private boolean lic2() {
    return false;
  }

  private boolean lic3() {
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
   * @param points Array containing the coordinates of data points
   * @param qpts Number of consecutive points
   * @param quads Least number of quadrants that should be inhabited minus one
   * @param numpoints Number of points in points array
   * @return True if LIC 5 is met
   */
  @SuppressWarnings("checkstyle:magicnumber")
  protected boolean lic4(
          final ArrayList<Point> points,
          final int qpts,
          final int quads,
          final int numpoints
  ) {
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

    cmv[0] = lic0();
    cmv[1] = lic1();
    cmv[2] = lic2();
    cmv[3] = lic3();
    //cmv[4] = lic4();
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
