
import algorithm.Dijkstra;
import util.LabyrinthGenerator;
import data.graph.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import util.FileIO;





public class Main {


    public static void main(String[] args){
        
        String[] stringArray = FileIO.readFileIntoStringArray(new File("src/input.txt"));
        
        /*
        String[] stringArray = new String[4];
        stringArray[0] = "#...s";
        stringArray[1] = ".#.##";
        stringArray[2] = ".#..#";
        stringArray[3] = "#.##g";
        */
        
        
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        
        Dijkstra d = new Dijkstra(graph);
        d.solve();
        
    }
    
    
}
