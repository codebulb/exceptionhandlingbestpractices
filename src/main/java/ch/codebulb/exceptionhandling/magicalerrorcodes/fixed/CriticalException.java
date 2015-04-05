package ch.codebulb.exceptionhandling.magicalerrorcodes.fixed;

public class CriticalException extends MagicalErrorCodeExceptionFixed {
    public CriticalException() {
        super(Reason.CRITICAL);
    }
}
