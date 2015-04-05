package ch.codebulb.exceptionhandling.finegrained;

public class AllmightyException extends Exception {
    public AllmightyException(String message) {
        super(message);
    }

    public AllmightyException(Throwable cause) {
        super(cause);
    }
}
