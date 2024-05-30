

	import java.util.Stack;

	public class SequenceSearch {
	    public static void main(String[] args) {
	        Stack<Integer> stack = new Stack<>();
	        stack.push(3);
	        stack.push(1);
	        stack.push(4);
	        stack.push(2);
	        stack.push(5);

	        int[] sequence = {1, 4, 2};

	        boolean isSequencePresent = isSequenceInStack(stack, sequence);
	        System.out.println("Sequence is present in stack: " + isSequencePresent);
	    }

	    public static boolean isSequenceInStack(Stack<Integer> stack, int[] sequence) {
	        Stack<Integer> tempStack = new Stack<>();

	        // Find the first element of the sequence in the stack
	        while (!stack.isEmpty() && stack.peek() != sequence[0]) {
	            tempStack.push(stack.pop());
	        }

	        if (stack.isEmpty()) {
	            // Sequence not found in the stack
	            return false;
	        }

	        // Check if the remaining elements of the sequence are present consecutively in the stack
	        for (int i = 0; i < sequence.length; i++) {
	            if (stack.isEmpty() || stack.peek() != sequence[i]) {
	                // Restore the original stack
	                while (!tempStack.isEmpty()) {
	                    stack.push(tempStack.pop());
	                }
	                return false;
	            }
	            stack.pop();
	        }

	        // Restore the original stack
	        while (!tempStack.isEmpty()) {
	            stack.push(tempStack.pop());
	        }

	        return true;
	    }
	}


