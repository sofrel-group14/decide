import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PointTest{
    @Test
    /**
     * @Test if a Point has the correct Values
     **/
    public void testSimpleAssert(){
        Point p = new Point(10,12);
        assertTrue(p.X == 10 && p.Y == 12);
    }
}