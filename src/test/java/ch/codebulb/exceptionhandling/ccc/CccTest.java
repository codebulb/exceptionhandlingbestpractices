package ch.codebulb.exceptionhandling.ccc;

import ch.codebulb.exceptionhandling.ccc.fixed.CccClassFixed;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CccTest {
    @Test
    public void testAntiPattern() {
        CccClass classUnderTest = new CccClass();
        try {
            classUnderTest.getFileName(null);
            fail(); // Expect exception
        } catch (NullPointerException ex) {
            // There's a nullpointer exception.
            // But the original exception has been swallowed.
        }
        try {
            classUnderTest.getFileName("notExistingFile");
            fail(); // Expect exception
        } catch (RuntimeException ex) {
            assertEquals(FileNotFoundException.class, ex.getCause().getClass());
        }
    }
    
    @Test
    public void testFixed() {
        CccClassFixed classUnderTest = new CccClassFixed();
        
        try {
            classUnderTest.getFileName(null);
            fail(); // Expect exception
        } catch (IllegalArgumentException ex) {}
        try {
            classUnderTest.getFileName("notExistingFile");
            fail(); // Expect exception
        }
        catch (RuntimeException ex) {
            assertEquals(FileNotFoundException.class, ex.getCause().getClass());
        }
    }
}
