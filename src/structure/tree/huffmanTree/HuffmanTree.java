package structure.tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {

//		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		int arr[] = { 1, 1, 1, 2, 2, 2, 4, 4, 4, 5, 5, 9 };
		Node root = creatHuffmanTree(arr);

		preOrder(root);
	}

	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("null huffman tree");
		}
	}

	public static Node creatHuffmanTree(int[] arr) {

		List<Node> nodes = new ArrayList<Node>();
		for (int i : arr) {
			nodes.add(new Node(i));
		}

		while (nodes.size() > 1) {
			// 对权值进行排序
			Collections.sort(nodes);

			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);

			Node newNode = new Node(leftNode.val + rightNode.val);
			newNode.left = leftNode;
			newNode.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);

			nodes.add(newNode);

		}

		return nodes.get(0);

	}

}

class Node implements Comparable<Node> {
	int val;

	Node left;
	Node right;

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	public Node(int val) {
		super();
		this.val = val;
	}

	public Node() {
		super();
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}

	public void preOrder() {
		System.out.println(this);

		if (this.left != null) {
			this.left.preOrder();
		}

		if (this.right != null) {
			this.right.preOrder();
		}
	}
}
