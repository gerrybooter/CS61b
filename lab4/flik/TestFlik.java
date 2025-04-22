package flik;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestFlik {
    @Test
    public void Test1() {
        boolean result = Flik.isSameNumber(128, 128);
        assertTrue("如果失败了，就说明实际不相等",result);
    }


}
