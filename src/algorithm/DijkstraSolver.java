
package algorithm;

import data.HeapNode;
import data.MinHeap;
import util.TileType;
import data.graph.Vertex;
import util.FileIO;

/**
 * This class will solve the shortest path in the graph using Dijkstra's algorithm
 */
public class DijkstraSolver {
    private Vertex start;
    private Vertex goal;
    private Vertex[][] graph;
    private Vertex[] pathArray;

    /**
     * Constructs a new solver class to run Dijkstra's algorithm on a graph
     * 
     * @param graph 
     */
    public DijkstraSolver(Vertex[][] graph) {
        this.graph = graph;
        seekStartAndGoal();
    }
    
    /**
     * grabs the start and the goal from the graph for later use.
     * 
     * @return the starting vertex
     */
    private void seekStartAndGoal() {
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
     * Executes the algorithm and prints how long it took in milliseconds
     */
    public void solve(){
        long timestamp = System.currentTimeMillis();
        
        FileIO.println("\nStarting Dijkstra's algorithm");
        algorithm();
        FileIO.println("Dijkstra's algorithm done: Execution took " + (System.currentTimeMillis()-timestamp) + " ms");
        
        pathArray = getPath();
        
        //print all tiles in the shortest path
        FileIO.println("\nTiles in the shortest path: ");
        for (int j = 0; j < pathArray.length; j++) {
            FileIO.println(pathArray[j].toString());
        }
        FileIO.println("Dijkstra out!");
    }
    
    /**
     * Returns an array, which contains all of the tiles, that get stepped on
     * when navigating the shortest path.
     * 
     * @return the array which contains all tiles in the shortest path that are walked on from start to goal
     */
    private Vertex[] getPath(){
        Vertex v = goal;
        int size = 1;
        while(v.getPrev() != null){
            size++;
            v = v.getPrev();
        }
        Vertex[] array = new Vertex[size];
        v = goal;
        size--;
        array[size] = v;
        while(v.getPrev() != null){
            size--;
            v = v.getPrev();
            array[size] = v;
        }
        return array;
    }
    
    
    /**
     * Runs the Dijkstra's algorithm using a minimum heap
    */
    private void algorithm(){
        
        start.setDistance(0);
        
        MinHeap heap = new MinHeap(graph.length*graph[0].length);
        
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(!graph[i][j].getTileType().equals(TileType.START)){
                    graph[i][j].setDistance(1000000);
                }
                graph[i][j].setPrev(null);
                heap.insert(new HeapNode(graph[i][j]));
            }
        }
        
        while (heap.getLength() > 1){
            Vertex u = (Vertex)heap.deleteMin().node();
            if(u.getTileType().equals(TileType.GOAL)){
                //FileIO.println("Heap size after finding goal: " + heap.getLength());
                return;
            }
            for (int i = 0; i < u.getEdges().length; i++) {
                if(u.getEdges()[i] != null){
                    int alt = u.getDistance() + u.getEdges()[i].getWeight();
                    Vertex v = u.getEdges()[i].getLinkedVertex(u);
                    if (alt < v.getDistance()){
                        heap.decreaseKey(v.getIndex(), alt);
                        v.setPrev(u);
                    }
                }
            }
        }
    }

    public Vertex[] getPathArray() {
        return pathArray;
    }

    public Vertex getGoal() {
        return goal;
    }
    
    
}
