package ch.codebulb.exceptionhandling.magicalerrorcodes.fixed;

public class MagicalErrorCodeExceptionFixed extends Exception {
    private final Reason reason;
    
    public static enum Reason {
        CRITICAL(null),
        INPUT_TOO_LONG("Input must be numerical."),
        INPUT_NOT_NUMERICAL("Input contains too many digits.");
        
        private final String message;

        private Reason(String message) {
            this.message = message;
        }
    }

    public MagicalErrorCodeExceptionFixed(Reason reason) {
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return reason.message;
    }
}
