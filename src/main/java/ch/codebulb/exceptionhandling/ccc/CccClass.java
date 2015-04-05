package ch.codebulb.exceptionhandling.ccc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CccClass {
    private static final String FILE_PATH = "my/file/path.txt";
    
    private File tryLoadFile(String fileName) throws FileNotFoundException {
        // simulate NullpointerException
        if (fileName == null) {
            throw new NullPointerException();
        }
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
            Logger.getLogger(CccClass.class.getName()).log(Level.SEVERE, "Input must not be null");
        }
        File file;
        try {
            file = tryLoadFile(input);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return file.getName();
    }
}
