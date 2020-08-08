package structure.sparsearray.stack;

public class ArrayStack {
	
	private int maxSize;
	private int[] vals;
	
	private int top;
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
	}

	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.vals = new int[maxSize]; 
		this.top = -1;
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == maxSize - 1;
	}
	
	public void push(int val) {
		if(!isFull()) {
			this.vals[++top] = val;
		}else {
			throw new RuntimeException("stack is already full!");
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		
		return this.vals[top--];
	}
	
	public void show() {
		if(isEmpty()) {
			System.out.println("Empty stack");
			return;
		}
		
		for(int i = top ; i >= 0; i--) {
			System.out.printf("index[%d]: %d\n", i, vals[i]);
		}
	}

}
