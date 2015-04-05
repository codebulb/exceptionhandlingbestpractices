package ch.codebulb.exceptionhandling.nullreturn;

import java.io.File;

public class NullReturnClass {
    private static final String FILE_PATH = "my/file/path.txt";
    
    private File tryLoadFile() {
        // let's assume file loading failed
        boolean fileLoadedSuccessfully = false;
        
        if (fileLoadedSuccessfully) {
            return new File(FILE_PATH);
        }
        else {
            return null;
        }
    }
    
    public String getFileName() {
        File file = tryLoadFile();
        return file.getName();
    }
}
