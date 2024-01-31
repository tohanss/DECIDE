package decide;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LICTest extends LIC{
    @Test
    public void test() {
        assertTrue(true);
    }


    /*Test that lic2 is true when there exist at least three consecutive data points that form
    an angle that is either less than (PI-E1SILON) or more than (PI + EPSILON)*/
    @Test
    public void testLIC2TrueIfAngleIsLessThanPI(){
        ArrayList<Point> points = new ArrayList<Point>(Arrays.asList(new Point(0, 0), new Point(1, 1),
                new Point(1, 0)));
        double EPSILON = 1;
        assertTrue(LIC_2(points, EPSILON));
    }
    /*Test that lic2 is false when the vertex coincide with either of the other points*/
    @Test
    public void testLIC2FalseIfAngleIsUndefined(){
        ArrayList<Point> points = new ArrayList<Point>(Arrays.asList(new Point(1, 1), new Point(1, 1),
                new Point(0, 0)));
        double EPSILON = 1;
        assertFalse(LIC_2(points, EPSILON));
    }
    /*Test that lic2 is false when there does not exist a set of at least three consecutive data points that form
    an angle that is either less than (PI-EPSILON) or more than (PI + EPSILON)*/
    @Test
    public void testLIC2FalseIf3ConsecutivePointsDoNotExist(){
        ArrayList<Point> points = new ArrayList<Point>(Arrays.asList(new Point(1, 0), new Point(2, 0),
                new Point(3, 0)));
        double EPSILON = 1;
        assertFalse(LIC_2(points, EPSILON));
    }
}
