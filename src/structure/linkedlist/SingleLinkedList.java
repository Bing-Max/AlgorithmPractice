package structure.linkedlist;

import java.util.Stack;

public class SingleLinkedList {
	
	private LinkNode head = new LinkNode();
	
	public SingleLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	public void addHead(LinkNode node) {
		node.next = this.head.next;
		this.head.next = node;
	}
	
	public void addTail(LinkNode node) {
		LinkNode p = this.head;
		while(p.next != null) {
			if(p.id == node.id) {
				System.out.println("该编号节点已存在!!");
				return;
			}
			p = p.next;
		}
		
		p.next = node;
		node.next = null;
	}
	
	public void addByOrder(LinkNode node) {
		LinkNode p = this.head;
		while(p.next != null) {
			if(p.next.id == node.id) {
				System.out.println("该编号节点已存在!!");
				return;
			}
			
			if(p.next.id > node.id) {
				break;
			}
			
			p = p.next;
		}
		
		node.next = p.next;
		p.next = node;
	}
	
	public void iter() {
		if(head.next == null) {
			System.out.println("null linkedList");
			return;
		}
		LinkNode p = head.next;
		while(p != null) {
			System.out.println(p.toString());
			p = p.next;
		}
	}
	
	public void delNode(int i) {
		if(head.next == null) {
			System.out.println("null linkedList");
			return;
		}
		
		LinkNode p = head;
		while(p.next != null && p.next.id != i) {
			p = p.next;
		}
		
		if(p.next == null) {
			System.out.println("该节点不存在");
		}else {
			p.next = p.next.next;
		}
	}
	
	
	public void reverseHeadInsert() {
		if(head.next == null) {
			System.out.println("null linkedlist");
			return;
		}
		LinkNode p = this.head.next;
		SingleLinkedList temp = new SingleLinkedList();
		while(p != null) {
			this.head = p;
			p = head.next;
			temp.addHead(this.head);
			System.out.println("插入一次：");
			temp.iter();
		}
		
		head.next = temp.head.next;
	}
	
	public void reverseIter() {
		Stack<LinkNode> stack = new Stack<LinkNode>();
		
		LinkNode p = head.next;
		while( p != null) {
			stack.push(p);
			p = p.next;
		}
		
		while( !stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public SingleLinkedList mergeByOrder(SingleLinkedList list) {
		SingleLinkedList res = new SingleLinkedList();
		
		LinkNode p1 = this.head.next;
		LinkNode p2 = list.head.next;
		
		while(p1 != null && p2 != null) {
			this.head = p1;
			list.head = p2;
			if(this.head.id < list.head.id) {
				p1 = this.head.next;
				res.addTail(head);
			}else {
				p2 = list.head.next;
				res.addTail(list.head);
			}
		}
		while(p1 != null) {
			this.head = p1;
			p1 = this.head.next;
			res.addTail(head);
		}
		
		while(p2 != null) {
			list.head = p2;
			p2 = list.head.next;
			res.addTail(list.head);
		}
		return res;
	}
}
