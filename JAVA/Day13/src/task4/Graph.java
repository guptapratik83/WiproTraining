package task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V; // Number of vertices
    private ArrayList<ArrayList<Integer>> adj; // Adjacency list representation of the graph

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public boolean hasCycle(int u, int v) {
        addEdge(u, v); // Adding the edge temporarily
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i) {
            if (!visited[i] && isCyclicUtil(i, visited, -1)) {
                removeEdge(u, v); // Removing the edge after cycle check
                return true;
            }
        }
        removeEdge(u, v); // Removing the edge after cycle check
        return false;
    }

    private void removeEdge(int u, int v) {
        adj.get(u).remove(Integer.valueOf(v));
        adj.get(v).remove(Integer.valueOf(u));
    }

    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer i : adj.get(v)) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        int u = 0, v = 3;
        if (graph.hasCycle(u, v))
            System.out.println("Edge (" + u + ", " + v + ") forms a cycle.");
        else
            System.out.println("Edge (" + u + ", " + v + ") does not form a cycle.");

        u = 1;
        v = 3;
        if (graph.hasCycle(u, v))
            System.out.println("Edge (" + u + ", " + v + ") forms a cycle.");
        else
            System.out.println("Edge (" + u + ", " + v + ") does not form a cycle.");
    }
}
