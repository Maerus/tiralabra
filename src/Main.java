
import algorithm.DijkstraSolver;
import util.LabyrinthGenerator;
import data.graph.Vertex;
import java.io.File;
import util.FileIO;





public class Main {


    public static void main(String[] args){
        
        String[] stringArray = FileIO.readFileIntoStringArray(new File("src/input.txt"));
        
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        
        DijkstraSolver d = new DijkstraSolver(graph);
        d.solve();
        
    }
    
    
}
