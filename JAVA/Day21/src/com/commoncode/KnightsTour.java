package com.commoncode;

public class KnightsTour {
    static int N = 8;

    // Function to check if x, y are valid indexes for N*N chessboard
    static boolean isSafe(int x, int y, int board[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Function to solve Knight's Tour problem using backtracking
    static boolean solveKnightsTour(int board[][], int moveX, int moveY, int moveCount, int xMove[], int yMove[]) {
        int k, nextX, nextY;
        if (moveCount == N * N)
            return true;

        for (k = 0; k < 8; k++) {
            nextX = moveX + xMove[k];
            nextY = moveY + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTour(board, nextX, nextY, moveCount + 1, xMove, yMove))
                    return true;
                else
                    board[nextX][nextY] = -1; // backtracking
            }
        }

        return false;
    }

    // Function to initialize the board and call the solver function
    static boolean solve() {
        int board[][] = new int[N][N];

        // Initialization of board[][] with -1
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                board[x][y] = -1;

        // xMove[] and yMove[] define next move of Knight.
        // xMove[] is for next value of x coordinate
        // yMove[] is for next value of y coordinate
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Starting position of Knight
        int startX = 0;
        int startY = 0;

        // Starting from 0,0 and marking it as the first move
        board[startX][startY] = 0;

        // Check if solution exists or not
        if (!solveKnightsTour(board, startX, startY, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(board);

        return true;
    }

    // Function to print the solution
    static void printSolution(int board[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
