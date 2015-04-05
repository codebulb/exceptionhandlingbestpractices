package ch.codebulb.exceptionhandling.finegrained;

import java.io.File;
import java.io.FileNotFoundException;

public class FineGrainedClass {
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
    
    public String getFileName(String input) throws AllmightyException {
        if (input == null) {
            throw new AllmightyException("Input must not be null");
        }
        File file;
        try {
            file = tryLoadFile();
        } catch (FileNotFoundException ex) {
            throw new AllmightyException(ex);
        }
        return file.getName();
    }
}
