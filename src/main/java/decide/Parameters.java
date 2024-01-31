package decide;

/**
 * Class for the different parameters.
 */
@SuppressWarnings({
    "checkstyle:ParameterNumber",
    "checkstyle:JavadocVariable",
    "checkstyle:JavadocMethod" })
public final class Parameters {
  private final double length1;
  private final double radius1;
  private final double epsilon;
  private final double area1;
  private final int qpts;
  private final int quads;
  private final double dist;
  private final int npts;
  private final int kpts;
  private final int apts;
  private final int bpts;
  private final int cpts;
  private final int dpts;
  private final int epts;
  private final int fpts;
  private final int gpts;
  private final double length2;
  private final double radius2;
  private final double area2;

  /**
   * Length in LICs 0, 7, 12.
   * @return the parameter
   */
  public double getLength1() {
    return length1;
  }

  /**
   * Radius in LICs 1, 8, 13.
   * @return the parameter
   */
  public double getRadius1() {
    return radius1;
  }

  /**
   * Deviation from PI in LICs 2, 9.
   * @return the parameter
   */
  public double getEpsilon() {
    return epsilon;
  }

  /**
   * Area in LICs 3, 10, 14.
   * @return the parameter
   */
  public double getArea1() {
    return area1;
  }

  /**
   * No of consecutive points in LIC 4.
   * @return the parameter
   */
  public int getQpts() {
    return qpts;
  }

  /**
   * No of quadrants in LIC 4.
   * @return the parameter
   */
  public int getQuads() {
    return quads;
  }

  /**
   * Distance in LIC 6.
   * @return the parameter
   */
  public double getDist() {
    return dist;
  }

  /**
   * No of consecutive pts . in LIC 6.
   * @return the parameter
   */
  public int getNpts() {
    return npts;
  }

  /**
   * No of int. pts. in LICs 7, 12.
   * @return the parameter
   */
  public int getKpts() {
    return kpts;
  }

  /**
   * No of int. pts. in LICs 8, 13.

   * @return the parameter
   */
  public int getApts() {
    return apts;
  }

  /**
   * No of int. pts. in LICs 8, 13.
   * @return the parameter
   */
  public int getBpts() {
    return bpts;
  }

  /**
   * No of int. pts. in LIC 9.
   * @return the parameter
   */
  public int getCpts() {
    return cpts;
  }

  /**
   * No of int. pts. in LIC 9.
   * @return the parameter
   */
  public int getDpts() {
    return dpts;
  }

  /**
   * No of int. pts. in LICs 10, 14.
   * @return the parameter
   */
  public int getEpts() {
    return epts;
  }

  /**
   * No of int. pts. in LICs 10, 14.
   * @return the parameter
   */
  public int getFpts() {
    return fpts;
  }

  /**
   * No of int. pts. in LIC 11.
   * @return the parameter
   */
  public int getGpts() {
    return gpts;
  }

  /**
   * Maximum length in LIC 12.
   * @return the parameter
   */
  public double getLength2() {
    return length2;
  }

  /**
   * Maximum radius in LIC 13.
   * @return the parameter
   */
  public double getRadius2() {
    return radius2;
  }

  /**
   * Maximum area in LIC 14.
   * @return the parameter
   */
  public double getArea2() {
    return area2;
  }

  /**
   * Constructor for Parameters class.
   * @return the parameter
   */
  @SuppressWarnings({ "checkstyle:HiddenField",
      "checkstyle:MissingJavadocMethod" })
  public Parameters(final double length1,
      final double radius1,
      final double epsilon,
      final double area1,
      final int qpts,
      final int quads,
      final double dist,
      final int npts,
      final int kpts,
      final int apts,
      final int bpts,
      final int cpts,
      final int dpts,
      final int epts,
      final int fpts,
      final int gpts,
      final double length2,
      final double radius2,
      final double area2) {
    this.length1 = length1;
    this.radius1 = radius1;
    this.epsilon = epsilon;
    this.area1 = area1;
    this.qpts = qpts;
    this.quads = quads;
    this.dist = dist;
    this.npts = npts;
    this.kpts = kpts;
    this.apts = apts;
    this.bpts = bpts;
    this.cpts = cpts;
    this.dpts = dpts;
    this.epts = epts;
    this.fpts = fpts;
    this.gpts = gpts;
    this.length2 = length2;
    this.radius2 = radius2;
    this.area2 = area2;
  }
}
