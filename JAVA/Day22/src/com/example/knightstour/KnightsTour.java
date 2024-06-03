package com.example.knightstour;

public class KnightsTour {
    static final int N = 8;
    static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        solveKnightsTour();
    }

    public static boolean solveKnightsTour() {
        int[][] board = new int[N][N];

        // Initialization of solution matrix
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                board[x][y] = -1;
            }
        }

        // Starting position
        board[0][0] = 0;

        if (!solveKnightsTourUtil(0, 0, 1, board, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(board);
        }

        return true;
    }

    private static boolean solveKnightsTourUtil(int x, int y, int moveCount, int[][] board, int[] xMove, int[] yMove) {
        int k, nextX, nextY;
        if (moveCount == N * N)
            return true;

        for (k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTourUtil(nextX, nextY, moveCount + 1, board, xMove, yMove))
                    return true;
                else
                    board[nextX][nextY] = -1; // Backtracking
            }
        }

        return false;
    }

    private static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    private static void printSolution(int[][] board) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }
}
