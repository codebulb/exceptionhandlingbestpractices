package ch.codebulb.exceptionhandling.swallow.fixed;

import java.io.File;
import java.io.FileNotFoundException;

public class SwallowingClassFixed {
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
    
    public String getFileName() throws SwallowingExceptionFixed {
        File file = null;
        try {
            file = tryLoadFile();
        } catch (FileNotFoundException ex) {
            throw new SwallowingExceptionFixed(FILE_PATH, ex);
        }
        return file.getName();
    }
}
