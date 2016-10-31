package util;

import java.util.Scanner;

/**
 * Simple command line interface
 */
public class CmdLine {

    Scanner s;

    /**
     * Constructor for CmdLine. creates a Scanner for reading user inputs.
     */
    public CmdLine() {
        s = new Scanner(System.in);
    }

    /**
     * Prompts the user for labyrinth file
     *
     * @return file path
     */
    public String selectFile() {
        System.out.print("Select a labyrinth file. Leaving empty picks src/labyrinth.txt. Inputting 'pftest' runs the program with preset performance test settings\n> ");
        String input = s.nextLine();
        if (input.isEmpty()) {
            input = "src/labyrinth.txt";
        }
        System.out.println("selecting " + input);
        return input;
    }

    /**
     * Prompts the user for the repeat amount
     *
     * @return the repeat amount
     */
    public int selectRepeatCount() {
        System.out.print("Select how many times the algorithms will be run. Leaving empty runs them once\n> ");
        String input = s.nextLine();
        if (input.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(input);
    }

    /**
     * Prompts the user to choose between printing the paths or not. Choosing
     * not to print will make it easier to see performance results.
     *
     * @return user's wish to print the path
     */
    public boolean selectToPrintPath() {
        System.out.print("Print the path the algorithms will find?\n(yes/no)> ");
        String input = "";
        while (true) {
            input = s.nextLine();
            if (input.contentEquals("yes")) {
                return true;
            } else if (input.contentEquals("no")) {
                return false;
            }
            System.out.print("(yes/no)> ");
        }
    }

}
