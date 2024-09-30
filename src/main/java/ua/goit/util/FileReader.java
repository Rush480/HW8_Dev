package ua.goit.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String readFile(Path pathToFile) {
        String result = null;
        try {
          result = Files.readString(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
