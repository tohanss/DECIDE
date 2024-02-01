package decide;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

  private JSONParser jsonParser;

  public InputReader(String filePath){
  }
}
