package ch.codebulb.exceptionhandling.checked.bestpractice;

public class ValidationException extends Exception {
    String input;

    public ValidationException(String input) {
        this.input = input;
    }

    @Override
    public String getMessage() {
        return input + " is invalid.";
    }
}
