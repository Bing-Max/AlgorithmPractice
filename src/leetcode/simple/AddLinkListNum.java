package leetcode.simple;

public class AddLinkListNum {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode ps = res;
        int temp = 0;
        while(l1 != null && l2 != null){
            ListNode n = new ListNode();
            n.val = (l1.val + l2.val + temp) % 10;
            temp = (l1.val + l2.val + temp) / 10;
            ps.next = n;
            ps = ps.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while( l1 != null ){
            ListNode n = new ListNode();
            n.val = (l1.val +temp) % 10;
            temp = (l1.val + temp) / 10;
            ps.next = n;
            ps = ps.next;
            l1 = l1.next;
        }

        while( l2 != null ){
            ListNode n = new ListNode();
            n.val = (l2.val +temp) % 10;
            temp = (l2.val + temp) / 10;
            ps.next = n;
            ps = ps.next;
            l2 = l2.next;
        }

        if(temp != 0){
            ListNode n = new ListNode(temp);
            ps.next = n;
            ps.next.next = null;
        }
        return res.next;

    }

}
