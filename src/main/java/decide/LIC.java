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

    private boolean LIC_2() {
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

    private boolean LIC_14(ArrayList<Point> POINTS, int AREA1, int AREA2, int E_PTS, int F_PTS){
        if(POINTS.size() < 5){ return false; }
        Point A, B, C;
        double area;
        boolean isGreater = false, isLesser = false;
        for(int i = 0; i < POINTS.size() - E_PTS - F_PTS; i++){
            A = POINTS.get(i);
            B = POINTS.get(i + E_PTS);
            C = POINTS.get(i + E_PTS + F_PTS);
            area = Math.abs((A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)))/2.0;
            if(area > AREA1){
                isGreater = true;
            }
            if(area < AREA2){
                isLesser = true;
            }
        }
        return isGreater && isLesser;
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
        //CMV[14] = LIC_14();

        return CMV;
    }
}
