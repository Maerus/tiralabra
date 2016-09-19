
package algorithm;

import data.MinHeap;
import util.TileType;
import data.graph.Vertex;


public class Dijkstra {
    private Vertex start;
    private Vertex[][] graph;

    /**
     * Constructs a new solver class to run Dijkstra's algorithm on a graph
     * 
     * @param graph 
     */
    public Dijkstra(Vertex[][] graph) {
        this.graph = graph;
        start = seekStart();
    }
    
    /**
     * finds the starting vertex from the graph
     * 
     * @return the starting vertex
     */
    private Vertex seekStart() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j].getTileType().equals(TileType.START)){
                    return graph[i][j];
                }
            }
        }
        System.out.println("Graph did not have a start!");
        System.exit(0);
        return null;
    }
    
    /**
     * Executes the algorithms (once they're done) and prints how long it took in milliseconds
     */
    public void solve(){
        long timestamp = System.currentTimeMillis();
        
        //algorithmNoHeap();
        
        System.out.println("Dijkstra: Execution took " + (System.currentTimeMillis()-timestamp) + " ms");
    }
    
    /*
    private void algorithmNoHeap(){
        
    }
    */
    
    
    /**
     * Runs the algorithm using a minimum heap
     * will remain UNUSABLE and UNFINISHED until minimum heap structure is finished
    private void algorithm(){
        
        start.setDistance(0);
        
        MinHeap<Vertex> heap;
        
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(!graph[i][j].getTileType().equals(TileType.START)){
                    graph[i][j].setDistance(Double.POSITIVE_INFINITY);
                }
            }
        }
        
    }
    */
}
