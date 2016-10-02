
package data;

import data.graph.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinHeapTest {
    MinHeap h;
    MinHeap h2;
    
    public MinHeapTest() {
        h = new MinHeap(12);
        h2 = new MinHeap(24);
        for (int i = 1; i < h.getArray().length; i++) {
            Vertex v = new Vertex();
            v.setKey((h.getArray().length - i) * 3);
            h.insert(new HeapNode(v));
            
            Vertex v2 = new Vertex();
            v2.setKey((h.getArray().length - i) * 3);
            h2.insert(new HeapNode(v2));
        }
    }

    /**
     * Test of parent method, of class MinHeap.
     */
    @Test
    public void testParent() {
        int[] t = new int[13];
        t[1] = 0;
        t[2] = 1;
        t[3] = 1;
        t[4] = 2;
        t[5] = 2;
        t[6] = 3;
        t[7] = 3;
        t[8] = 4;
        t[9] = 4;
        t[10] = 5;
        t[11] = 5;
        t[12] = 6;
        for (int i = 1; i < t.length; i++) {
            assertEquals(t[i], h.parent(i));
        }
    }

    /**
     * Test of left method, of class MinHeap.
     */
    @Test
    public void testLeft() {
        int[] t = new int[7];
        t[1] = 2;
        t[2] = 4;
        t[3] = 6;
        t[4] = 8;
        t[5] = 10;
        t[6] = 12;
        for (int i = 1; i < t.length; i++) {
            assertEquals(t[i], h.left(i));
        }
    }

    /**
     * Test of right method, of class MinHeap.
     */
    @Test
    public void testRight() {
        int[] t = new int[7];
        t[1] = 3;
        t[2] = 5;
        t[3] = 7;
        t[4] = 9;
        t[5] = 11;
        t[6] = 13;
        for (int i = 1; i < t.length; i++) {
            assertEquals(t[i], h.right(i));
        }
    }
    
    
    private void testHeapCondition(MinHeap heap){
        //System.out.println("test heap condition");
        for (int i = 1; i < heap.getLength(); i++) {
            if(heap.left(i) <= heap.getLength()){
                System.out.println(heap.getArray()[i].node().getKey() + " vs " + heap.getArray()[heap.left(i)].node().getKey());
                assertTrue(heap.getArray()[i].node().getKey() <= heap.getArray()[heap.left(i)].node().getKey());
            }
            if(heap.right(i) <= heap.getLength()){
                System.out.println(heap.getArray()[i].node().getKey() + " vs " + heap.getArray()[heap.right(i)].node().getKey());
                assertTrue(heap.getArray()[i].node().getKey() <= heap.getArray()[heap.right(i)].node().getKey());
            }
        }
    }

    /**
     * Test of insert method, of class MinHeap.
     */
    @Test
    public void testInsert() {
        Vertex v = new Vertex();
        int l = h2.getLength() + 1;
        //System.out.println("length before: " + h2.getLength());
        v.setKey(0);
        h2.insert(new HeapNode(v));
        System.out.println("test insert:");
        testHeapCondition(h2);
        assertEquals(l, h2.getLength());
    }

    /**
     * Test of decreaseKey method, of class MinHeap.
     */
    @Test
    public void testDecreaseKey() {
        h.decreaseKey(5, 0);
        System.out.println("test Decrease Key:");
        testHeapCondition(h);
    }

    /**
     * Test of deleteMin method, of class MinHeap.
     */
    @Test
    public void testDeleteMin() {
        int l = h.getLength() - 1;
        h.deleteMin();
        System.out.println("test delete min:");
        testHeapCondition(h);
        assertEquals(l, h.getLength());
    }
    
}
