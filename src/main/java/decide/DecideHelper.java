package decide;

/**
 * Class with help-methods to the Decide Class.
 */
public final class DecideHelper {
  private DecideHelper() {
  };

  /**
   * Calculate PMU based on CMV and LCM.
   *
   * @param cmv CMV vector
   * @param lcm LCM matrix
   * @return PUM vector
   */
  public static boolean[][] calculatePum(
      final boolean[] cmv,
      final String[][] lcm) {
    int len = cmv.length;
    assert (len > 0);
    assert (lcm.length == len);
    boolean[][] pum = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (lcm[i][j] == "ANDD") {
          pum[i][j] = cmv[i] & cmv[j];
        } else if (lcm[i][j] == "ORR") {
          pum[i][j] = cmv[i] | cmv[j];
        } else if (lcm[i][j] == "NOTUSED") {
          pum[i][j] = true;
        }
      }
    }
    return pum;
  }

  /**
   * Calculate PUV based on PUM.
   *
   * @param pum PUM matrix
   * @param puv PUV vector
   * @return FUV vector
   */
  public static boolean[] calculateFuv(
      final boolean[][] pum,
      final boolean[] puv) {
    int len = pum.length;
    assert (puv.length == len);
    boolean[] fuv = new boolean[len];
    for (int i = 0; i < len; i++) {
      if (!puv[i]) {
        fuv[i] = true;
        continue;
      }

      boolean row = true;
      for (int j = 0; j < len; j++) {
        row &= pum[i][j];
      }

      if (row) {
        fuv[i] = true;
      } else {
        fuv[i] = false;
      }
    }
    return fuv;
  }

  /**
   * Calculate Launch.
   *
   * @param fuv FUV vector
   * @return should launch or not
   */
  public static boolean calculateLaunch(final boolean[] fuv) {
    boolean r = true;
    for (int i = 0; i < fuv.length; i++) {
      r &= fuv[i];
    }
    return r;
  }
}
