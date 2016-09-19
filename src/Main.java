
import algorithm.Dijkstra;
import util.LabyrinthGenerator;
import data.graph.Vertex;





public class Main {


    public static void main(String[] args) {
        
        String[] stringArray = new String[4];
        stringArray[0] = "##..s";
        stringArray[1] = ".#.#.";
        stringArray[2] = "...##";
        stringArray[3] = ".#..g";
        
        Vertex[][] graph = LabyrinthGenerator.graphFromStringArray(stringArray);
        
        printNeighbors(graph);
        //Dijkstra d = new Dijkstra(graph);
        //d.solve();
        
    }
    
    /**
     * (early debugging) 
     * This function is here just to print the edge information of all tiles
     * in the dungeon to see that the graph is gerenated correctly.
     * 
     * @param graph 
     */
    private static void printNeighbors(Vertex[][] graph){
        System.out.println("");
        System.out.println("neighbors to nodes in order:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print( "(" + graph[i][j].getX() + "." + graph[i][j].getY() + ")" + graph[i][j].getTileType() + " neighbors:\t" );
                for (int k = 0; k < graph[i][j].getLinks().length; k++) {
                    if(graph[i][j].getLinks()[k] != null){
                        System.out.print("(" + 
                                graph[i][j].getLinks()[k].getLinkedVertex(graph[i][j]).getX() + "," + 
                                graph[i][j].getLinks()[k].getLinkedVertex(graph[i][j]).getY() + "):" + 
                                graph[i][j].getLinks()[k].getLinkedVertex(graph[i][j]).getTileType().toString().charAt(0) + " " + 
                                graph[i][j].getLinks()[k].getWeight() + " ");
                    }
                    else {
                        System.out.print(" _____________ ");
                    }
                }
            System.out.println("");
            }
        System.out.println("");
        }
    }
    
}
