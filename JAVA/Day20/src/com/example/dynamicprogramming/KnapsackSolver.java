package com.example.dynamicprogramming;

public class KnapsackSolver {

    public static int Knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int W = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        System.out.println("Maximum value: " + Knapsack(W, weights, values)); // Output: 220
    }
}
