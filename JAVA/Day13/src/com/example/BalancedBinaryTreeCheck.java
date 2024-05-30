package com.example;

public class BalancedBinaryTreeCheck {
	

	    public static class TreeNode {
	        int val;
	        TreeNode left;
	        TreeNode right;

	        TreeNode(int x) {
	            val = x;
	        }
	    }

	    public boolean isBalanced(TreeNode root) {
	        if (root == null) {
	            return true;
	        }

	        int leftHeight = height(root.left);
	        int rightHeight = height(root.right);

	        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	    }

	    private int height(TreeNode node) {
	        if (node == null) {
	            return 0;
	        }

	        return Math.max(height(node.left), height(node.right)) + 1;
	    }

	    public static void main(String[] args) {
	        BalancedBinaryTreeCheck solution = new BalancedBinaryTreeCheck();

	        // Example usage:
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);

	        boolean isBalanced = solution.isBalanced(root);
	        System.out.println("Is the tree balanced? " + isBalanced); // Output: true
	    }
	}


