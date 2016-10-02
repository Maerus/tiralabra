
package data.graph;

import org.junit.Test;
import static org.junit.Assert.*;

public class VertexTest {
    
    public VertexTest() {
    }
    
    /**
     * addLink adds an edge to a new vertex with no links
     */
    @Test
    public void testAddLink1() {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Edge e = new Edge(v1, v2);
        v1.addLink(e);
        assertTrue(v1.getEdges()[0].equals(e));
    }
    
    /**
     * addLink adds to array in order
     */
    @Test
    public void testAddLink2() {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Edge e = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);
        v1.addLink(e);
        v1.addLink(e2);
        assertTrue(v1.getEdges()[0].equals(e));
        assertTrue(v1.getEdges()[1].equals(e2));
    }
    
    /**
     * addLink adds to array in order
     */
    @Test
    public void testAddLink3() {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Edge e = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);
        v1.addLink(e);
        v1.addLink(e2);
        assertEquals(e, v1.getEdges()[0]);
        assertEquals(e2, v1.getEdges()[1]);
        assertNotSame(e2, v1.getEdges()[0]);
    }
    
}
