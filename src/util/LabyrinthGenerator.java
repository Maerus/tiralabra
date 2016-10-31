package util;

import data.graph.Edge;
import data.graph.Vertex;

/**
 * This class will create a labyrinth graph for the algorithms to use
 */
public class LabyrinthGenerator {

    /**
     * Creates a graph using an array of strings
     *
     * @param stringArray array of strings that make up a labyrinth
     * @return graph of the labyrinth
     */
    public static Vertex[][] graphFromStringArray(String[] stringArray) {
        boolean containsStart = false;
        boolean containsGoal = false;
        Vertex[][] graph = new Vertex[stringArray.length][stringArray[0].length()];
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length(); j++) {
                Vertex n = new Vertex();
                assignTileType(n, stringArray[i].charAt(j));
                n.setX(j);
                n.setY(i);
                graph[i][j] = n;
                if (!containsStart && graph[i][j].getTileType().equals(TileType.START)) {
                    containsStart = true;
                } else if (graph[i][j].getTileType().equals(TileType.START)) {
                    //multiple starts, end program
                    FileIO.println("\nLabyrinth had multiple starts (s)!");
                    System.exit(0);
                }

                if (!containsGoal && graph[i][j].getTileType().equals(TileType.GOAL)) {
                    containsGoal = true;
                } else if (graph[i][j].getTileType().equals(TileType.GOAL)) {
                    //multiple goals, end program
                    FileIO.println("\nLabyrinth had multiple goals (g)!");
                    System.exit(0);
                }

                //FileIO.print("[(" + n.getX() + "," + n.getY() + "): " + n.getTileType().toString().charAt(0) + "] ");
                linkNodes(i, j, graph, n);
            }
            //FileIO.println("");
        }

        if (!containsGoal || !containsStart) {
            FileIO.println("\nLabyrinth did not have either a start (s) or a goal (g)");
            System.exit(0);
        }

        /*
         for (int i = 0; i < graph.length; i++) {
         for (int j = 0; j < graph[0].length; j++) {
         FileIO.println("");
         for (int k = 0; k < graph[i][j].getLinks().length; k++) {
         if(graph[i][j].getLinks()[k] != null){
         Vertex v = graph[i][j];
         FileIO.print(v.getX() + "," + v.getY() + ": ");
         Edge e = graph[i][j].getLinks()[k];
                        
         FileIO.print("["+e.getLinkedVertex(v).getX() + "," + e.getLinkedVertex(v).getY()+"]" +"   ");
         }
         }
         }
         }
         */
        return graph;
    }

    /**
     * Assigns a tile type to a vertex
     *
     * @param n vertex to assign a tile type
     * @param c character in a string that determines the tile type
     */
    private static void assignTileType(Vertex n, char c) {
        switch (c) {
            case '.':
                n.setTile(TileType.FLOOR);
                return;
            case 's':
                n.setTile(TileType.START);
                return;
            case 'g':
                n.setTile(TileType.GOAL);
                return;
            default:
                n.setTile(TileType.WALL);
        }
    }

    /**
     * links the created node with the node to its left (if exists) and with the
     * nodes above (if any) using an edge and stores it to both vertices.
     *
     * Linking behind the most recent node will avoid duplicate edges
     *
     * @param i the row of the graph where the vertex is
     * @param j the column of the graph where the vertex is
     * @param graph the labyrinth graph
     * @param n the most recently created vertex
     */
    private static void linkNodes(int i, int j, Vertex[][] graph, Vertex n) {
        Vertex t;
        Edge e;

        //link to nodes above if not on top row
        if (i > 0) {

            //link with top-left if not leftmost node
            if (j > 0) {
                t = graph[i - 1][j - 1];
                e = new Edge(n, t);

                n.addLink(e);
                t.addLink(e);
            }

            //link with top
            t = graph[i - 1][j];
            e = new Edge(n, t);
            n.addLink(e);
            t.addLink(e);

            //link with top-right if not rightmost node
            if (j < graph[0].length - 1) {
                t = graph[i - 1][j + 1];
                e = new Edge(n, t);
                n.addLink(e);
                t.addLink(e);
            }
        }

        //link with node to the left if not leftmost node
        if (j > 0) {
            t = graph[i][j - 1];
            e = new Edge(n, t);
            n.addLink(e);
            t.addLink(e);
        }
    }

}
