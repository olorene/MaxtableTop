package TortugaProject;

import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public static FileWriter openFile(String path) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);

        } catch (IOException ex) {
            System.out.println("File \"" + path + "\" haven't opened");
//            ex.printStackTrace();
        }

        return writer;
    }
}
