package structure.sparsearray.linkedlist;

public class LinkNode {
	public int id;
	public String name;
	public String nickName;
	
	public LinkNode next = null;// 指向下一节点
	
	public LinkNode(int id, String name, String nickName) {
		this.id = id;
		this.name = name;
		this.nickName = nickName;
	}
	
	public LinkNode() {
		this.id = 0;
	}

	@Override
	public String toString() {
		return "LinkNode [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}
	

}
