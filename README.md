🚦 City Transportation Network Optimization (Assignment 3)
📌 Overview

This project implements Prim’s and Kruskal’s algorithms to find the Minimum Spanning Tree (MST) of a city transportation network.
The goal is to determine the minimum set of roads that connect all city districts with the lowest possible construction cost.

The city network is modeled as a weighted undirected graph:

Vertices: city districts

Edges: potential roads

Weights: construction costs

🗂 Project Structure

src/ – Java source code

Main.java

Prim.java

Kruskal.java

Graph.java (optional, for bonus)

Edge.java (optional, for bonus)

input/ – Input JSON files

SmallGraph.json

MediumGraph.json

LargeGraph.json

output/ – Output JSON files

output.json

tests/ – Unit tests

MSTTest.java

report/ – Analytical report

report.pdf

⚙ How to Run

Open the project in VS Code or any Java IDE.

Ensure the Gson library is included in the classpath.

Compile the code, including Gson.

Run Main.java.

Check the output folder for MST results in output.json.

✨ Features

Implements Prim’s and Kruskal’s algorithms for MST.

Records for each algorithm:

MST edges and total weight

Number of operations (comparisons, unions, etc.)

Execution time in milliseconds

Supports multiple input datasets: small, medium, and large graphs.

Includes automated unit tests to verify correctness and performance.

📊 Results

Both algorithms consistently produce MSTs with identical total weights.

Prim generally requires fewer operations than Kruskal.

Performance and correctness verified on small, medium, and large graphs.

🏆 Bonus

Custom Graph and Edge classes implemented for cleaner, object-oriented code.

📚 References

Course slides and lecture notes on Minimum Spanning Tree.

Gson library for JSON parsing: https://github.com/google/gson
