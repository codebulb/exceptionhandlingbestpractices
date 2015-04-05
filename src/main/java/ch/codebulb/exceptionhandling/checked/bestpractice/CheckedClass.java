package ch.codebulb.exceptionhandling.checked.bestpractice;

import ch.codebulb.exceptionhandling.DummyExceptionHandler;

public class CheckedClass {
    private void validate(String input) throws ValidationException {
        if (input == null) {
            throw new ValidationException(input);
        }
    }
    
    public void callBusiness() {
        try {
            validate(null);
        } catch (ValidationException ex) {
            DummyExceptionHandler.showMessage(ex.getMessage());
        }
    }
    
}
