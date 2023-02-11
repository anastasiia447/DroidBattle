package utilits;

import java.io.*;

public class SaveFight {
    private static ByteArrayOutputStream baos;

    public static void log(String text) {
        PrintStream ps = new PrintStream(baos);
        PrintStream originalStdOut = System.out;

        System.setOut(ps);
        System.out.println(text);
        System.out.flush();
        System.setOut(originalStdOut);

        System.out.println(text);
    }

    public static void setBaos(ByteArrayOutputStream baos) {
        SaveFight.baos = baos;
    }


    public static void save() throws IOException {
        OutputStream fos = new FileOutputStream("Saved.txt");
        baos.writeTo(fos);
    }
}
