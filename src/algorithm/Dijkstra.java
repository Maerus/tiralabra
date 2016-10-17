package algorithm;

import data.HeapNode;
import data.MinHeap;
import data.graph.Vertex;
import util.TileType;

/**
 * Dijkstra's algorithm can be used to find the shortest path to a single known
 * destination or it can be run over the entire graph, allowing selecting the
 * destination after execution
 */
public class Dijkstra {

    /**
     * Runs the Dijkstra's algorithm using a minimum heap
     *
     * @param start The starting point
     * @param graph the labyrinth graph
     * @param stopAtGoal boolean to determine whether to stop the algorithm at
     * goal or let it run over the entire graph
     */
    public static void algorithm(Vertex start, Vertex[][] graph, boolean stopAtGoal) {

        MinHeap heap = new MinHeap(graph.length * graph[0].length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j].setDistance(graph[i][j].getTileType().equals(TileType.START) ? 0 : 1000000);
                graph[i][j].setPrev(null);
                heap.insert(new HeapNode(graph[i][j]));
            }
        }

        while (heap.getLength() > 1) {
            Vertex u = (Vertex) heap.deleteMin().node();
            //if not running through the entire graph, finding goal will stop execution
            if (u.getTileType().equals(TileType.GOAL) && stopAtGoal) {
                return;
            }
            for (int i = 0; i < u.getEdges().length; i++) {
                if (u.getEdges()[i] != null) {
                    int alt = u.getDistance() + u.getEdges()[i].getWeight();
                    Vertex v = u.getEdges()[i].getLinkedVertex(u);
                    if (alt < v.getDistance()) {
                        heap.decreaseKey(v.getIndex(), alt);
                        v.setPrev(u);
                    }
                }
            }
        }
    }
}
