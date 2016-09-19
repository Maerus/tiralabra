package data.graph;

import util.TileType;

/**
 * A vertex in a graph
 * 
 * when the ASCII labyrinth is turned into a graph,
 * its tiles are put into vertices.
 * A vertex can have at most 8 edges linking to other tiles
 * as there are at most 8 adjacent tiles to a single tile in the labyrinth.
 * 
 */
public class Vertex {
    private Edge[] links;
    private TileType tile;
    private int x, y;
    private double distance;
    private Vertex prev;

    /**
     * Constructs an new vertex.
     */
    public Vertex() {
        links = new Edge[8];
        tile = null;
    }
    
    /**
     * Adds an edge to the links array.
     * 
     * The edge contains a reference to this vertex and another that is
     * adjacent to the labyrinth tile. It also has a weight variable to
     * determine 'distances' between vertices, although it only increases if
     * either vertex is a wall tile.
     * 
     * @param e an edge to add to the links array
     */
    public void addLink(Edge e){
        for (int i = 0; i < 8; i++) {
            if(links[i] == null){
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

    public Edge[] getLinks() {
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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
    
    
}
