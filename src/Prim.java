import java.util.*;

public class Prim {

    public static class Result {
        public final List<Edge> mstEdges;
        public final long totalWeight;
        public final long opCount;
        public final long timeMs;

        public Result(List<Edge> mstEdges, long totalWeight, long opCount, long timeMs) {
            this.mstEdges = mstEdges;
            this.totalWeight = totalWeight;
            this.opCount = opCount;
            this.timeMs = timeMs;
        }
    }

    public static Result run(Graph g) {
        long start = System.currentTimeMillis();
        List<Edge> mst = new ArrayList<>();
        long total = 0;
        long ops = 0;

        if (g.vertices.isEmpty()) return new Result(mst, total, ops, 0);

        Map<String, List<Edge>> adj = new HashMap<>();
        for (String v : g.vertices) adj.put(v, new ArrayList<>());
        for (Edge e : g.edges) {
            adj.get(e.source).add(e);
            adj.get(e.destination).add(new Edge(e.destination, e.source, e.weight));
        }

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        String startVertex = g.vertices.get(0);
        visited.add(startVertex);
        pq.addAll(adj.get(startVertex));

        while (!pq.isEmpty() && visited.size() < g.vertices.size()) {
            Edge e = pq.poll();
            ops++;
            if (visited.contains(e.destination)) continue;
            visited.add(e.destination);
            mst.add(e);
            total += e.weight;
            pq.addAll(adj.get(e.destination));
        }

        long end = System.currentTimeMillis();
        return new Result(mst, total, ops, end - start);
    }
}
