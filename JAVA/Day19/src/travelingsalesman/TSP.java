package travelingsalesman;

public class TSP {
    
    public static int findMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[1 << n][n];
        
        // Initialize the dp array with infinity
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Starting point, cost to reach each city from city 0
        for (int i = 1; i < n; i++) {
            dp[1 << i][i] = graph[0][i];
        }

        // Populate the dp array
        for (int mask = 0; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // If i is in the set represented by mask
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) != 0 && i != j) { // If j is in the set and j != i
                            dp[mask][i] = Math.min(dp[mask][i], dp[mask ^ (1 << i)][j] + graph[j][i]);
                        }
                    }
                }
            }
        }

        // Calculate the minimum cost to return to the starting city
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, dp[VISITED_ALL][i] + graph[i][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };
        
        System.out.println("The minimum cost is: " + findMinCost(graph));
    }
}
