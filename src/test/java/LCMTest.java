import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class LCMTest {

    Parameters params = new Parameters();

    @Test
    /**
    * @Test assures we get the same LCM as we set it as
    **/
    public void testLCMEqual() {
        params.LENGTH1 = 10;

        Point[] dp = new Point[]{new Point(8, 7), new Point(6, 5), new Point(4, 3), new Point(2, 1)};

        LCM[][] lcmempty = new LCM[15][15];
        LCM[][] lcm = new LCM[15][15];
        for(int i = 0;i<15;i++){
            for(int j = 0; j<15;j++){
                lcm[i][j] = LCM.ANDD;
            }
        }

        CMV cmv = new CMV(params, dp);
        cmv.populate();

        assertArrayEquals(cmv.getLCM(), lcmempty);

        cmv.setLCM(lcm);
        assertArrayEquals(cmv.getLCM(), lcm);

        lcm[0][2] = LCM.NOTUSED;
        lcm[5][6] = LCM.ORR;
        cmv.setLCM(lcm);

        assertArrayEquals(cmv.getLCM(), lcm);

        lcm[0][6] = LCM.NOTUSED;
        lcm[2][10] = LCM.ORR;
        assertNotEquals(cmv.getLCM(), lcm);

    }
}