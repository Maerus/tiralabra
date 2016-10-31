
import algorithm.Solver;
import util.LabyrinthGenerator;
import data.graph.Vertex;
import java.io.File;
import util.CmdLine;
import util.FileIO;

public class Main {

    public static void main(String[] args) {

        //the array contains the paths to the performance test files
        String[] pfTest = new String[6];
        pfTest[0] = "src/perf1.txt";
        pfTest[1] = "src/perf1v2.txt";
        pfTest[2] = "src/perf2.txt";
        pfTest[3] = "src/perf3.txt";
        pfTest[4] = "src/perf4.txt";
        pfTest[5] = "src/perf5.txt";

        CmdLine cmd = new CmdLine();
        String fileStr = cmd.selectFile();
        int repeatCount;
        boolean printPath;

        if (fileStr.equals("pftest")) {
            repeatCount = 1000000;
            printPath = false;
            Solver solver;
            for (int i = 0; i < pfTest.length; i++) {
                String[] stringArray = FileIO.readFileIntoStringArray(new File(pfTest[i]));
                Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
                solver = new Solver(graph, repeatCount, printPath);
                solver.solve();
            }
            return;
        }
        repeatCount = cmd.selectRepeatCount();
        printPath = cmd.selectToPrintPath();
        String[] stringArray = FileIO.readFileIntoStringArray(new File(fileStr));
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        Solver solver = new Solver(graph, repeatCount, printPath);
        solver.solve();
    }

}
