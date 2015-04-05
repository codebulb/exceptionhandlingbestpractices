package ch.codebulb.exceptionhandling.magicalerrorcodes;

import ch.codebulb.exceptionhandling.magicalerrorcodes.fixed.CriticalException;
import ch.codebulb.exceptionhandling.magicalerrorcodes.fixed.MagicalErrorCodeExceptionFixed;
import ch.codebulb.exceptionhandling.magicalerrorcodes.fixed.MagicalErrorCodesClassFixed;
import org.junit.Test;
import static org.junit.Assert.*;

public class MagicalErrorCodesTest {
    @Test
    public void testAntiPattern() {
        MagicalErrorCodesClass classUnderTest = new MagicalErrorCodesClass();
        try {
            classUnderTest.doBusiness();
            fail(); // Expect exception
        }
        catch (Exception ex) {
            // It's always a MagicalErrorCodeException
            // There's no compile time information about the error cause
            assertEquals(MagicalErrorCodeException.class, ex.getClass());
        }
        
    }
    
    @Test
    public void testFixed() {
        MagicalErrorCodesClassFixed classUnderTest = new MagicalErrorCodesClassFixed();
        try {
            classUnderTest.doBusiness();
            fail(); // Expect exception
        }
        catch (CriticalException ex) {
            // Compile time information about the exception type is present
        } catch (MagicalErrorCodeExceptionFixed ex) {
            fail(); // Unexpected exception
        }
    }
}