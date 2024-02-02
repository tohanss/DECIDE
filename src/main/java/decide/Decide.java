package decide;


/**
 * Class to the Decide problem.
 */
public final class Decide {

  /**
   * Constructor of the Decide problem.
   *
   * @param filePath path to the JSON-file
   */
  private Decide(String filePath) {
    InputReader reader = new InputReader(filePath);

    LIC lics = new LIC(reader.getParameters(), reader.getPoints(), reader.getNumPoints());
    boolean[] cmv = lics.calculateCmv();

    boolean[][] pum = DecideHelper.calculatePum(cmv, reader.getLogicalConnectorMatrix());

    boolean[] fuv = DecideHelper.calculateFuv(pum, reader.getPreliminaryUnlockingVector());

    boolean launch = DecideHelper.calculateLaunch(fuv);

    if (launch) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  /**
   * Entry point of the program.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    String filePath = args[0];

    Decide decide = new Decide(filePath);
  }
}