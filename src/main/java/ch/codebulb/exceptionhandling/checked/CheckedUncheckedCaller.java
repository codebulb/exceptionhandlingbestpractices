package ch.codebulb.exceptionhandling.checked;

import ch.codebulb.exceptionhandling.DummyExceptionHandler;
import java.io.FileNotFoundException;

public class CheckedUncheckedCaller {
    public void callBusiness() {
        String fileName;
        try {
            fileName = new CheckedUncheckedClass().getFileName();
        } catch (FileNotFoundException ex) {
            DummyExceptionHandler.showMessage(ex.getMessage());
        }
    }
}
