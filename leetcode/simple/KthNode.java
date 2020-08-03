package leetcode.simple;

public class KthNode {
	/**
	 * 单向链表的倒数第k 个节点
	 * 整体来说 单个指针比两个指针内存使用少
	 * 但是同一段代码执行，leetcode 的内存有一定波动，但是基本相差不是很明显，所以使用leetcode 比较内存消息消耗差别较少时要注意
	 */
    public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while(p!= null){
            count++;
            p = p.next;
        }

        p = head;
        count  = count - k;
        while(count > 0){
            p = p.next;
            count--;
        }

        return p.val;
    }
    
    /**
     * 两个指针一起跑
     */
//    public int kthToLast(ListNode head, int k) {
//        ListNode p = head;
//        for(int i=0;i<k;i++){
//          p = p.next;  
//        }
//
//        while(p != null){
//            p = p.next;
//            head = head.next;
//        }
//
//        return head.val;
//    }
//    
    

}
