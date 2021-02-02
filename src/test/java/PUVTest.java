import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final public class PUVTest {

    Parameters params = new Parameters();

    @Test
    /**
     * @Test assures we get the same PUV as we set it as
     **/
    public void testPUVEqual() {
        params.LENGTH1 = 10;

        Point[] dp = new Point[]{new Point(8, 7), new Point(6, 5), new Point(4, 3), new Point(2, 1)};

        boolean[] puv = new boolean[15];

        CMV cmv = new CMV(params, dp);

        assertArrayEquals(cmv.getPUV(), puv);
        
        for(int i = 0;i<15;i++){
             puv[i]= false;
        }
        
        cmv.setPUV(puv);
        assertArrayEquals(cmv.getPUV(), puv);

        puv[0] = true;
        puv[2] = true;
        puv[3] = true;

        cmv.setPUV(puv);
        assertArrayEquals(cmv.getPUV(), puv);

        puv[5] = true;
        puv[7] = true;

        assertNotEquals(cmv.getPUV(), puv);

    }
}