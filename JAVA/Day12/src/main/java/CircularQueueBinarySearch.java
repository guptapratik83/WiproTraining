
	public class CircularQueueBinarySearch {
	    public static void main(String[] args) {
	        int[] circularQueue = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
	        int target = 3;
	        
	        int index = search(circularQueue, target);
	        if (index != -1) {
	            System.out.println("Element " + target + " found at index " + index);
	        } else {
	            System.out.println("Element " + target + " not found in the circular queue.");
	        }
	    }

	    public static int search(int[] circularQueue, int target) {
	        int left = 0;
	        int right = circularQueue.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            if (circularQueue[mid] == target) {
	                return mid;
	            }

	            if (circularQueue[left] <= circularQueue[mid]) {
	                // Left half is sorted
	                if (circularQueue[left] <= target && target < circularQueue[mid]) {
	                    right = mid - 1;
	                } else {
	                    left = mid + 1;
	                }
	            } else {
	                // Right half is sorted
	                if (circularQueue[mid] < target && target <= circularQueue[right]) {
	                    left = mid + 1;
	                } else {
	                    right = mid - 1;
	                }
	            }
	        }

	        return -1; // Element not found
	    }
	}


