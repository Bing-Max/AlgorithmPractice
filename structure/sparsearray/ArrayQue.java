package structure.sparsearray;

import javax.management.RuntimeErrorException;

public class ArrayQue {

	private int maxSize;
	private int front;
	private int rear;
	
	private int[] vals;
	
	public ArrayQue(int size) {
		// TODO Auto-generated constructor stub
		this.maxSize = size;
		this.vals = new int[size];
		// 队列头，指向队列头元素的前一个位置
		this.front = -1;
		//	队列尾，指向队列的最后一个元素
		this.rear = -1;
	}
	
	public void add(int n) {
		// 进队列
		if(!isFull()) {
			vals[++rear] = n;
		}else {
			System.out.println("队列已满");
		}
	}
	
	public int get() {
		// 出队列
		if(!isEmpty()) {
			return vals[++front];
		}else {
			throw new RuntimeException("null queue!!!");
		}
	}
	
	public int head() {
		// 查看队列头元素，不出队列
		if(!isEmpty()) {
			return vals[front + 1];
		}else {
			throw new RuntimeException("null que");
		}
	}
	
	public boolean isEmpty() {
		return this.rear == this.front;
	}
	
	public boolean isFull() {
		return this.rear == this.maxSize-1;			
	}
	
	public void iterQue() {
		for(int i = front+1; i <= rear; i++ ) {
			System.out.printf("val[%d]: %d\n", i, vals[i]);
		}
	}
}
