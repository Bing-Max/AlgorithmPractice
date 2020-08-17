package structure.tree;

public class BinaryTreeDemo {
	
	public static void main(String[] args) {
		
		//测试
		System.out.println("测试 开始 tree~ ");
		
		HeroNode root = new HeroNode("宋江", 1);
		HeroNode node1 = new HeroNode("吴用", 2);
		HeroNode node2 = new HeroNode("卢俊义", 3);
		HeroNode node3 = new HeroNode("林冲", 4);
		HeroNode node4 = new HeroNode("张清", 5);
		
		root.setLeft(node1);
		root.setRight(node2);
		node2.setLeft(node4);
		node2.setRight(node3);
		
		BinaryTree tree = new BinaryTree();
		tree.setRoot(root);
		
		System.out.println("前序遍历");
		tree.preOrder();
		
		System.out.println("中序遍历");
		tree.infixOrder();
		
		System.out.println("后序遍历");
		tree.postOrder();
	}

}

class BinaryTree{
	private HeroNode root;

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("null tree~");
		}
	}
	
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("null tree~");
		}
	}
	
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("null tree~");
		}
	}
	
}

class HeroNode{
	private String name;
	private int id;
	
	private HeroNode left;
	private HeroNode right;
	
	public HeroNode(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [name=" + name + ", id=" + id + "]";
	}
	
	
	public void preOrder() {
		System.out.println(this);
		
		if(this.left != null) {
			this.getLeft().preOrder();
			
		}
		
		if(this.right != null) {
			this.getRight().preOrder();
		}
	}
	
	public void infixOrder() {
		if(this.left != null) {
			this.getLeft().infixOrder();
			
		}
		
		System.out.println(this);
		
		if(this.right != null) {
			this.getRight().infixOrder();
		}
	}
	
	public void postOrder() {
		
		if(this.left != null) {
			this.getLeft().postOrder();
			
		}
		
		if(this.right != null) {
			this.getRight().postOrder();
		}
		
		System.out.println(this);
	}
}
