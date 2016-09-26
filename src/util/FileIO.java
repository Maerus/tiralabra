package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Scanner;

public class FileIO {

    public static String[] readFileIntoStringArray(File file) {
        println("\n\n ** " + new Date().toString() + " **\n");
        String[] stringArray = new String[0];
        try {
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()) {
                println(scanner.nextLine());
                index++;
            }
            scanner.close();

            stringArray = new String[index];
            index = 0;

            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                stringArray[index] = scanner.nextLine();
                index++;
            }
            scanner.close();
            println("");
        } catch (Exception e) {
            System.out.println("File read error " + e);
            System.exit(0);
        }
        return stringArray;
    }

    public static void println(String s) {
        print(s + "\n");
    }

    public static void print(String s) {
        try {
            System.out.print(s);
            File file = new File("src/output.txt");
            Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            w.append(s);
            w.close();

        } catch (Exception e) {
            System.out.println("File read/write error " + e);
            System.exit(0);
        }
    }

}
