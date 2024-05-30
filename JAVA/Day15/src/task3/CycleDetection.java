package task3;

public class CycleDetection {
	
	    public static boolean hasCycle(int[][] edges, int numNodes) {
	        UninFind uf = new UninFind(numNodes);

	        for (int[] edge : edges) {
	            int node1 = edge[0];
	            int node2 = edge[1];
	            if (!uf.union(node1, node2)) {
	                return true; // A cycle is detected
	            }
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        // Example usage:
	        // The graph is represented as an array of edges, where each edge is an array [u, v]
	        int[][] edges = {
	            {0, 1},
	            {1, 2},
	            {2, 0}
	        };
	        int numNodes = 3;

	        System.out.println(hasCycle(edges, numNodes)); // Output: true (There is a cycle: 0-1-2-0)
	    }
	}


