

	import java.util.Stack;

	public class StackSorting {
	    public static void main(String[] args) {
	        // Create a stack of integers
	        Stack<Integer> stack = new Stack<>();
	        stack.push(3);
	        stack.push(1);
	        stack.push(4);
	        stack.push(2);

	        // Sort the stack
	        sortStack(stack);

	        // Print the sorted stack
	        System.out.println("Sorted stack:");
	        while (!stack.isEmpty()) {
	            System.out.println(stack.pop());
	        }
	    }

	    public static void sortStack(Stack<Integer> stack) {
	        Stack<Integer> tempStack = new Stack<>();

	        while (!stack.isEmpty()) {
	            int temp = stack.pop();
	            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
	                stack.push(tempStack.pop());
	            }
	            tempStack.push(temp);
	        }

	        while (!tempStack.isEmpty()) {
	            stack.push(tempStack.pop());
	        }
	    }
	}


