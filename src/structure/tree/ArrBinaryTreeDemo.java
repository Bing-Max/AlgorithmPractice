package structure.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

		ArrBinaryTree tree = new ArrBinaryTree(arr);// 1 2 4 5 3 6 7
//		tree.preOrder();
		
//		tree.infixOrder();
		
		tree.postOrder();
	}
}

class ArrBinaryTree {

	private int[] vals;

	public ArrBinaryTree(int[] vals) {
		super();
		this.vals = vals;
	}

	public void preOrder() {
		this.preOrder(0);
	}
	
	public void infixOrder() {
		this.infixOrder(0);
	}
	
	public void postOrder() {
		this.postOrder(0);
	}

	// 完成顺序存储二叉树的前序遍历
	// 要求按照树的方式遍历

	public void preOrder(int index) {

		if (vals == null && vals.length == 0) {
			System.out.println("null arr");
			return;
		}

		System.out.println(vals[index]);

		// 先左递归
		if ((2 * index + 1) < vals.length) {
			preOrder(2 * index + 1);
		}

		if ((2 * index + 2) < vals.length) {
			preOrder(2 * index + 2);
		}

	}

	public void infixOrder(int index) {

		if (vals == null && vals.length == 0) {
			System.out.println("null arr");
			return;
		}

		// 先左递归
		if ((2 * index + 1) < vals.length) {
			infixOrder(2 * index + 1);
		}

		System.out.println(vals[index]);

		if ((2 * index + 2) < vals.length) {
			infixOrder(2 * index + 2);
		}

	}

	public void postOrder(int index) {

		if (vals == null && vals.length == 0) {
			System.out.println("null arr");
			return;
		}

		// 先左递归
		if ((2 * index + 1) < vals.length) {
			postOrder(2 * index + 1);
		}


		if ((2 * index + 2) < vals.length) {
			postOrder(2 * index + 2);
		}

		System.out.println(vals[index]);
	}

}
