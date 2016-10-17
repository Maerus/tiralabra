package algorithm;

import data.HeapNode;
import data.MinHeap;
import data.graph.Edge;
import data.graph.Vertex;
import util.FileIO;
import util.MinMath;
import util.TileType;

/**
 * The A* algorithm uses a heuristic to point itself towards the goal. This will
 * not run through the entire graph unless something went wrong.
 */
public class AStar {

    /**
     * The A* algorithm
     * 
     * NOT COMPLETED YET
     * 
     * @param start the starting vertex
     * @param goal the goal vertex
     * @param graph the labyrinth graph
     */
    public static void algorithm(Vertex start, Vertex goal, Vertex[][] graph) {
        int vLength = graph.length * graph[0].length;
        MinHeap heap = new MinHeap(vLength);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j].setDistance2(graph[i][j].getTileType().equals(TileType.START) ? 0 : 2000000);
                graph[i][j].setDistance(graph[i][j].getTileType().equals(TileType.START) ? heuristic(graph[i][j], goal) : 2000000);
                graph[i][j].setPrev(null);
                graph[i][j].setEvaluated(false);
            }
        }
        //heapnode takes in a keySortable and the vertex uses its distance as its key, here we want its heuristic value
        heap.insert(new HeapNode(start));

        while (heap.getLength() > 0) {
            Vertex u = (Vertex) heap.deleteMin().node();
            if (u.getTileType().equals(TileType.GOAL)) {
                return;
            }
            u.setEvaluated(true);
            // should equal adding to a 'closed set' since its only purpose is
            // to check if the node is already evaluated
            for (int i = 0; i < u.getEdges().length; i++) {
                if (u.getEdges()[i] != null) {
                    Vertex neighbor = u.getEdges()[i].getLinkedVertex(u);
                    if (neighbor.isEvaluated()) {
                        continue;
                    }
                    Edge e = u.getEdges()[i];
                    int alt = u.getDistance2() + e.getWeight();
                    if (!neighbor.isInHeap()) {
                        heap.insert(new HeapNode(neighbor));
                    } else if (alt >= neighbor.getDistance2()) {
                        continue;
                    }

                    neighbor.setPrev(u);
                    neighbor.setDistance2(alt);
                    neighbor.setDistance(alt + heuristic(neighbor, goal));
                }
            }
        }

        FileIO.println("A* did not find the goal!");
    }

    /**
     * Chebyshev distance
     *
     * http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html
     *
     * @return heuristic distance
     */
    private static int heuristic(Vertex v, Vertex goal) {
        int dx = MinMath.intAbs(v.getX() - goal.getX());
        int dy = MinMath.intAbs(v.getY() - goal.getY());
        int D = 1;
        int D2 = 1;
        return D * (dx + dy) + (D2 - 2 * D) * MinMath.intMin(dx, dy);
    }
}
