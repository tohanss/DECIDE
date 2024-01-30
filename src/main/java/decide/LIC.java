package decide;

import java.awt.Point;
import java.util.ArrayList;

public class LIC {
    private boolean LIC_0() {
        return false;
    }

    private boolean LIC_1() {
        return false;
    }

    private boolean LIC_2() {
        return false;
    }

  /**
   * A method for LIC 3.
   * There exists at least one set of three consecutive data points that are the vertices of a
   * triangle with area greater than AREA1
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
      area = Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))) / 2;
      if (area > area1) {
        return true;
      }
    }
    return false;
  }

    private boolean LIC_4() {
        return false;
    }

    private boolean LIC_5() {
        return false;
    }

    private boolean LIC_6() {
        return false;
    }

    private boolean LIC_7() {
        return false;
    }

    private boolean LIC_8() {
        return false;
    }

    private boolean LIC_9() {
        return false;
    }

    private boolean LIC_10() {
        return false;
    }

    private boolean LIC_11() {
        return false;
    }

    private boolean LIC_12() {
        return false;
    }

    private boolean LIC_13() {
        return false;
    }

    private boolean LIC_14() {
        return false;
    }

    public boolean[] calculateCMV() {
        boolean[] CMV = new boolean[15];

        CMV[0] = LIC_0();
        CMV[1] = LIC_1();
        CMV[2] = LIC_2();
      //CMV[3] = LIC_3();
        CMV[4] = LIC_4();
        CMV[5] = LIC_5();
        CMV[6] = LIC_6();
        CMV[7] = LIC_7();
        CMV[8] = LIC_8();
        CMV[9] = LIC_9();
        CMV[10] = LIC_10();
        CMV[11] = LIC_11();
        CMV[12] = LIC_12();
        CMV[13] = LIC_13();
        CMV[14] = LIC_14();

        return CMV;
    }
}
