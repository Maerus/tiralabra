package data.graph;

import util.TileType;


/**
 * Edge is the link between two vertices in a graph that has a weight
 * 
 */
public class Edge{
    private Vertex vertex1, vertex2;
    private int weight;

    /**
     * Constructs a new edge between two nodes and
     * assigns a weight depending on if either vertex is a wall tile
     * 
     * A high weight is assigned to an edge linking to a wall in order to make
     * it possible to walk on the wall tiles in an emergency, such as if there
     * is no proper path from start to goal.
     * 
     * (values will be altered later)
     * 
     * @param v1 A vertex to link with v2
     * @param v2 A vertex to link with v1
     */
    public Edge(Vertex v1, Vertex v2) {
        this.vertex1 = v1;
        this.vertex2 = v2;
        if(v1.getTileType() != null && v2.getTileType() != null){
            weight = v1.getTileType().equals(TileType.WALL) ||
                v2.getTileType().equals(TileType.WALL)
                ? 10000 : 1;
        } else if (v1.getTileType() != null){
            weight = v1.getTileType().equals(TileType.WALL) ? 10000 : 1;
        } else if (v2.getTileType() != null){
            weight = v2.getTileType().equals(TileType.WALL) ? 10000 : 1;
        } else {
            weight = 10000;
        }
        
    }
    
    /**
     * Returns the vertex linked to the parameter in this edge
     * 
     * @param current   a vertex looking for its pair
     * @return  the vertex linked to the parameter in this edge
     */
    public Vertex getLinkedVertex(Vertex current){
        //test: will return the linked node
        if(vertex1.equals(current)){
            return vertex2;
        }
        return vertex1;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }
}


