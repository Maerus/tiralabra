
package util;

import data.graph.Edge;
import data.graph.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;

public class LabyrinthGeneratorTest {
    
    public LabyrinthGeneratorTest() {
    }

    /**
     * vertices have correct amount of neighbors
     */
    @Test
    public void testGraphFromStringArrayNeihborAmount() {
        String[] stringArray = new String[3];
        stringArray[0] = "..s";
        stringArray[1] = ".##";
        stringArray[2] = "..g";
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        int a = 0;
        Edge[] t1 = graph[0][0].getLinks();
        for (int i = 0; i < t1.length; i++) {
            if( t1[i] != null ){
                a++;
            }
        }
        int b = 0;
        Edge[] t2 = graph[1][0].getLinks();
        for (int i = 0; i < t2.length; i++) {
            if( t2[i] != null ){
                b++;
            }
        }
        int c = 0;
        Edge[] t3 = graph[1][1].getLinks();
        for (int i = 0; i < t3.length; i++) {
            if( t3[i] != null ){
                c++;
            }
        }
        assertEquals(3, a);
        assertEquals(5, b);
        assertEquals(8, c);
    }
    
    /**
     * tiles have correct tileTypes based on char
     */
    @Test
    public void testGraphFromStringArrayCorrectTileTypes() {
        String[] stringArray = new String[3];
        stringArray[0] = "..s";
        stringArray[1] = ".##";
        stringArray[2] = "..g";
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        
        assertEquals(TileType.START, graph[0][2].getTileType());
        assertEquals(TileType.FLOOR, graph[0][0].getTileType());
        assertEquals(TileType.WALL, graph[1][1].getTileType());
        assertEquals(TileType.GOAL ,graph[2][2].getTileType());
    }
    
    
}
