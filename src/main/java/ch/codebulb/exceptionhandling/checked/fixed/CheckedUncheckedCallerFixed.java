package ch.codebulb.exceptionhandling.checked.fixed;

public class CheckedUncheckedCallerFixed {
    public void callBusiness() {
        String fileName;
        fileName = new CheckedUncheckedClassFixed().getFileName();
    }
}
