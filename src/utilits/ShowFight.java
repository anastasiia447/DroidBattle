package utilits;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShowFight {

    public static void show() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("Saved.txt"));
        String value = reader.readLine();
        System.out.println(value);
        while (value != null) {
            value = reader.readLine();
            if (value != null) {
                System.out.println(value);
            }
        }
    }
}
