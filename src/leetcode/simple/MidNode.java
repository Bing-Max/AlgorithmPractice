package leetcode.simple;

public class MidNode {

	/**
	 * 链表的中间节点-> 三种思路
	 */

	/**
	 * 1. 遍历两次，第一次确定链表的长度，第二次遍历到一半长度
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode1(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		p = head;
		for (int i = 0; i < len / 2; i++) {
			p = p.next;
		}

		return p;
	}

	/**
	 * 2. 快慢指针，快指针走两个，慢指针走一格 * 需要注意的是，快指针走两个的条件是要求快指针下一个节点不是空 ->
	 * 快指针停止的两种情况，快指针到到了链表的末尾或者到了链表末尾的下一个节点即null
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode2(ListNode head) {
		ListNode pSlow = head;
		ListNode pFast = head;
		while (pFast != null && pFast.next != null) {
			pFast = pFast.next.next;
			pSlow = pSlow.next;
		}

		return pSlow;
	}

	/**
	 * 3. 遍历一次，节点全部放入数组，最后直接 index / 2 找到对应的节点
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		ListNode[] nodes = new ListNode[100];
		int index = 0;
		while (head != null) {
			nodes[index++] = head;
			head = head.next;
		}

		return nodes[index / 2];
	}

}
