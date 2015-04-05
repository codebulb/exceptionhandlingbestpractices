package ch.codebulb.exceptionhandling.swallow.fixed;

public class SwallowingExceptionFixed extends Exception {
    private final String filePath;

    public SwallowingExceptionFixed(String filePath, Throwable cause) {
        super(cause);
        this.filePath = filePath;
    }

    @Override
    public String getMessage() {
        return filePath + " could not be found.";
    }
}
