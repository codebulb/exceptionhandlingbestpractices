package ch.codebulb.exceptionhandling.finegrained;

import ch.codebulb.exceptionhandling.finegrained.fixed.FineGrainedClassFixed;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class FineGrainedTest {
    @Test
    public void testAntiPattern() {
        FineGrainedClass classUnderTest = new FineGrainedClass();
        try {
            classUnderTest.getFileName(null);
            fail(); // Expect exception
        } catch (AllmightyException ex) {}
        try {
            classUnderTest.getFileName("notExistingFile");
            fail(); // Expect exception
        } catch (AllmightyException ex) {}
    }
    
    @Test
    public void testFixed() {
        FineGrainedClassFixed classUnderTest = new FineGrainedClassFixed();
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
