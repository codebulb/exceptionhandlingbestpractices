package ch.codebulb.exceptionhandling.magicalerrorcodes;

import ch.codebulb.exceptionhandling.DummyExceptionHandler;

public class MagicalErrorCodesClass {
    void doBusiness() throws MagicalErrorCodeException {
        // Throw respective exception on error
        throw new MagicalErrorCodeException(MagicalErrorCodeException.Reason.INPUT_EMPTY);
    }
    
    public void callBusiness() {
        try {
            doBusiness();
        } catch (MagicalErrorCodeException ex) {
            switch (ex.reason) {
                case INPUT_EMPTY:
                    DummyExceptionHandler.handleCriticalError(ex);
                    break;
                case INPUT_NOT_NUMERICAL:
                    DummyExceptionHandler.showMessage("Input must be numerical.");
                    break;
                case INPUT_TOO_LONG:
                    DummyExceptionHandler.showMessage("Input contains too many digits.");
                    break;
                default:
                    throw new IllegalArgumentException("Exception reason not supported: " + ex.reason);
            }
        }
    }
}
