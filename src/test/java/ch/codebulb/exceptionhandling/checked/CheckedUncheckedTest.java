package ch.codebulb.exceptionhandling.checked;

import ch.codebulb.exceptionhandling.checked.fixed.CheckedUncheckedCallerFixed;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CheckedUncheckedTest {
    @Test
    public void testAntiPattern() {
        CheckedUncheckedCaller classUnderTest = new CheckedUncheckedCaller();
        try {
            classUnderTest.callBusiness();
        }
        catch (Exception ex) {
            // Don't expect exception - it has been swalloed
            fail();
        }
    }
    
    @Test
    public void testFixed() {
        CheckedUncheckedCallerFixed classUnderTest = new CheckedUncheckedCallerFixed();
        try {
            classUnderTest.callBusiness();
            fail(); // Expect exception
        }
        catch (RuntimeException ex) {
            // Don't expect exception - it has been swalloed
            assertEquals(FileNotFoundException.class, ex.getCause().getClass());
        }
    }
}
