import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal {

    public static class Result {
        public final List<Edge> mstEdges;
        public final long totalWeight;
        public final long cmpCount;
        public final long dsuOps;
        public final long timeMs;

        public Result(List<Edge> mstEdges, long totalWeight, long cmpCount, long dsuOps, long timeMs) {
            this.mstEdges = mstEdges;
            this.totalWeight = totalWeight;
            this.cmpCount = cmpCount;
            this.dsuOps = dsuOps;
            this.timeMs = timeMs;
        }
    }

    private static class DSU {
        private final int[] parent;
        private final int[] rank;
        long ops; 

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            ops = 0;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            ops++; 
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) {
                ops++;
                return false;
            }
            ops++;
            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[rb] < rank[ra]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
            return true;
        }
    }

    public static Result run(Graph g) {
        long start = System.currentTimeMillis();

        
        Map<String, Integer> indexMap = new HashMap<>();
        int idx = 0;
        for (String v : g.vertices) {
            indexMap.put(v, idx++);
        }
        int n = indexMap.size();

        
        List<Edge> edges = new ArrayList<>(g.edges);
        Collections.sort(edges); 

        long cmpCount = 0;
        DSU dsu = new DSU(n);
        List<Edge> mst = new ArrayList<>();
        long total = 0;

        for (Edge e : edges) {
            if (mst.size() == n - 1) break;
            Integer uIdx = indexMap.get(e.source);
            Integer vIdx = indexMap.get(e.destination);
            if (uIdx == null || vIdx == null) continue;

            
            cmpCount++;
            int ru = dsu.find(uIdx);
            int rv = dsu.find(vIdx);

            if (ru != rv) {
                boolean merged = dsu.union(ru, rv);
                if (merged) {
                    mst.add(e);
                    total += e.weight;
                }
            }
        }

        long end = System.currentTimeMillis();
        long timeMs = end - start;
        long dsuOps = dsu.ops;

        return new Result(mst, total, cmpCount, dsuOps, timeMs);
    }
}


