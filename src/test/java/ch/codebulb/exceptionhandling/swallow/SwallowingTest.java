package ch.codebulb.exceptionhandling.swallow;

import ch.codebulb.exceptionhandling.swallow.fixed.SwallowingClassFixed;
import ch.codebulb.exceptionhandling.swallow.fixed.SwallowingExceptionFixed;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

public class SwallowingTest {
    @Test
    public void testAntiPattern() {
        SwallowingClass classUnderTest = new SwallowingClass();
        try {
            classUnderTest.getFileName();
            fail(); // Expect exception
        }
        catch (SwallowingException ex) {
            assertEquals("getFileName", ex.getStackTrace()[0].getMethodName());
            assertNull(ex.getCause());
        }
    }
    
    @Test
    public void testFixed() {
        SwallowingClassFixed classUnderTest = new SwallowingClassFixed();
        try {
            classUnderTest.getFileName();
            fail(); // Expect exception
        }
        catch (SwallowingExceptionFixed ex) {
            assertEquals("tryLoadFile", ex.getCause().getStackTrace()[0].getMethodName());
        }
    }
}
