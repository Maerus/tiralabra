package data.graph;

import data.KeySortable;
import util.TileType;

/**
 * A vertex in a graph
 *
 * when the ASCII labyrinth is turned into a graph, its tiles are put into
 * vertices. A vertex can have at most 8 edges linking to other tiles as there
 * are at most 8 adjacent tiles to a single tile in the labyrinth.
 *
 */
public class Vertex implements KeySortable {

    private Edge[] links;
    private TileType tile;
    private int x, y;
    /**
     * distance is used as the key value in heap node.
     * Dijkstra stores regular distance here and
     * A* stores heuristic value for use in heap
     */
    private int distance;
    /**
     * second distance is used in A* for storing the regular distance. 
     */
    private int distance2;
    private Vertex prev;
    private int index;
    private boolean evaluated;
    private boolean inHeap;

    /**
     * Constructs an new vertex.
     */
    public Vertex() {
        links = new Edge[8];
        tile = null;
        evaluated = false;
        inHeap = false;
    }

    /**
     * Adds an edge to the links array.
     *
     * The edge contains a reference to this vertex and another that is adjacent
     * to the labyrinth tile. It also has a weight variable to determine
     * 'distances' between vertices, although it only increases if either vertex
     * is a wall tile.
     *
     * @param e an edge to add to the links array
     */
    public void addLink(Edge e) {
        for (int i = 0; i < 8; i++) {
            if (links[i] == null) {
                links[i] = e;
                break;
            }
        }
    }

    public TileType getTileType() {
        return tile;
    }

    public void setTile(TileType tile) {
        this.tile = tile;
    }

    public Edge[] getEdges() {
        return links;
    }

    public Vertex getPrev() {
        return prev;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * actual distance in Dijkstra and Bellman-Ford.
     * 
     * @return distance, actual value in Dijkstra or Bellman-Ford, heuristic cost estimate in A*
     */
    public int getDistance() {
        return distance;
    }

    public void setDistance2(int distance2) {
        this.distance2 = distance2;
    }
    
    /**
     * actual distance in A*
     * @return distance
     */
    public int getDistance2() {
        return distance2;
    }

    @Override
    public int getKey() {
        return distance;
    }

    @Override
    public void setKey(int d) {
        this.distance = d;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        String string = "[" + x + "," + y + "]" + " type: " + tile + ", distance: " + distance;
        return string;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    @Override
    public void setInHeap(boolean inHeap) {
        this.inHeap = inHeap;
    }
    
    @Override
    public boolean isInHeap() {
        return inHeap;
    }
    
}
