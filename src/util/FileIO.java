package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is used to read a file into a labyrinth to run algorithms on and
 * to print output to both console and an output.txt file
 */
public class FileIO {

    /**
     * Reads a labyrinth text file and converts it into an array of strings
     *
     * @param file the labyrinth file
     * @return an array of strings containing the labyrinth
     */
    public static String[] readFileIntoStringArray(File file) {
        println("\n ** " + file.getName() + " read at " + new Date().toString() + " **\n");
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

    /**
     * Passes the string parameter with a newline to be printed to console and
     * output.txt file
     *
     * @param s string to print
     */
    public static void println(String s) {
        print(s + "\n");
    }

    /**
     * Prints a string to both console and the output.txt file
     *
     * @param s string to print
     */
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
