package algorithm;

import data.graph.Edge;
import util.TileType;
import data.graph.Vertex;
import util.FileIO;

/**
 * This class will solve the shortest path in the graph using Dijkstra's
 * algorithm
 */
public class Solver {

    private Vertex start;
    private Vertex goal;
    private Vertex[][] graph;
    private Vertex[] pathArray;
    private Vertex[] vertices;
    private Edge[] edges;
    private int testingAmount;
    private boolean printPath;

    /**
     * Constructs a new solver class to run Dijkstra's algorithm on a graph
     *
     * @param graph the graph from the labyrinthGenerator
     * @param testAmount how many times algorithms are repeated. Timing starts
     * at the beginning of the first run and stops after the last. Higher number
     * will increase the timing difference between algorithms.
     * @param printPath true will print the path found by the algorithm.
     */
    public Solver(Vertex[][] graph, int testAmount, boolean printPath) {
        this.graph = graph;
        this.testingAmount = testAmount;
        this.printPath = printPath;
        seekStartAndGoal();
        arrayifyGraph();
    }

    /**
     * Fills the 'vertices' and 'edges' arrays using the graph
     */
    private void arrayifyGraph() {
        vertices = new Vertex[graph.length * graph[0].length];
        //edgesTemp will contain nulls, real edges array will be made after
        Edge[] edgesTemp = new Edge[vertices.length * 8];
        int vertIndex = 0;
        int edgeIndex = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                vertices[vertIndex] = graph[i][j];
                vertIndex++;
                for (int k = 0; k < graph[i][j].getEdges().length; k++) {
                    if (graph[i][j].getEdges()[k] != null) {
                        edgesTemp[edgeIndex] = graph[i][j].getEdges()[k];
                        edgeIndex++;
                    }
                }
            }
        }

        //make an array for edges that won't contain any nulls
        edges = new Edge[edgeIndex];
        for (int i = 0; i < edgeIndex; i++) {
            edges[i] = edgesTemp[i];
        }

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
                if (graph[i][j].getTileType().equals(TileType.START)) {
                    start = graph[i][j];
                    startFound = true;
                }
                if (graph[i][j].getTileType().equals(TileType.GOAL)) {
                    goal = graph[i][j];
                    goalFound = true;
                }
                if (startFound && goalFound) {
                    break;
                }
            }
        }
    }

    /**
     * Executes the pathfinding algorithms and prints how long they took in
     * milliseconds
     */
    public void solve() {
        solveWithAStar();
        solveWithDijkstra(true);
        solveWithDijkstra(false);
        solveWithBellmanFord();
    }

    /**
     * Prints the path found by the algorithm if enabled
     *
     * @param astar Set to true if running with A* to print clarification to
     * vertex distance. Otherwise set to false.
     */
    private void printPath(boolean astar) {
        if (!printPath) {
            return;
        }
        pathArray = getPath();
        FileIO.println("\nTiles in the shortest path: ");
        for (int j = 0; j < pathArray.length; j++) {
            if (astar) {
                FileIO.println(pathArray[j].toString() + "  (distance + heuristic)");
            } else {
                FileIO.println(pathArray[j].toString());
            }
        }
    }

    /**
     * Runs the Dijkstra's algorithm set amount of times, logs its execution
     * time and prints the path if set so.
     *
     * @param stopAtGoal Set to true if stopping execution when finding the goal
     * vertex. False will run through entire graph
     */
    public void solveWithDijkstra(boolean stopAtGoal) {
        long timestamp = System.currentTimeMillis();
        String goalString = stopAtGoal ? "stopping at goal. " : "running through the entire graph. ";
        FileIO.println("\nStarting Dijkstra's algorithm " + goalString + "Running " + testingAmount + " times");

        for (int i = 0; i < testingAmount; i++) {
            Dijkstra.algorithm(start, graph, stopAtGoal);
        }
        FileIO.println("Dijkstra's algorithm done: Execution took " + (System.currentTimeMillis() - timestamp) + " ms");
        printPath(false);
        FileIO.println("Dijkstra out!");
    }

    /**
     * Runs the A* algorithm using Chebyshev distance as its heuristic, logs the
     * execution time and prints the path found by the algorithm if set so.
     */
    public void solveWithAStar() {
        long timestamp = System.currentTimeMillis();
        FileIO.println("\nStarting A* algorithm. " + "Running " + testingAmount + " times");
        for (int i = 0; i < testingAmount; i++) {
            AStar.algorithm(start, goal, graph);
        }
        FileIO.println("A* algorithm done: Execution took " + (System.currentTimeMillis() - timestamp) + " ms");
        printPath(true);
        FileIO.println("A* out!");
    }

    /**
     * Runs the Bellman-Ford algorithm, logs its execution time and prints the
     * path if set so.
     */
    public void solveWithBellmanFord() {
        long timestamp = System.currentTimeMillis();
        FileIO.println("\nStarting Bellman-Ford's algorithm. " + "Running " + testingAmount + " times");
        for (int i = 0; i < testingAmount; i++) {
            BellmanFord.algorithm(start, vertices, edges);
        }
        FileIO.println("Bellman-Ford algorithm done: Execution took " + (System.currentTimeMillis() - timestamp) + " ms");
        printPath(false);
        FileIO.println("Bellman-Ford out!");
    }

    /**
     * Returns an array, which contains all of the tiles, that get stepped on
     * when navigating the shortest path.
     *
     * @return the array which contains all tiles in the shortest path that are
     * walked on from start to goal
     */
    public Vertex[] getPath() {
        Vertex v = goal;
        int size = 1;
        while (v.getPrev() != null) {
            size++;
            v = v.getPrev();
        }
        Vertex[] array = new Vertex[size];
        v = goal;
        size--;
        array[size] = v;
        while (v.getPrev() != null) {
            size--;
            v = v.getPrev();
            array[size] = v;
        }
        return array;
    }

    public Vertex[] getPathArray() {
        return pathArray;
    }

    public Vertex getGoal() {
        return goal;
    }

}
