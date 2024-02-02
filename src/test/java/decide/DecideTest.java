package decide;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.junit.Test;

/**
 * A class to test the methods in the Decide-class.
 */
public class DecideTest {
  @Test
  public void testPositive() {
    File f = new File("src/test/resources/decide/positive.JSON");
    boolean launch = Decide.decideFile(f.getAbsolutePath());
    assertTrue(launch);
  }

  @Test
  public void testNegative() {
    File f = new File("src/test/resources/decide/negative.JSON");
    boolean launch = Decide.decideFile(f.getAbsolutePath());
    assertFalse(launch);
  }

}
