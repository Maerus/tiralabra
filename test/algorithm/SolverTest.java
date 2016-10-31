
package algorithm;

import data.graph.Vertex;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import util.FileIO;
import util.LabyrinthGenerator;
import util.TileType;

public class SolverTest {
    Solver solver;
    Solver solver2;
    
    public SolverTest() {
        String[] stringArray = FileIO.readFileIntoStringArray(new File("test/testinput.txt"));
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        solver = new Solver(graph, 1, false);
        solver2 = new Solver(graph, 1, true);
    }

    /**
     * Test of solve method, of class DijkstraSolver.
     */
    @Test
    public void testSolve() {
        solver.solve();
        assertEquals(12, solver.getGoal().getDistance());
        assertEquals(13, solver.getPath().length);
        assertEquals(TileType.START, solver.getPath()[0].getTileType());
        solver2.solve();
        assertEquals(12, solver2.getGoal().getDistance());
        assertEquals(13, solver2.getPathArray().length);
        assertEquals(TileType.START, solver2.getPathArray()[0].getTileType());
    }
    
    @Test
    public void testSolveWithDijkstra(){
        solver.solveWithDijkstra(true);
        assertEquals(12, solver.getGoal().getDistance());
        assertEquals(13, solver.getPath().length);
        assertEquals(TileType.START, solver.getPath()[0].getTileType());
        solver.solveWithDijkstra(false);
        assertEquals(12, solver.getGoal().getDistance());
        assertEquals(13, solver.getPath().length);
        assertEquals(TileType.START, solver.getPath()[0].getTileType());
    }
    
    @Test
    public void testSolveWithBellmanFord(){
        solver.solveWithBellmanFord();
        assertEquals(12, solver.getGoal().getDistance());
        assertEquals(13, solver.getPath().length);
        assertEquals(TileType.START, solver.getPath()[0].getTileType());
    }
    
    @Test
    public void testSolveWithAStar(){
        solver.solveWithAStar();
        assertEquals(12, solver.getGoal().getDistance());
        assertEquals(13, solver.getPath().length);
        assertEquals(TileType.START, solver.getPath()[0].getTileType());
    }
}
