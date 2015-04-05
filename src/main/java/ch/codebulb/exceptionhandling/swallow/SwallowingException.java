package ch.codebulb.exceptionhandling.swallow;

public class SwallowingException extends Exception {
    private final String filePath;

    public SwallowingException(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMessage() {
        return filePath + " could not be found.";
    }
}
