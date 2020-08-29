package structure.binarysortree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 7, 3, 10, 12, 5, 1, 9, 0, 6 };
		BinarySortTree binarySortTree = new BinarySortTree();

		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}

		binarySortTree.infixOrder();
		System.out.println("删除成功");
		binarySortTree.del(1);
		binarySortTree.del(9);
		binarySortTree.del(12);

		binarySortTree.del(5);
		binarySortTree.del(3);

		binarySortTree.del(7);
		
		binarySortTree.del(10);
		binarySortTree.del(0);
//		binarySortTree.del(6);
//		binarySortTree.del(1);
//		binarySortTree.del(5);
		binarySortTree.infixOrder();
	}
}

class BinarySortTree {
	private Node root;

	public void add(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			this.root.add(node);
		}
	}

	public void del(int val) {
		if (this.root == null) {
			return;
		}

		Node node = searchNode(val);
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if(node == root) {
				this.root = null;
				return;
			}
			Node parent = searchParentNode(val);

			if (parent.left != null && parent.left == node) {
				parent.left = null;
			}

			if (parent.right != null && parent.right == node) {
				parent.right = null;
			}
		} else if (node.left != null && node.right != null) {

			if(node.right.left != null) {				
				node.value = delRightTreeMin(node.right);
			}else {
				node.value = node.right.value;
				node.right = node.right.right;
			}
		} else {
			Node parent = searchParentNode(val);
			if (node.left != null) {
				if (parent == null) {
					this.root = node.left;
					return;
				}

				if (parent.left != null && parent.left == node) {
					parent.left = node.left;
				}

				if (parent.right != null && parent.right == node) {
					parent.right = node.left;
				}
			} else {
				
				if (parent == null) {
					this.root = node.right;
					return;
				}
				if (parent.left != null && parent.left == node) {
					parent.left = node.right;
				}

				if (parent.right != null && parent.right == node) {
					parent.right = node.right;
				}
			}
		}
	}

	/**
	 * 寻找右子树的最小值，并且删除该值
	 * 
	 * @param node
	 * @return
	 */
	public int delRightTreeMin(Node node) {
		if (node.left != null && node.left.left == null) {
			int temp = node.left.value;
			node.left = null;
			return temp;
		}

		// 一直递归
		return delRightTreeMin(node.left);
	}

	public void preOrder() {
		if (this.root == null) {
			return;
		}

		this.root.preOrder();
	}
	
	public void infixOrder() {
		if(this.root == null) {
			return ;
		}
		
		this.root.infixOrder();
	}

	public Node searchNode(int val) {

		if (this.root == null) {
			return null;
		}

		return this.root.searchNode(val);
	}

	public Node searchParentNode(int val) {

		if (this.root == null) {
			return null;
		}

		return this.root.searchNodeParent(val);
	}

}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}

		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {

				this.right = node;
			} else {

				this.right.add(node);
			}
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
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
	
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	public Node searchNode(int val) {
		if (this != null && this.value == val) {
			return this;
		}

		if (val < this.value && this.left != null) {
			return this.left.searchNode(val);
		}

		if (val > this.value && this.right != null) {
			return this.right.searchNode(val);
		}

		return null;
	}

	public Node searchNodeParent(int val) {
		if ((this.left != null && this.left.value == val) || (this.right != null && this.right.value == val)) {
			return this;
		}

		if (this.left != null && val < this.value) {
			return this.left.searchNodeParent(val);
		}

		if (this.right != null && val > this.value) {
			return this.right.searchNodeParent(val);
		}

		return null;
	}
}
