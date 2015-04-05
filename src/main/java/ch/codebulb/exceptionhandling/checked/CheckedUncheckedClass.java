package ch.codebulb.exceptionhandling.checked;

import java.io.File;
import java.io.FileNotFoundException;

public class CheckedUncheckedClass {
    private static final String FILE_PATH = "my/file/path.txt";
    
    private File tryLoadFile() throws FileNotFoundException {
        // let's assume file loading failed
        boolean fileLoadedSuccessfully = false;
        
        if (fileLoadedSuccessfully) {
            return new File(FILE_PATH);
        }
        else {
            throw new FileNotFoundException("Could not load file with path " + FILE_PATH);
        }
    }
    
    public String getFileName() throws FileNotFoundException {
        File file = tryLoadFile();
        return file.getName();
    }
}
