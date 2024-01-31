package decide;

import java.awt.*;
import java.util.ArrayList;

public class LIC {
    private boolean LIC_0() {
        return false;
    }

    private boolean LIC_1() {
        return false;
    }

    /* There exists at least one set of three consecutive data points which form an angle such that:
    angle < (PI−EPSILON) or angle > (PI+EPSILON)
    The second of the three consecutive points is always the vertex of the angle. If either the first
    point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
    is not satisfied by those three points.
            (0 ≤ EPSILON < PI)
    @return true if all the conditions are met
    */
    private boolean LIC_2() {
        double EPSILON = 1; //temp value
        Point[] points = new Point[3]; //temp value
        Point A, B, C;
        double angle;
        if ( EPSILON <= 0 || EPSILON > Math.PI) return false;
        for (int i = 0; i < (points.length-2); i++) {
            A = points[i];
            B = points[i+1];
            C = points[i+2];
            if (A.equals(B) || C.equals(B))
               return false;
            double ab = A.distance(B);
            double bc = B.distance(C);
            double ac = A.distance(C);
            angle = Math.acos((ab*ab + bc*bc - ac*ac)/(2*ab*bc));
            if (angle < Math.PI - EPSILON|| angle > Math.PI + EPSILON){
                return true;
            }
        }
        return false;
    }

    private boolean LIC_3() {
        return false;
    }

    private boolean LIC_4() {
        return false;
    }

    private boolean LIC_5() {
        return false;
    }

    private boolean LIC_6() {
        return false;
    }

    private boolean LIC_7() {
        return false;
    }

    private boolean LIC_8() {
        return false;
    }

    private boolean LIC_9() {
        return false;
    }

    private boolean LIC_10() {
        return false;
    }

    private boolean LIC_11() {
        return false;
    }

    private boolean LIC_12() {
        return false;
    }

    private boolean LIC_13() {
        return false;
    }

    private boolean LIC_14() {
        return false;
    }

    public boolean[] calculateCMV() {
        boolean[] CMV = new boolean[15];

        CMV[0] = LIC_0();
        CMV[1] = LIC_1();
        CMV[2] = LIC_2();
        CMV[3] = LIC_3();
        CMV[4] = LIC_4();
        CMV[5] = LIC_5();
        CMV[6] = LIC_6();
        CMV[7] = LIC_7();
        CMV[8] = LIC_8();
        CMV[9] = LIC_9();
        CMV[10] = LIC_10();
        CMV[11] = LIC_11();
        CMV[12] = LIC_12();
        CMV[13] = LIC_13();
        CMV[14] = LIC_14();

        return CMV;
    }
}
