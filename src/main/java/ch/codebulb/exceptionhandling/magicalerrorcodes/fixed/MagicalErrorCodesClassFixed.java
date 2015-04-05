package ch.codebulb.exceptionhandling.magicalerrorcodes.fixed;

import ch.codebulb.exceptionhandling.DummyExceptionHandler;

public class MagicalErrorCodesClassFixed {
    // Set to public for junit test
    public void doBusiness() throws MagicalErrorCodeExceptionFixed, CriticalException {
        // Throw respective exception on error
        throw new CriticalException();
    }
    
    public void callBusiness() {
        try {
            doBusiness();
        } catch (CriticalException ex) {
            DummyExceptionHandler.handleCriticalError(ex);
        } catch (MagicalErrorCodeExceptionFixed ex) {
            DummyExceptionHandler.showMessage(ex.getMessage());
        }
    }
}
