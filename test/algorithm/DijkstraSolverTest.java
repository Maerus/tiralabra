
package algorithm;

import data.graph.Vertex;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import util.FileIO;
import util.LabyrinthGenerator;
import util.TileType;

public class DijkstraSolverTest {
    DijkstraSolver d;
    
    public DijkstraSolverTest() {
        String[] stringArray = FileIO.readFileIntoStringArray(new File("test/testinput.txt"));
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        d = new DijkstraSolver(graph);
    }

    /**
     * Test of solve method, of class DijkstraSolver.
     */
    @Test
    public void testSolve() {
        d.solve();
        assertEquals(12, d.getGoal().getDistance());
        assertEquals(13, d.getPathArray().length);
        assertEquals(TileType.START, d.getPathArray()[0].getTileType());
    }
    
}
