package decide;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A class to test the methods in the Parameters-class.
 */
public class ParametersTest {
  @Test
  public void test() {
    Parameters p = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    assertTrue(p.getArea1() == 0);
  }
}
