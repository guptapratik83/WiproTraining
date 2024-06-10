package application;

import sorting.BubbleSort;
import sorting.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] data = { 5, 2, 9, 1, 5, 6 };

        Context context = new Context(new BubbleSort()); // or new Context(new QuickSort()) for QuickSort
        int[] sortedData = context.sortData(data);
        
        // Print sorted data
        System.out.print("Sorted Data: ");
        for (int num : sortedData) {
            System.out.print(num + " ");
        }
    }
}
