package leetcode.mid;

import leetcode.ListNode;

public class PairSwapLinkedList {
	
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode nextNode, fast, slow, newHead, cur;
        slow = head;
        newHead = nextNode = fast = slow.next;
        cur = fast.next;
        fast.next = slow;
        nextNode = slow;
        while(true){
            // 下一个slow
            if(cur == null){
                nextNode.next = null;
                
                return newHead;
            }
            slow = cur;
            // 下一个fast
            if(slow.next == null){
                nextNode.next = slow;
                return newHead;
            }
            fast = slow.next;

            nextNode.next = fast;
            cur = fast.next;
            fast.next = slow;
            nextNode = slow;
        }

    }
	
	public static void main(String[] args) {
		PairSwapLinkedList head = new PairSwapLinkedList();
		
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		ListNode node = head.swapPairs(node1);
		while(node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		
	}

}
