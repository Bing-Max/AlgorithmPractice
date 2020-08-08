package structure.sparsearray.linkedlist;

public class CircleSingleLinkedList {

	CircleNode first = null;

	public CircleSingleLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public void add(int nums) {
		if (nums < 1) {
			System.out.println("invalid nums !!!");
			return;
		}

		CircleNode index = new CircleNode();
		for (int i = 1; i <= nums; i++) {
			CircleNode node = new CircleNode(i);

			if (i == 1) {
				node.setNext(node);
				index = node;
				first = node;
			} else {
				node.setNext(index.getNext());
				index.setNext(node);
				index = index.getNext();
			}
		}
	}

	/**
	 * 
	 * @param nums     总数
	 * @param startNum 起始位置
	 * @param k        报数到k
	 */
	public void start(int nums, int startNum, int k) {
		this.add(nums);

		CircleNode helper = first;
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}

		for (int i = 1; i < startNum; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}

		// 开始游戏
		while (helper != first) {
			for (int i = 1; i < k; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}

			System.out.printf("Node[%d] out !!!\n", first.getVal());

			first = first.getNext();
			helper.setNext(first);
		}
		
		System.out.printf("The last node is [%d] \n", first.getVal());
	}
	
	public void iter() {
		CircleNode p = this.first;
		
		while(true) {
			System.out.println(p.toString());
			if(p.getNext() == first) {
				break;
			}
			
			p = p.getNext();
		}
	}

}

class CircleNode {
	private int val;
	private CircleNode next;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public CircleNode getNext() {
		return next;
	}

	public void setNext(CircleNode next) {
		this.next = next;
	}

	public CircleNode(int val) {
		super();
		this.val = val;
	}

	public CircleNode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CircleNode [val=" + val + "]";
	}

}
