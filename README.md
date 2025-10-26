City Transportation Network Optimization (Assignment 3)
Overview

This project implements Prim’s and Kruskal’s algorithms to find the Minimum Spanning Tree (MST) of a city transportation network. The goal is to determine the minimum set of roads that connect all city districts with the lowest possible construction cost.

The city network is modeled as a weighted undirected graph, where vertices represent city districts, edges represent potential roads, and weights represent construction costs.

Project Structure

src/: Java source code

Main.java

Prim.java

Kruskal.java

Graph.java (optional, bonus)

Edge.java (optional, bonus)

input/: Input JSON files

SmallGraph.json

MediumGraph.json

LargeGraph.json

output/: Output JSON files

output.json

tests/: Unit tests

MSTTest.java

report/: Analytical report

report.pdf

How to Run

Open the project in VS Code or any Java IDE.

Make sure the Gson library is included in your classpath for JSON parsing.

Compile the code using javac, including Gson in the classpath.

Run Main.java.

Check the output folder for output.json containing MST results.

Features

Implements Prim’s algorithm for MST.

Implements Kruskal’s algorithm for MST.

Records for each algorithm: MST edges, total weight, operation counts, and execution time.

Supports multiple input datasets (small, medium, large).

Includes automated unit tests for correctness and performance.

Results

Both algorithms generate correct MSTs with identical total weights.

Prim generally requires fewer operations than Kruskal.

Performance and correctness are verified on small, medium, and large graphs.

Bonus

Includes custom Graph and Edge classes for cleaner code and object-oriented design.

References

Course slides and lecture notes on Minimum Spanning Tree.

Gson library for JSON parsing: https://github.com/google/gson
