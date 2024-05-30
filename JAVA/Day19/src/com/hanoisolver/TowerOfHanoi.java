package com.hanoisolver;

public class TowerOfHanoi {
    // Recursive function to solve the Tower of Hanoi puzzle
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }

        // Move top n-1 disks from fromRod to auxRod using toRod
        solveHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from fromRod to toRod
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);

        // Move the n-1 disks from auxRod to toRod using fromRod
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // Number of disks, you can change this value to test with different numbers
        solveHanoi(numberOfDisks, 'A', 'C', 'B'); // A is the source rod, C is the destination rod, B is the auxiliary rod
    }
}
