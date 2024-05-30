package task6;

	import java.util.*;

	public class GraphBFS {
	    private Map<String, List<String>> graph;

	    public GraphBFS() {
	        graph = new HashMap<>();
	    }

	    public void addEdge(String src, String dest) {
	        graph.putIfAbsent(src, new ArrayList<>());
	        graph.putIfAbsent(dest, new ArrayList<>());
	        graph.get(src).add(dest);
	        graph.get(dest).add(src); // Because the graph is undirected
	    }

	    public void bfs(String start) {
	        Set<String> visited = new HashSet<>();
	        Queue<String> queue = new LinkedList<>();
	        
	        queue.add(start);
	        
	        while (!queue.isEmpty()) {
	            String node = queue.poll();
	            
	            if (!visited.contains(node)) {
	                System.out.print(node + " ");  // Print the node as it's visited
	                visited.add(node);
	                
	                for (String neighbor : graph.get(node)) {
	                    if (!visited.contains(neighbor)) {
	                        queue.add(neighbor);
	                    }
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        GraphBFS graph = new GraphBFS();
	        graph.addEdge("A", "B");
	        graph.addEdge("A", "C");
	        graph.addEdge("B", "D");
	        graph.addEdge("B", "E");
	        graph.addEdge("C", "F");
	        graph.addEdge("E", "F");
	        
	        // Start BFS from node 'A'
	        graph.bfs("A");
	    }
	}


