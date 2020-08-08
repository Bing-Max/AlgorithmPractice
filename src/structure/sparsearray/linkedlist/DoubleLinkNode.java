package structure.sparsearray.linkedlist;

public class DoubleLinkNode {
	
	public int id;
	public String name;
	public String nickName;
	
	public DoubleLinkNode next = null;// 指向下一节点
	public DoubleLinkNode pre = null;
	public DoubleLinkNode(int id, String name, String nickName) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
	}
	
	public DoubleLinkNode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DoubleLinkNode [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
