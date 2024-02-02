package decide;

import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
 * Class to the Decide problem.
 */
public final class Decide {
  private Decide() {
  }

  /**
   * Decide from parameters given.
   *
   * @param parameters given parameters
   * @param points planner points
   * @param numPoints number of points
   * @param lcm LCM
   * @param puv PUV
   *
   * @return decision of launch
   */
  public static boolean decide(
      final Parameters parameters,
      final ArrayList<Point2D> points,
      final int numPoints,
      final String[][] lcm,
      final boolean[] puv) {

    boolean[] cmv = LIC.calculateCmv(
        parameters,
        points,
        numPoints);

    boolean[][] pum = DecideHelper.calculatePum(
        cmv,
        lcm);

    boolean[] fuv = DecideHelper.calculateFuv(
        pum,
        puv);

    return DecideHelper.calculateLaunch(fuv);

  }

  /**
   * Decide from a file.
   *
   * @param filePath path of the file
   *
   * @return decision of launch
   */
  public static boolean decideFile(final String filePath) {

    InputReader reader = new InputReader(filePath);

    boolean launch = Decide.decide(
        reader.getParameters(),
        reader.getPoints(),
        reader.getNumPoints(),
        reader.getLogicalConnectorMatrix(),
        reader.getPreliminaryUnlockingVector());
    return launch;
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

    if (decideFile(filePath)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
