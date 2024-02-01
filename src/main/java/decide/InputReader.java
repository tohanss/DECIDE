package decide;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InputReader {
  public enum Entries{
    notUsed,
    andd,
    orr
  }

  private int numPoints;
  private ArrayList<Point2D> points;
  private Parameters parameters;
  private ArrayList<ArrayList<Entries>> LogicalConnectorMatrix;
  private ArrayList<Boolean> PreliminaryUnlockingVector;

  public InputReader(String filePath){
    JSONParser jsonParser = new JSONParser();

    try(FileReader reader = new FileReader(filePath)) {
      Object object = jsonParser.parse(reader);

      JSONObject inputVariables = (JSONObject) object;
      System.out.println(inputVariables);

      numPoints = ((Long) inputVariables.get("NUMPOINTS")).intValue();

      points = parsePoints((JSONArray) inputVariables.get("POINTS"));

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  private ArrayList<Point2D> parsePoints(final JSONArray jsonPoints){
    ArrayList<Point2D> parsedPoints = new ArrayList<>();
    jsonPoints.forEach(point -> parsePoint(parsedPoints, (JSONObject) point));
    return parsedPoints;
  }

  private static void parsePoint(ArrayList<Point2D> parsedPoints, final JSONObject jsonPoint){
    double x = ((Long) jsonPoint.get("x")).doubleValue();
    double y = ((Long) jsonPoint.get("y")).doubleValue();
    parsedPoints.add(new Point2D.Double(x, y));
  }
}
