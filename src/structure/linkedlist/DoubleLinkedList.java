package structure.linkedlist;

public class DoubleLinkedList {

	public DoubleLinkNode head = new DoubleLinkNode(0, "", ""); 
	
	// 默认添加到链表尾部
	public void add(DoubleLinkNode node) {
		DoubleLinkNode p = head;
		while(p.next != null) {
			if(p.next.id == node.id) {
				System.out.printf("node[%d]already exist!!!\n", node.id);
				return;
			}
			p = p.next;
		}
		
		node.next = p.next;
		p.next = node;
		node.pre = p;
		
	}
	
	public void addBySort(DoubleLinkNode node) {
		DoubleLinkNode p = head;
		while(p.next != null && p.next.id <= node.id) {
			if(p.next.id == node.id) {
				System.out.printf("node[%d]already exist!!!\n", node.id);
				return;
			}
			p = p.next;
		}
		
		
		if(p.next != null) {
			p.next.pre = node;
		}
		node.next = p.next;
		node.pre = p;
		p.next = node;
		
		
	}
	
	public void iter() {
		DoubleLinkNode p = head.next;
		while(p != null) {
			System.out.println(p.toString());
			p = p.next;
		}
	}
	
	
	public void update(DoubleLinkNode node) {
		DoubleLinkNode p = head;
		while(p.next != null && p.next.id != node.id) {
			p = p.next;
		}
		
		if(p.next == null) {
			System.out.println("no such node");
			return;
		}
		p.next.name = node.name;
		p.next.nickName = node.nickName;
	}
	
	public void del(int id) {
		DoubleLinkNode p = head.next;
		while(p != null && p.id != id) {
			p = p.next;
		}
		
		if(p == null) {
			System.out.println("no such node");
			return;
		}
		
		p.pre.next = p.next;
		if(p.next != null) {
			p.next.pre = p.pre;
		}
	}
	
}
