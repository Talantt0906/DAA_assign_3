import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.json";
        String outputFile = "output.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GraphData graphData;

        
        try {
            String json = new String(Files.readAllBytes(Paths.get(inputFile)));
            graphData = gson.fromJson(json, GraphData.class);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + inputFile);
            e.printStackTrace();
            return;
        }

        List<GraphResult> results = new ArrayList<>();

        for (GraphData.GraphInfo info : graphData.graphs) {
            
            Graph g = new Graph();
            for (String v : info.vertices) g.addVertex(v);
            for (GraphData.EdgeInfo e : info.edges) g.addEdge(e.source, e.destination, e.weight);

            
            Prim.Result primResult = Prim.run(g);

            
            Kruskal.Result kruskalResult = Kruskal.run(g);

            
            GraphResult res = new GraphResult();
            res.name = info.name;
            res.verticesCount = g.getVertexCount();
            res.edgesCount = g.getEdgeCount();
            res.primMSTEdges = primResult.mstEdges;
            res.primTotalWeight = primResult.totalWeight;
            res.primOps = res.primOps + primResult.opCount;
            res.primTimeMs = primResult.timeMs;
            res.kruskalMSTEdges = kruskalResult.mstEdges;
            res.kruskalTotalWeight = kruskalResult.totalWeight;
            res.kruskalOps = kruskalResult.cmpCount + kruskalResult.dsuOps;
            res.kruskalTimeMs = kruskalResult.timeMs;

            results.add(res);

            
            System.out.println("Graph: " + info.name);
            System.out.println("Prim total weight: " + primResult.totalWeight);
            System.out.println("Kruskal total weight: " + kruskalResult.totalWeight);
            System.out.println();
        }

        // 输出到 output.json
        try (FileWriter writer = new FileWriter(outputFile)) {
            gson.toJson(results, writer);
            System.out.println("Results saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + outputFile);
            e.printStackTrace();
        }
    }

    
    public static class GraphResult {
        String name;
        int verticesCount;
        int edgesCount;
        List<Edge> primMSTEdges;
        long primTotalWeight;
        long primOps;
        long primTimeMs;
        List<Edge> kruskalMSTEdges;
        long kruskalTotalWeight;
        long kruskalOps;
        long kruskalTimeMs;
    }
}

