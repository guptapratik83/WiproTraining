
	package task2;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	class Edge implements Comparable<Edge> {
	    int src, dest, weight;

	    // Constructor
	    public Edge(int src, int dest, int weight) {
	        this.src = src;
	        this.dest = dest;
	        this.weight = weight;
	    }

	    // Comparator function used for sorting edges based on their weight
	    public int compareTo(Edge compareEdge) {
	        return this.weight - compareEdge.weight;
	    }
	}

	class Graph {
	    int V, E; // V-> Number of vertices, E-> Number of edges
	    List<Edge> edges; // Collection of all edges

	    // Constructor
	    Graph(int V, int E) {
	        this.V = V;
	        this.E = E;
	        edges = new ArrayList<>(E);
	    }

	    // Function to add an edge to the graph
	    public void addEdge(int src, int dest, int weight) {
	        Edge edge = new Edge(src, dest, weight);
	        edges.add(edge);
	    }

	    // Function to find the MST using Kruskal's algorithm
	    public List<Edge> kruskalMST() {
	        List<Edge> result = new ArrayList<>(); // Store the resultant MST

	        // Step 1: Sort all the edges in non-decreasing order of their weight
	        Collections.sort(edges);

	        // Allocate memory for creating V subsets
	        DisjointSet ds = new DisjointSet(V);

	        // Iterate through the sorted edges
	        for (Edge edge : edges) {
	            int x = ds.find(edge.src);
	            int y = ds.find(edge.dest);

	            // If including this edge does not cause a cycle, include it in result
	            // and take the union of these two vertices
	            if (x != y) {
	                result.add(edge);
	                ds.union(x, y);
	            }
	        }
	        return result;
	    }
	}

	class DisjointSet {
	    int[] parent, rank;
	    int n;

	    // Constructor
	    public DisjointSet(int n) {
	        this.n = n;
	        parent = new int[n];
	        rank = new int[n];

	        // Initially, all vertices are in different sets and have rank 0
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	            rank[i] = 0;
	        }
	    }

	    // Find function with path compression
	    public int find(int u) {
	        if (u != parent[u]) {
	            parent[u] = find(parent[u]);
	        }
	        return parent[u];
	    }

	    // Union function using rank
	    public void union(int u, int v) {
	        int rootU = find(u);
	        int rootV = find(v);

	        if (rootU != rootV) {
	            if (rank[rootU] < rank[rootV]) {
	                parent[rootU] = rootV;
	            } else if (rank[rootU] > rank[rootV]) {
	                parent[rootV] = rootU;
	            } else {
	                parent[rootV] = rootU;
	                rank[rootU]++;
	            }
	        }
	    }
	}

	public class KruskalAlgorithm {

	    public static void main(String[] args) {
	        int V = 4; // Number of vertices in the graph
	        int E = 5; // Number of edges in the graph
	        Graph graph = new Graph(V, E);

	        // Adding edges to the graph
	        graph.addEdge(0, 1, 10);
	        graph.addEdge(0, 2, 6);
	        graph.addEdge(0, 3, 5);
	        graph.addEdge(1, 3, 15);
	        graph.addEdge(2, 3, 4);

	        // Calculate the MST using Kruskal's algorithm
	        List<Edge> mst = graph.kruskalMST();

	        // Print the edges in the MST
	        System.out.println("Edges in the Minimum Spanning Tree:");
	        for (Edge edge : mst) {
	            System.out.println(edge.src + " - " + edge.dest + " with weight " + edge.weight);
	        }
	    }
	}


