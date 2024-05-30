
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Stack;

	public class QueueSorting {
	    public static void main(String[] args) {
	        // Create a queue of integers
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(3);
	        queue.offer(1);
	        queue.offer(4);
	        queue.offer(2);

	        // Sort the queue
	        sortQueue(queue);

	        // Print the sorted queue
	        System.out.println("Sorted queue:");
	        while (!queue.isEmpty()) {
	            System.out.println(queue.poll());
	        }
	    }

	    public static void sortQueue(Queue<Integer> queue) {
	        Stack<Integer> stack = new Stack<>();

	        while (!queue.isEmpty()) {
	            int temp = queue.poll();
	            while (!stack.isEmpty() && stack.peek() > temp) {
	                queue.offer(stack.pop());
	            }
	            stack.push(temp);
	        }

	        while (!stack.isEmpty()) {
	            queue.offer(stack.pop());
	        }
	    }
	}


