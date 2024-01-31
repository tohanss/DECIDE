package decide;

/**
 * Class for the different parameters.
 */
@SuppressWarnings("checkstyle:ParameterNumber")
public final class Parameters {
  /**
   * Length in LICs 0, 7, 12.
   */
  private final double length1;
  /**
   * Radius in LICs 1, 8, 13.
   */
  private final double radius1;
  /**
   * Deviation from PI in LICs 2, 9.
   */
  private final double epsilon;
  /**
   * Area in LICs 3, 10, 14.
   */
  private final double area1;
  /**
   * No. of consecutive points in LIC 4.
   */
  private final int qpts;
  /**
   * No. of quadrants in LIC 4.
   */
  private final int quads;
  /**
   * Distance in LIC 6.
   */
  private final double dist;
  /**
   * No. of consecutive pts . in LIC 6.
   */
  private final int npts;
  /**
   * No. of int. pts. in LICs 7, 12.
   */
  private final int kpts;
  /**
   * No. of int. pts. in LICs 8, 13.
   */
  private final int apts;
  /**
   * No. of int. pts. in LICs 8, 13.
   */
  private final int bpts;
  /**
   * No. of int. pts. in LIC 9.
   */
  private final int cpts;
  /**
   * No. of int. pts. in LIC 9.
   */
  private final int dpts;
  /**
   * No. of int. pts. in LICs 10, 14.
   */
  private final int epts;
  /**
   * No. of int. pts. in LICs 10, 14.
   */
  private final int fpts;
  /**
   * No. of int. pts. in LIC 11.
   */
  private final int gpts;
  /**
   * Maximum length in LIC 12.
   */
  private final double length2;
  /**
   * Maximum radius in LIC 13.
   */
  private final double radius2;
  /**
   * Maximum area in LIC 14.
   */
  private final double area2;

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getLength1() {
    return length1;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getRadius1() {
    return radius1;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getEpsilon() {
    return epsilon;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getArea1() {
    return area1;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getQpts() {
    return qpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getQuads() {
    return quads;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getDist() {
    return dist;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getNpts() {
    return npts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getKpts() {
    return kpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getApts() {
    return apts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getBpts() {
    return bpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getCpts() {
    return cpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getDpts() {
    return dpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getEpts() {
    return epts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getFpts() {
    return fpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public int getGpts() {
    return gpts;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getLength2() {
    return length2;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getRadius2() {
    return radius2;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public double getArea2() {
    return area2;
  }

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
