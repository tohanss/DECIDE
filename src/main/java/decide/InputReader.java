package decide;

import java.awt.geom.Point2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InputReader {
  private int numPoints;
  private ArrayList<Point2D> points;
  private Parameters parameters;
  private String[][] logicalConnectorMatrix;
  private boolean[] preliminaryUnlockingVector;

  public InputReader(String filePath){
    JSONParser jsonParser = new JSONParser();

    try(FileReader reader = new FileReader(filePath)) {
      Object object = jsonParser.parse(reader);

      JSONObject inputVariables = (JSONObject) object;

      numPoints = ((Long) inputVariables.get("NUMPOINTS")).intValue();

      points = parsePoints((JSONArray) inputVariables.get("POINTS"));

      parameters = parseParameters((JSONObject) inputVariables.get("PARAMETERS"));

      logicalConnectorMatrix = parseLogicalConnectorMatrix((JSONArray) inputVariables.get("LCM"));

      preliminaryUnlockingVector = parsePreliminaryUnlockingVector((JSONArray) inputVariables.get("PUV"));

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  private ArrayList<Point2D> parsePoints(final JSONArray jsonPoints){
    ArrayList<Point2D> parsedPoints = new ArrayList<>();
    jsonPoints.forEach(point -> parsePoint(parsedPoints, (JSONObject) point));
    return parsedPoints;
  }

  private void parsePoint(ArrayList<Point2D> parsedPoints, final JSONObject jsonPoint){
    final double x = ((Long) jsonPoint.get("x")).doubleValue();
    final double y = ((Long) jsonPoint.get("y")).doubleValue();
    parsedPoints.add(new Point2D.Double(x, y));
  }

  private Parameters parseParameters(final JSONObject jsonParameters){
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

  private String[][] parseLogicalConnectorMatrix(final JSONArray jsonLogicalConnectorMatrix){
    String[][] parsedLogicalConnectorMatrix = new String[15][15];
    for(int i = 0; i < jsonLogicalConnectorMatrix.size(); i++){
      JSONArray jsonLogicalConnectorArray = (JSONArray) jsonLogicalConnectorMatrix.get(i);
      for(int j = 0; j < jsonLogicalConnectorArray.size(); j++){
        parsedLogicalConnectorMatrix[i][j] = (String) jsonLogicalConnectorArray.get(j);
      }
    }
    return parsedLogicalConnectorMatrix;
  }

  private boolean[] parsePreliminaryUnlockingVector(final JSONArray jsonPreliminaryUnlockingVector){
    boolean[] parsedPreliminaryUnlockingVector = new boolean[15];
    for(int i = 0; i < jsonPreliminaryUnlockingVector.size(); i++){
      parsedPreliminaryUnlockingVector[i] = (boolean) jsonPreliminaryUnlockingVector.get(i);
    }
    return parsedPreliminaryUnlockingVector;
  }

  public int getNumPoints() {
    return numPoints;
  }

  public ArrayList<Point2D> getPoints() {
    return points;
  }

  public Parameters getParameters() {
    return parameters;
  }

  public String[][] getLogicalConnectorMatrix() {
    return logicalConnectorMatrix;
  }

  public boolean[] getPreliminaryUnlockingVector() {
    return preliminaryUnlockingVector;
  }
}
