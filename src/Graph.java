import java.util.*;

public class Graph {
    List<String> vertices;
    List<Edge> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(String vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    public void addEdge(String source, String destination, int weight) {
        edges.add(new Edge(source, destination, weight));
        addVertex(source);
        addVertex(destination);
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int getEdgeCount() {
        return edges.size();
    }
}
