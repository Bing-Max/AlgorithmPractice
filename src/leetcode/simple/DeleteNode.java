package leetcode.simple;

import java.util.Arrays;

public class DeleteNode {

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */
	public void deleteNode(ListNode node) {
		// 删除下一个节点,替换这个节点
		node.val = node.next.val;
		if (node.next.next == null) {
			node.next = null;
			return;
		}
		node.next = node.next.next;

	}

	public static void main(String[] args) {
//		String[] datas = "1.1.1".split("\\.");
//		System.out.println(datas.length);
//		System.out.println("1.1.1".replaceAll("\\.", "[.]"));
//		DeleteNode n = new DeleteNode();
//		String r = n.addStrings("532", "9");
//		System.out.println(r);
	}
	

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
