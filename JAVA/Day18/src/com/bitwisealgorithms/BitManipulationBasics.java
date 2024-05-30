package com.bitwisealgorithms;

/*
* Bit Manipulation Basics
* This class includes a function to count the number of set bits (1s) in a single integer
* and another function to count the total number of set bits in all integers from 1 to n.
*/

public class BitManipulationBasics {
    
    // Function to count the number of set bits in a single integer
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    
    // Function to count the total number of set bits in all integers from 1 to n
    public static int countTotalSetBits(int n) {
        int totalSetBits = 0;
        for (int i = 1; i <= n; i++) {
            totalSetBits += countSetBits(i);
        }
        return totalSetBits;
    }
    
    public static void main(String[] args) {
        int num = 5; // Example input
        System.out.println("Number of set bits in " + num + " is " + countSetBits(num));
        System.out.println("Total number of set bits from 1 to " + num + " is " + countTotalSetBits(num));
    }
}
