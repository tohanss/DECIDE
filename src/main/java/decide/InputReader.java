package decide;

import java.awt.geom.Point2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class to read the input provided from a JSON file.
 */
public class InputReader {
  /** The number of planar data points */
  private int numPoints;
  /** Array containing the coordinates of data points */
  private ArrayList<Point2D> points;
  /** Class holding parameters for LIC’s  */
  private Parameters parameters;
  /** Logical Connector Matrix */
  private String[][] logicalConnectorMatrix;
  /** Preliminary Unlocking Vector */
  private boolean[] preliminaryUnlockingVector;

  /**
   * Constructor to the InputReader class.
   *
   * @param filePath the path to the JSON-file
   */
  public InputReader(String filePath) {
    JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader(filePath)) {
      Object object = jsonParser.parse(reader);

      JSONObject inputVariables = (JSONObject) object;

      numPoints = ((Long) inputVariables.get("NUMPOINTS")).intValue();

      points = parsePoints((JSONArray) inputVariables.get("POINTS"));

      if (numPoints != points.size()) {
        throw new Exception("The amount of points and numpoints is not equal");
      }

      parameters = parseParameters((JSONObject) inputVariables.get("PARAMETERS"));

      logicalConnectorMatrix = parseLogicalConnectorMatrix((JSONArray) inputVariables.get("LCM"));

      preliminaryUnlockingVector =
          parsePreliminaryUnlockingVector((JSONArray) inputVariables.get("PUV"));

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Method to parse the JSON-formatted array of points to correct format.
   *
   * @param jsonPoints JSON-formatted array of points
   * @return parsed points
   */
  private ArrayList<Point2D> parsePoints(final JSONArray jsonPoints) {
    ArrayList<Point2D> parsedPoints = new ArrayList<>();
    jsonPoints.forEach(point -> parsePoint(parsedPoints, (JSONObject) point));
    return parsedPoints;
  }

  /**
   * Method to parse the JSON-formatted point to correct format.
   *
   * @param jsonPoint JSON-formatted point
   */
  private void parsePoint(ArrayList<Point2D> parsedPoints, final JSONObject jsonPoint) {
    final double x = ((Long) jsonPoint.get("x")).doubleValue();
    final double y = ((Long) jsonPoint.get("y")).doubleValue();
    parsedPoints.add(new Point2D.Double(x, y));
  }

  /**
   * Method to parse the JSON-formatted parameters to correct format.
   *
   * @param jsonParameters JSON-formatted parameters
   * @return parsed parameters
   */
  private Parameters parseParameters(final JSONObject jsonParameters) {
    final double length1 = ((Long) jsonParameters.get("LENGTH1")).doubleValue();
    final double radius1 = ((Long) jsonParameters.get("RADIUS1")).doubleValue();
    final double epsilon = ((Long) jsonParameters.get("EPSILON")).doubleValue();
    final double area1 = ((Long) jsonParameters.get("AREA1")).doubleValue();
    final int qpts = ((Long) jsonParameters.get("Q_PTS")).intValue();
    final int quads = ((Long) jsonParameters.get("QUADS")).intValue();
    final double dist = ((Long) jsonParameters.get("DIST")).doubleValue();
    final int npts = ((Long) jsonParameters.get("N_PTS")).intValue();
    final int kpts = ((Long) jsonParameters.get("K_PTS")).intValue();
    final int apts = ((Long) jsonParameters.get("A_PTS")).intValue();
    final int bpts = ((Long) jsonParameters.get("B_PTS")).intValue();
    final int cpts = ((Long) jsonParameters.get("C_PTS")).intValue();
    final int dpts = ((Long) jsonParameters.get("D_PTS")).intValue();
    final int epts = ((Long) jsonParameters.get("E_PTS")).intValue();
    final int fpts = ((Long) jsonParameters.get("F_PTS")).intValue();
    final int gpts = ((Long) jsonParameters.get("G_PTS")).intValue();
    final double length2 = ((Long) jsonParameters.get("LENGTH2")).doubleValue();
    final double radius2 = ((Long) jsonParameters.get("RADIUS2")).doubleValue();
    final double area2 = ((Long) jsonParameters.get("AREA2")).doubleValue();
    return new Parameters(length1, radius1, epsilon, area1, qpts, quads,
        dist, npts, kpts, apts, bpts, cpts, dpts, epts, fpts, gpts,
        length2, radius2, area2);
  }

  /**
   * Method to parse the JSON-formatted LCM to correct format.
   *
   * @param jsonLogicalConnectorMatrix matrix of JSON-formatted LCM
   * @return parsed LCM
   */
  private String[][] parseLogicalConnectorMatrix(final JSONArray jsonLogicalConnectorMatrix) {
    assert jsonLogicalConnectorMatrix.size() == 15;
    String[][] parsedLogicalConnectorMatrix = new String[15][15];
    for (int i = 0; i < jsonLogicalConnectorMatrix.size(); i++) {
      JSONArray jsonLogicalConnectorArray = (JSONArray) jsonLogicalConnectorMatrix.get(i);
      assert jsonLogicalConnectorArray.size() == 15;
      for (int j = 0; j < jsonLogicalConnectorArray.size(); j++) {
        parsedLogicalConnectorMatrix[i][j] = (String) jsonLogicalConnectorArray.get(j);
      }
    }
    return parsedLogicalConnectorMatrix;
  }

  /**
   * Method to parse the JSON-formatted PUV to correct format.
   *
   * @param jsonPreliminaryUnlockingVector array of JSON-formatted PUV
   * @return parsed PUV
   */
  private boolean[] parsePreliminaryUnlockingVector(
      final JSONArray jsonPreliminaryUnlockingVector) {
    boolean[] parsedPreliminaryUnlockingVector = new boolean[15];
    assert jsonPreliminaryUnlockingVector.size() == 15;
    for (int i = 0; i < jsonPreliminaryUnlockingVector.size(); i++) {
      parsedPreliminaryUnlockingVector[i] = (boolean) jsonPreliminaryUnlockingVector.get(i);
    }
    return parsedPreliminaryUnlockingVector;
  }

  /**
   * A get-method for numPoints
   * @return numPoints
   */
  public int getNumPoints() {
    return numPoints;
  }
  /**
   * A get-method for points
   * @return points
   */
  public ArrayList<Point2D> getPoints() {
    return points;
  }

  /**
   * A get-method for parameters
   * @return parameters
   */
  public Parameters getParameters() {
    return parameters;
  }

  /**
   * A get-method for LCM
   * @return LCM
   */
  public String[][] getLogicalConnectorMatrix() {
    return logicalConnectorMatrix;
  }

  /**
   * A get-method for PUV
   * @return PUV
   */
  public boolean[] getPreliminaryUnlockingVector() {
    return preliminaryUnlockingVector;
  }
}
