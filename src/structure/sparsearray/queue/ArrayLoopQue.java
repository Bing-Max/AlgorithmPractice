package structure.sparsearray.queue;

public class ArrayLoopQue {

	private int maxSize;
	private int front;
	private int rear;
	
	private int[] vals;
	
	public ArrayLoopQue(int size) {
		// TODO Auto-generated constructor stub
		this.maxSize = size;
		this.vals = new int[size];
		// 队列头，指向队列头元素位置
		this.front = 0;
		//	队列尾，指向队列的最后一个元素的后一位置
		this.rear = 0;
	}
	
	public boolean isEmpty() {
		// 队列的头和尾指针中间空一个位置说明队列状态
		return this.front == this.rear;
	}
	
	public boolean isFull() {
		return (this.rear + 1) % maxSize == this.front;
	}
	
	public void add(int n) {
		if(! isFull()) {			
			this.vals[this.rear] = n;
			this.rear = (this.rear + 1) % maxSize;
		}else {
			System.out.println("the queue is full!!");
		}
	}
	
	public int get() {
		if( !isEmpty()) {
			int val = this.vals[front];
			this.front = (this.front + 1) % this.maxSize;
			return val;
		}else {
			throw new RuntimeException("empty queue !!");
		}
	}
	
	public int head() {
		if( !isEmpty()) {
			return this.vals[front];
		}else {
			throw new RuntimeException("empty queue !!");
		}
	}
	
	public void iterQue() {
		int i = 0;
		while((i + front) % maxSize != rear) {
			System.out.printf("vals[%d]: %d\n", i, vals[(i++ + front) % maxSize]);
		}
	}
}
