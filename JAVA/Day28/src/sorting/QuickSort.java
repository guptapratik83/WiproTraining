package sorting;

public class QuickSort implements SortingStrategy {
    public int[] sort(int[] data) {
        quickSort(data, 0, data.length - 1);
        return data;
    }

    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                // Swap data[i] and data[j]
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        // Swap data[i+1] and data[high] (or pivot)
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }
}
