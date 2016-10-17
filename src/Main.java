
import algorithm.Solver;
import util.LabyrinthGenerator;
import data.graph.Vertex;
import java.io.File;
import util.CmdLine;
import util.FileIO;





public class Main {

    public static void main(String[] args){
        
        CmdLine cmd = new CmdLine();
        String fileStr = cmd.selectFile();
        int repeatCount = cmd.selectRepeatCount();
        boolean printPath = cmd.selectToPrintPath();
        
        //String fileStr = "src/labyrinth.txt";
        
        String[] stringArray = FileIO.readFileIntoStringArray(new File(fileStr));
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        Solver solver = new Solver(graph, repeatCount, printPath);
        
        //Solver solver = new Solver(graph, 1, true);

        solver.solve();
        
    }
    
    
}
