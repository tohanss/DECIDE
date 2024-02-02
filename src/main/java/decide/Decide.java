package decide;

/**
 * Class to the Decide problem.
 */
public final class Decide {
  private Decide() {
  }

  private static boolean decide(final String filePath) {
    InputReader reader = new InputReader(filePath);

    boolean[] cmv = LIC.calculateCmv(
        reader.getParameters(),
        reader.getPoints(),
        reader.getNumPoints());

    boolean[][] pum = DecideHelper.calculatePum(
        cmv,
        reader.getLogicalConnectorMatrix());

    boolean[] fuv = DecideHelper.calculateFuv(
        pum,
        reader.getPreliminaryUnlockingVector());

    return DecideHelper.calculateLaunch(fuv);

  }

  /**
   * Entry point of the program.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) throws Exception {
    if (args.length < 1) {
      throw new Exception("No input file provided!");
    }
    String filePath = args[1];

    boolean launch = Decide.decide(filePath);
    if (launch) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
