package decide;

import java.awt.geom.Point2D;

/**
 * Class for the LIC functions.
 */
public class Lic {

  private Parameters parameters;
  private Point2D[] points;

  /**
   * Constructor for the Lic class.
   * 
   * @param parameters
   * @param points
   */
  public Lic(final Parameters parameters, Point2D[] points) {
    this.parameters = parameters;
    this.points = points;
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
   * @param parameters Input parameters matrix
   * @return the CMV
   */
  @SuppressWarnings("checkstyle:magicnumber")
  public boolean[] calculateCmv(final Parameters parameters) {
    boolean[] cmv = new boolean[15];

    cmv[0] = lic0();
    cmv[1] = lic1();
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
