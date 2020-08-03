package structure.sparsearray.linkedlist;

public class LinkListTest {
	
	public static void main(String[] args) {
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
