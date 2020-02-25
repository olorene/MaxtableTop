package TortugaProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {
    public void writeProductToFile(String path, String line) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(line);
            writer.close();

        } catch (IOException ex) {
            System.out.println("Cannot write into a file " + path);
        }

    }
}
