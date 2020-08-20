package structure.tree.threadedbinarytree;

public class BinaryTreeDemo {

	public static void main(String[] args) {

		// 测试
		System.out.println("测试 开始 tree~ ");

		HeroNode root = new HeroNode("宋江", 1);
		HeroNode node1 = new HeroNode("吴用", 2);
		HeroNode node2 = new HeroNode("卢俊义", 3);
		HeroNode node3 = new HeroNode("林冲", 4);
		HeroNode node4 = new HeroNode("张清", 5);

		root.setLeft(node1);
		root.setRight(node2);
		
		node1.setParent(root);
		node2.setParent(root);
		
		node2.setLeft(node4);
		node2.setRight(node3);

		node3.setParent(node2);
		node4.setParent(node2);
		
		BinaryTree tree = new BinaryTree();
		tree.setRoot(root);

//		tree.infixThreadedTree(root);
//		tree.preThreadedTree(root);
		tree.postThreadedTree(root);
		
		System.out.println("吴用的前驱节点：" + node1.getLeft());

		System.out.println("林冲的前驱节点：" + node3.getLeft());

		System.out.println("张清的前驱节点：" + node4.getLeft());

		System.out.println("吴用的后继节点：" + node1.getRight());

		System.out.println("林冲的后继节点：" + node3.getRight());

		System.out.println("张清的后继节点：" + node4.getRight());
//		tree.infixThreadedList();
		tree.postThreadedList();
//		tree.preThreadedList();
//		System.out.println("前序遍  历");
//		tree.preOrder();

//		System.out.println("中序遍历");
//		tree.infixOrder();
//		
//		System.out.println("后序遍历");
//		tree.postOrder();
//		
//		System.out.println("前序查找");
//		System.out.println(tree.preOrderSearch(5));
//		System.out.println("中序查找");
//		System.out.println(tree.infixOrderSearch(5));
//		System.out.println("后序查找");
//		System.out.println(tree.postOrderSearch(5));

//		tree.delNode(2);
//		tree.preOrder();
	}

}

class BinaryTree {
	private HeroNode root;

	// 当前节点的前驱节点
	private HeroNode pre;

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("null tree~");
		}
	}

	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("null tree~");
		}
	}

	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("null tree~");
		}
	}

	public HeroNode preOrderSearch(int no) {
		if (this.root == null) {
			System.out.println("null tree");
			System.out.println(" not find!");
			return null;
		}

		return this.root.preOrderSearch(no);
	}

	public HeroNode infixOrderSearch(int no) {
		if (this.root == null) {
			System.out.println("null tree");
			System.out.println(" not find!");
			return null;
		}

		return this.root.infixOrderSearch(no);
	}

	public HeroNode postOrderSearch(int no) {
		if (this.root == null) {
			System.out.println("null tree");
			System.out.println(" not find!");
			return null;
		}

		return this.root.postOrderSearch(no);
	}

	public boolean delNode(int no) {

		if (this.root == null) {
			System.out.println("null tree");
			return false;
		} else if (this.root.getId() == no) {
			this.root = null;
			System.out.println("删除根节点");
			return true;
		} else {
			this.root.delNode(no);
		}

		return false;

	}

	public void infixThreadedTree(HeroNode node) {

		if (node == null) {
			return;
		}

		// 中序遍历处理线索化
		if (node.getLeft() != null) {
			infixThreadedTree(node.getLeft());
		}

		if (node.getLeft() == null) {
			node.setLeft(pre);

			node.setLeftType(1);
		}

		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);

			pre.setRightType(1);
		}

		// 前驱节点后移
		pre = node;

		if (node.getRight() != null) {
			infixThreadedTree(node.getRight());
		}

	}

	public void preThreadedTree(HeroNode node) {

		if (node == null) {
			return;
		}

		// 前序遍历处理线索化
		if (node.getLeft() == null) {
			node.setLeft(pre);

			node.setLeftType(1);
		}

		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);

			pre.setRightType(1);
		}

		// 前驱节点后移
		pre = node;

		// 这里需要注意：
		// 因为前序遍历时，将左null 节点改为前驱节点，这里不判断节点类型会导致循环递归
		// 最好的习惯就是每次递归都判断子节点的type
		if ( node.getLeft() != null && node.getLeftType() == 0) {
			preThreadedTree(node.getLeft());
		}

		if (node.getRight() != null) {
			preThreadedTree(node.getRight());
		}
	}

	public void postThreadedTree(HeroNode node) {

		if (node == null) {
			return;
		}

		if (node.getLeft() != null) {
			postThreadedTree(node.getLeft());
		}

		if (node.getRight() != null) {
			postThreadedTree(node.getRight());
		}

		// 前序遍历处理线索化
		if (node.getLeft() == null) {
			node.setLeft(pre);

			node.setLeftType(1);
		}

		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);

			pre.setRightType(1);
		}

		// 前驱节点后移
		pre = node;
	}

	public void infixThreadedList() {
		HeroNode node = root;
		while(node != null) {
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			// 一直遇到第一个 前驱节点为null type 为1的节点
			System.out.println(node);
			
			// 后继结点输出
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			
			// 找不到后继结点之后, 替换
			// 直到遇到下一个没有线索的节点
			node = node.getRight();
		}
	}
	
	public void preThreadedList() {
		HeroNode node = root;
		
		while(node != null) {
			System.out.println(node);
			
			while(node.getLeftType() == 0) {
				node = node.getLeft();
				System.out.println(node);
				
			}
			
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			
			// 替换
			if(node.getLeftType() == 0) {
				node = node.getLeft();
			}else {				
				node = node.getRight();
			}
		}
	}
	
	public void postThreadedList() {
		HeroNode node = root;
		while(node != null) {
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			// 一直遇到第一个 前驱节点为null type 为1的节点
			System.out.println(node);
			
			// 后继结点输出
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			
			// 找不到后继结点之后, 替换找父节点的右子节点，如果本身就是右子节点，那就输出父节点
			// 直到遇到下一个没有线索的节点
			while(node.getParent() != null && node.getParent().getRight() == node) {
				node = node.getParent();
				System.out.println(node);
			}
			
			// 直到找到父节点的右节点
			if(node.getParent() != null) {				
				// 替换到右兄弟节点
				node = node.getParent().getRight();
			} else {
				// 如果父节点为空，结束循环
				node = node.getParent();
			}
		}
		
	}
}

class HeroNode {
	private String name;
	private int id;

	private HeroNode left;
	private HeroNode right;
	
	private HeroNode parent;

	// 说明
	// 如果type == 0， 说明指向左（右）子树， 如果type == 1, 说明指向 前驱（后继）结点
	private int leftType;
	private int rightType;

	public HeroNode(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public HeroNode getParent() {
		return parent;
	}

	public void setParent(HeroNode parent) {
		this.parent = parent;
	}

	public HeroNode() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
//		left.setParent(this);
		this.left = left;
		this.leftType = 0;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
//		right.setParent(this);
		this.right = right;
		this.rightType = 0;
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	@Override
	public String toString() {
		return "HeroNode [name=" + name + ", id=" + id + "]";
	}

	public void preOrder() {
		System.out.println(this);

		if (this.left != null) {
			this.getLeft().preOrder();

		}

		if (this.right != null) {
			this.getRight().preOrder();
		}
	}

	public void infixOrder() {
		if (this.left != null) {
			this.getLeft().infixOrder();

		}

		System.out.println(this);

		if (this.right != null) {
			this.getRight().infixOrder();
		}
	}

	public void postOrder() {

		if (this.left != null) {
			this.getLeft().postOrder();

		}

		if (this.right != null) {
			this.getRight().postOrder();
		}

		System.out.println(this);
	}

	public HeroNode preOrderSearch(int no) {
		System.out.printf("%s - 前序遍历\n", this.toString());
		// 前序遍历
		// 先比较父节点
		if (this.id == no) {
			return this;
		}

		// 空结点
		HeroNode node = null;

		if (this.left != null) {
			node = this.left.preOrderSearch(no);
		}

		if (node != null) {
			return node;
		}

		if (this.right != null) {
			node = this.right.preOrderSearch(no);
		}

		return node;
	}

	public HeroNode infixOrderSearch(int no) {
		// 中序遍历
		// 先左子树
		HeroNode node = null;
		if (this.left != null && (node = this.left.infixOrderSearch(no)) != null) {
			return node;
		}

		System.out.printf("%s - 中序遍历\n", this.toString());
		if (this.id == no) {
			return this;
		}

		if (this.right != null && (node = this.right.infixOrderSearch(no)) != null)
			;

		return node;
	}

	public HeroNode postOrderSearch(int no) {
		// 后序遍历
		// 最后根节点
		HeroNode node = null;
		if (this.left != null && (node = this.left.postOrderSearch(no)) != null) {
			return node;
		}

		if (this.right != null && (node = this.right.postOrderSearch(no)) != null)
			return node;

		System.out.printf("%s - 后序遍历\n", this.toString());

		return (this.id == no ? this : null);

	}

	public boolean delNode(int no) {
		if (this.left != null && this.left.id == no) {
			this.left = null;
			return true;
		}

		if (this.right != null && this.right.id == no) {
			this.right = null;
			return true;
		}

		if (this.left != null && this.left.delNode(no)) {
			return true;

		} else if (this.right != null && this.right.delNode(no)) {

			return true;
		}

		return false;
	}
}
