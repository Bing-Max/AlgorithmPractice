package structure.tree.avl;

public class AVLTreeDemo {

	public static void main(String[] args) {

		int arr[] = { 4, 3, 6, 5, 7, 8, 9 };
//		int arr[] = { 10, 12, 8, 9, 7, 6 };
//		int arr[] = { 10, 11, 7, 6, 8, 9 };

		AVLTree tree = new AVLTree();

		for (int i = 0; i < arr.length; i++) {
			tree.add(new Node(arr[i]));
		}

		tree.infixOrder();

		System.out.println(tree.getRoot().height());
		System.out.println(tree.getRoot().leftHeight());
		System.out.println(tree.getRoot().rightHeight());
		System.out.println("root: " + tree.getRoot());
		System.out.println("root: " + tree.getRoot().right);
		tree.infixOrder();
	}

}

class AVLTree {
	private Node root;

	public Node getRoot() {
		return root;
	}

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
			if (node == root) {
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

			if (node.right.left != null) {
				node.value = delRightTreeMin(node.right);
			} else {
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
		if (this.root == null) {
			return;
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

	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	public int rightHeight() {
		if (right == null) {
			return 0;
		}

		return right.height();
	}

	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	public void leftRotate() {

		Node node = new Node(value);

		node.left = this.left;
		node.right = this.right.left;
		// 左侧挂上转后的树
		this.left = node;

		// 右侧的结点左旋
		this.value = this.right.value;
		this.right = this.right.right;

		// 可以这样理解，但是带来问题： 根节点会变化
//		// 结点的右侧挂上右子节点的左子树
//		this.right = right.left;
//		
//		// 右子节点旋转上去即可
//		node.left = this; 

	}

	public void rightRotate() {
		Node node = new Node(value);

		node.right = this.right;
		node.left = this.left.right;
		// 右侧侧挂上转后的树
		this.right = node;

		// 左子节点的结点右旋
		this.value = this.left.value;
		this.left = this.left.left;
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

		if (rightHeight() - leftHeight() > 1) {
			// 如果左子树是因为右子树较高造成的结点不平衡
			// 即左子树的右树高度 > 左子树的左子树高度
			if(right!= null && right.rightHeight() < right.leftHeight() ) {
				
				// 右节点先左旋降低this.right 的 leftHeight
				right.rightRotate();
			}
			
			leftRotate();
			
			// 旋转结束可以直接return 不必考虑之后的内容
			return;
		}

		if (leftHeight() - rightHeight() > 1) {
			
			// 如果左子树是因为右子树较高造成的结点不平衡
			// 即左子树的右树高度 > 左子树的左子树高度
			if(left!= null && left.rightHeight() > left.leftHeight() ) {
				
				// 左节点先左旋降低this.left 的 rightHeight
				left.leftRotate();				
			}
			// 右旋，降低this leftHeight()
			rightRotate();
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