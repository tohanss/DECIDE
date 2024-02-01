package decide;


/**
 * Class to the Decide problem.
 */
public final class Decide {
  private Decide(String filePath) {
    InputReader reader = new InputReader(filePath);

    LIC lics = new LIC(input.getParameters(), input.getPoints(), input.getNumPoints());
    cmv = lics.calculateCmv();

    pum = DecideHelper.calculatePum(cmv, reader.getLogicalConnectorMatrix());

    fuv = DecideHelper.calculateFuv(pum, reader.getPreliminaryUnlockingVector());

    boolean launch = DecideHelper.calculateLaunch(fuv);

    if (launch) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  /**
   * Entry point of the program.
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    String filePath = args[0];

    Decide decide = new Decide(filePath);
  }
}
