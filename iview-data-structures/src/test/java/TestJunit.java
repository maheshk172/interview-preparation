import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class TestJunit {
    @Test
    public void testSetup() {
        String str= "I am done with Junit setup";
        assertEquals("I am done with Junit setup",str);
    }
}
