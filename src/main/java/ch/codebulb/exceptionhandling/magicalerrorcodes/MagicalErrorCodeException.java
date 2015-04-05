package ch.codebulb.exceptionhandling.magicalerrorcodes;

public class MagicalErrorCodeException extends Exception {
    public final Reason reason;
    
    public static enum Reason {
        INPUT_EMPTY,
        INPUT_TOO_LONG,
        INPUT_NOT_NUMERICAL,
    }

    public MagicalErrorCodeException(Reason reason) {
        this.reason = reason;
    }
}
