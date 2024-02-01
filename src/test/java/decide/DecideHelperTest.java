package decide;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A class to test the methods in the DecideHelper-class.
 */
public class DecideHelperTest {
  /**
   * Test calculatePum
   */
  @Test
  public void pumTest() {
    boolean[] cmv = {
        false, true, true, true, false
    };
    String[][] lcm = {
        { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED" },
        { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED" },
        { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED" },
        { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED" },
        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
    };

    boolean[][] pum = DecideHelper.calculatePum(cmv, lcm);
    assertEquals(pum[0][1], false);
    assertEquals(pum[0][4], true);
    assertEquals(pum[2][1], true);
    assertEquals(pum[2][3], true);
    assertEquals(pum[3][0], false);
  }

  /**
   * Test calculateFuv
   */
  @Test
  public void fuvTest() {
    boolean[][] pum = {
        { true, true, false },
        { true, true, true },
        { true, true, true },
    };
    boolean[] puv = {
        true, true, false
    };
    boolean[] fuv = DecideHelper.calculateFuv(pum, puv);
    assertEquals(fuv[0], false);
    assertEquals(fuv[1], true);
    assertEquals(fuv[2], true);
  }
}
