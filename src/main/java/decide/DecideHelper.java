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
        assert (lcm[i].length == len);
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
}
