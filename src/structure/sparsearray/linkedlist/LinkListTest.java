package structure.sparsearray.linkedlist;

public class LinkListTest {
	
	public static void main(String[] args) {
		
//		test2();
		testJosephu();
	}
	public static void testJosephu() {
		CircleSingleLinkedList list = new CircleSingleLinkedList();
//		list.add(7);
//		list.iter();
		int nums = 5;
		int startNum = 2;
		int k = 3;
		
		System.out.printf("game start!!! total = %d, startIndex =  %d, k = %d \n", nums, startNum, k);
		
		list.start(nums, startNum, k);
	}
	
	public static void test2() {
		DoubleLinkedList list = new DoubleLinkedList();
		
		DoubleLinkNode node1 = new DoubleLinkNode(1, "宋江", "及时雨");
		DoubleLinkNode node2 = new DoubleLinkNode(2, "卢俊义", "玉麒麟");
		DoubleLinkNode node3 = new DoubleLinkNode(3, "吴用", "智多星");
		DoubleLinkNode node4 = new DoubleLinkNode(4, "公孙胜", "入云龙");
		
		list.add(node3);
		list.add(node1);
		list.add(node4);
		list.add(node4);
		list.add(node2);
		
//		list.addBySort(node3);
//		list.addBySort(node1);
//		list.addBySort(node4);
//		list.addBySort(node4);
//		list.addBySort(node2);
		
		list.iter();
		
		System.out.println("update ~~");
		list.update(new DoubleLinkNode(4, "林冲", "豹子头"));
		list.iter();
		
		System.out.println("del~~~");
		list.del(2);
		list.iter();
		
		System.out.println("del~~~");
		list.del(1);
		list.iter();
		
		System.out.println("del~~~");
		list.del(3);
		list.iter();
		
	}
	
	public static void test1() {
		SingleLinkedList list = new SingleLinkedList();
		
		LinkNode node1 = new LinkNode(1, "宋江", "及时雨");
		LinkNode node2 = new LinkNode(2, "卢俊义", "玉麒麟");
		LinkNode node3 = new LinkNode(3, "吴用", "智多星");
		LinkNode node4 = new LinkNode(4, "公孙胜", "入云龙");
		
//		list.addTail(node3);
//		list.addTail(node1);
//		list.addTail(node4);
//		list.addTail(node2);
//		
//		list.iter();
//		list.addTail(node4);
		
		
//		System.out.println("反向遍历");
//		list.reverseIter();
//		list.reverseHeadInsert();
//		
//		System.out.println("删除中间节点：");
//		list.delNode(2);
//		list.iter();
//
//		System.out.println("删除头节点：");
//		list.delNode(1);
//		list.iter();
//		
//		System.out.println("删除尾节点：");
//		list.delNode(4);
//		list.iter();
//		
//		list.delNode(2);
		
		System.out.println("list2: ");
		SingleLinkedList list2 = new SingleLinkedList();
		LinkNode node5 = new LinkNode(5, "林冲", "豹子头");
		LinkNode node6 = new LinkNode(6, "呼延灼", "双鞭");
		LinkNode node7 = new LinkNode(7, "张清", "没羽箭");
		LinkNode node8 = new LinkNode(8, "鲁智深", "花和尚");
		
		list.addByOrder(node8);
		list.addByOrder(node1);
		list.addByOrder(node1);
		list.addByOrder(node7);
		list.addByOrder(node2);
		list.iter();
		
		list2.addByOrder(node4);
		list2.addByOrder(node5);
		list2.addByOrder(node3);
		list2.addByOrder(node6);
		
		list2.iter();
		
		System.out.println("合并两有序链表");
		list.mergeByOrder(list2).iter();
	}

}
