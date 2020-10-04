package leetcode.simple;

import leetcode.TreeNode;

public class ConvertBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(23);
		TreeNode left = new TreeNode(15);
		TreeNode right = new TreeNode(50);

		TreeNode node1 = new TreeNode(43);
		TreeNode node2 = new TreeNode(69);
		TreeNode node3 = new TreeNode(40);
		TreeNode node4 = new TreeNode(45);
		TreeNode node5 = new TreeNode(55);
		TreeNode node6 = new TreeNode(70);
		TreeNode node7 = new TreeNode(10);
		TreeNode node8 = new TreeNode(20);

		left.left = node7;
		left.right = node8;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;
		node2.right = node6;

		right.left = node1;
		right.right = node2;

		root.left = left;
		root.right = right;
//		infix(root);
		convertBST(root);

	}

	public static TreeNode convertBST(TreeNode root) {
		InverseInfix(root, 0);
		infix(root);
		return root;
	}

	public static int InverseInfix(TreeNode node, int val) {

		if (node == null) {
			return val;
		}
		
		node.val += InverseInfix(node.right, val);

		val = node.val;
		
		if(node.left == null) {
			return val;
		}

		return InverseInfix(node.left, val);
	}

	public static void infix(TreeNode node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			infix(node.left);
		}

		System.out.println(node.val);

		if (node.right != null) {
			infix(node.right);
		}
	}

}
