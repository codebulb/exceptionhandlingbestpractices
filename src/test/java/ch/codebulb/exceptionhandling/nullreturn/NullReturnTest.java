package ch.codebulb.exceptionhandling.nullreturn;

import ch.codebulb.exceptionhandling.nullreturn.fixed.NullReturnClassFixed;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class NullReturnTest {
    @Test
    public void testAntiPattern() {
        NullReturnClass classUnderTest = new NullReturnClass();
        try {
            classUnderTest.getFileName();
            fail(); // Expect exception
        }
        catch (NullPointerException ex) {
            // There's a nullpointer exception.
            // But the original exception has been swallowed.
        }
    }
    
    @Test
    public void testFixed() {
        NullReturnClassFixed classUnderTest = new NullReturnClassFixed();
        try {
            classUnderTest.getFileName();
            fail(); // Expect exception
        }
        catch (RuntimeException ex) {
            assertEquals(FileNotFoundException.class, ex.getCause().getClass());
        }
    }
}