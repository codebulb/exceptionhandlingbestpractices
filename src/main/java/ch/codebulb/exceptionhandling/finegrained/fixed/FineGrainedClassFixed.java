package ch.codebulb.exceptionhandling.finegrained.fixed;

import java.io.File;
import java.io.FileNotFoundException;

public class FineGrainedClassFixed {
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
    
    public String getFileName(String input) {
        if (input == null) {
            throw new IllegalArgumentException("'input' must not be null.");
        }
        File file;
        try {
            file = tryLoadFile();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return file.getName();
    }
}
