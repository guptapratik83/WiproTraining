
	package task1;

	import java.util.*;

	public class Dijkstra {
	    private static final int INF = Integer.MAX_VALUE;

	    public static Map<Character, Integer> dijkstra(Map<Character, Map<Character, Integer>> graph, char start) {
	        Map<Character, Integer> distances = new HashMap<>();
	        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
	        
	        // Initialize distances map with INF for all nodes except the start node
	        for (char node : graph.keySet()) {
	            distances.put(node, node == start ? 0 : INF);
	            pq.offer(new Node(node, distances.get(node)));
	        }
	        
	        while (!pq.isEmpty()) {
	            Node current = pq.poll();
	            
	            for (Map.Entry<Character, Integer> neighbor : graph.get(current.name).entrySet()) {
	                int newDistance = distances.get(current.name) + neighbor.getValue();
	                
	                if (newDistance < distances.get(neighbor.getKey())) {
	                    distances.put(neighbor.getKey(), newDistance);
	                    pq.offer(new Node(neighbor.getKey(), newDistance));
	                }
	            }
	        }
	        
	        return distances;
	    }

	    public static void main(String[] args) {
	        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
	        graph.put('A', Map.of('B', 5, 'C', 3));
	        graph.put('B', Map.of('A', 5, 'C', 2, 'D', 1));
	        graph.put('C', Map.of('A', 3, 'B', 2, 'D', 4, 'E', 6));
	        graph.put('D', Map.of('B', 1, 'C', 4, 'E', 7));
	        graph.put('E', Map.of('C', 6, 'D', 7));

	        char startNode = 'A';
	        Map<Character, Integer> shortestDistances = dijkstra(graph, startNode);
	        System.out.println("Shortest distances from node " + startNode + ": " + shortestDistances);
	    }

	    static class Node {
	        char name;
	        int distance;

	        Node(char name, int distance) {
	            this.name = name;
	            this.distance = distance;
	        }
	    }
	}


