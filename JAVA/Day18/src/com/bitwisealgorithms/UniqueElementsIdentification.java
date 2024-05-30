package com.bitwisealgorithms;

import java.util.Arrays;

public class UniqueElementsIdentification {

    public static int[] findUniqueElements(int[] nums) {
        // Step 1: XOR all elements to get the XOR of the two unique numbers
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // Step 2: Find a bit that is set in xorResult
        int setBit = xorResult & ~(xorResult - 1);

        // Step 3: Divide the numbers into two groups and XOR within each group
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & setBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] uniqueElements = findUniqueElements(nums);
        System.out.println("The two unique elements are: " + Arrays.toString(uniqueElements));
    }
}
