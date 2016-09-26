
package algorithm;

import data.HeapNode;
import data.MinHeap;
import util.TileType;
import data.graph.Vertex;
import util.FileIO;


public class Dijkstra {
    private Vertex start;
    private Vertex goal;
    private Vertex[][] graph;

    /**
     * Constructs a new solver class to run Dijkstra's algorithm on a graph
     * 
     * @param graph 
     */
    public Dijkstra(Vertex[][] graph) {
        this.graph = graph;
        seekStart();
    }
    
    /**
     * finds the starting vertex from the graph
     * 
     * @return the starting vertex
     */
    private void seekStart() {
        boolean startFound = false;
        boolean goalFound = false;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j].getTileType().equals(TileType.START)){
                    start = graph[i][j];
                    startFound = true;
                }
                if(graph[i][j].getTileType().equals(TileType.GOAL)){
                    goal = graph[i][j];
                    goalFound = true;
                }
                if(startFound && goalFound){
                    break;
                }
            }
        }
    }
    
    /**
     * Executes the algorithms (once they're done) and prints how long it took in milliseconds
     */
    public void solve(){
        long timestamp = System.currentTimeMillis();
        FileIO.println("\nStarting Dijkstra's algorithm");
        algorithm();
        Vertex v = goal;
        
        FileIO.println("\nPATH (in reverse): ");
        while(v.getPrev() != null){
            FileIO.println(v.toString());
            v = v.getPrev();
        }
        FileIO.println(v+"\n");
        FileIO.println("Dijkstra: Execution took " + (System.currentTimeMillis()-timestamp) + " ms");
    }
    
    
    /**
     * Runs the algorithm using a minimum heap
    */
    private void algorithm(){
        
        start.setDistance(0);
        
        MinHeap heap = new MinHeap(graph.length*graph[0].length);
        
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(!graph[i][j].getTileType().equals(TileType.START)){
                    graph[i][j].setDistance(100000);
                    graph[i][j].setPrev(null);
                }
                heap.insert(new HeapNode(graph[i][j]));
            }
        }
        
        while (heap.getLength() > 1){
            Vertex u = (Vertex)heap.deleteMin().node();
            for (int i = 0; i < u.getLinks().length; i++) {
                if(u.getLinks()[i] != null){
                    int alt = u.getDistance() + u.getLinks()[i].getWeight();
                    Vertex v = u.getLinks()[i].getLinkedVertex(u);
                    if (alt < v.getDistance()){
                        heap.decreaseKey(v.getIndex(), alt);
                        v.setPrev(u);
                    }
                }
            }
        }
    }
}
