package task5;


	
	import java.util.*;



	public class GraphDFS {
		

		

		    private Map<String, List<String>> graph;

		    public GraphDFS() {
		        graph = new HashMap<>();
		    }

		    public void addEdge(String src, String dest) {
		        graph.putIfAbsent(src, new ArrayList<>());
		        graph.putIfAbsent(dest, new ArrayList<>());
		        graph.get(src).add(dest);
		        graph.get(dest).add(src); // Because the graph is undirected
		    }

		    public void dfs(String start) {
		        Set<String> visited = new HashSet<>();
		        dfsRecursive(start, visited);
		    }

		    private void dfsRecursive(String node, Set<String> visited) {
		        if (!visited.contains(node)) {
		            System.out.print(node + " ");  // Print the node as it's visited
		            visited.add(node);

		            for (String neighbor : graph.get(node)) {
		                if (!visited.contains(neighbor)) {
		                    dfsRecursive(neighbor, visited);
		                }
		            }
		        }
		    }

		    public static void main(String[] args) {
		        GraphDFS graph = new GraphDFS();
		        graph.addEdge("A", "B");
		        graph.addEdge("A", "C");
		        graph.addEdge("B", "D");
		        graph.addEdge("B", "E");
		        graph.addEdge("C", "F");
		        graph.addEdge("E", "F");
		        
		        // Start DFS from node 'A'
		        graph.dfs("A");
		    }
		}



