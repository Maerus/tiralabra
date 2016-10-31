package algorithm;

import data.graph.Edge;
import data.graph.Vertex;

/**
 * Bellman-Ford is an algorithm that runs through the entire graph. Since there
 * is no support for negative edges, checking for negative-weight cycles is not
 * done
 */
public class BellmanFord {

    /**
     * Runs Bellman-Ford algorithm over the entire graph
     *
     * @param start vertex
     * @param vertices the array of vertices in the graph
     * @param edges the array of edges in the graph
     */
    public static void algorithm(Vertex start, Vertex[] vertices, Edge[] edges) {
        //Initialize graph
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].setDistance(1000000);
            vertices[i].setPrev(null);
        }
        start.setDistance(0);

        //Relax edges repeatedly
        for (int i = 0; i < vertices.length - 2; i++) {
            for (int j = 0; j < edges.length; j++) {
                Vertex u = edges[j].getVertex1();
                Vertex v = edges[j].getVertex2();
                if (u.getDistance() + edges[j].getWeight() < v.getDistance()) {
                    v.setDistance(u.getDistance() + edges[j].getWeight());
                    v.setPrev(u);
                } else if (v.getDistance() + edges[j].getWeight() < u.getDistance()) {
                    u.setDistance(v.getDistance() + edges[j].getWeight());
                    u.setPrev(v);
                }
            }
        }

        //checking for negative-weight cycles would come here if negative weights were supported
    }
}
