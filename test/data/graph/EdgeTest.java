
package data.graph;

import org.junit.Test;
import static org.junit.Assert.*;
import util.TileType;

public class EdgeTest {
    
    public EdgeTest() {
    }

    /**
     * Test of getLinkedVertex method, of class Edge.
     */
    @Test
    public void testGetLinkedVertex() {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Edge e = new Edge(v1, v2);
        assertEquals(v1, e.getLinkedVertex(v2));
        assertEquals(v2, e.getLinkedVertex(v1));
    }
    
    /**
     * Test that weight is set correctly
     */
    @Test
    public void testWeight1(){
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        v1.setTile(TileType.FLOOR);
        v2.setTile(TileType.FLOOR);
        Edge e = new Edge(v1, v2);
        assertEquals(1.0001f, e.getWeight(), 0.001f);
    }
    
    /**
     * Test that weight is set correctly
     */
    @Test
    public void testWeight2(){
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        v1.setTile(TileType.FLOOR);
        v2.setTile(TileType.WALL);
        Edge e = new Edge(v1, v2);
        assertEquals(1000f, e.getWeight(), 0.001f);
    }
    
    /**
     * Test that weight is set correctly
     */
    @Test
    public void testWeight3(){
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        v1.setTile(TileType.WALL);
        v2.setTile(TileType.WALL);
        Edge e = new Edge(v1, v2);
        assertEquals(1000f, e.getWeight(), 0.001f);
    }
    
}
