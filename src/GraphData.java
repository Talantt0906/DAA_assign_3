import java.util.List;

public class GraphData {
    public List<GraphInfo> graphs;

    public static class GraphInfo {
        public String name;
        public List<String> vertices;
        public List<EdgeInfo> edges;
    }

    public static class EdgeInfo {
        public String source;
        public String destination;
        public int weight;
    }
}

