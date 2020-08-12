package structure.sparsearray.stack.calculate;

public class OperatorStack {
	
	private int maxSize;
	private int[] vals;
	
	private int top;
	
	public OperatorStack() {
		// TODO Auto-generated constructor stub
	}

	public OperatorStack(int maxSize) {
		// TODO Auto-generated constructor stub
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
	
	public int peak() {
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		
		return this.vals[top];
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
	
	public int priority(char opr) {
		switch(opr) {
		case '*':
			return 1;
		case '/':
			return 1;
		case '+':
			return 0;
		case '-':
			return 0;
		default:
			break;
		}
		return -1;
	}
	
	public boolean isOptr(char val) {
		return ( val == '+' || val =='-' || val == '*' || val == '/');
	}
	
	public int calculate(int num1, int num2, char opr) {
		switch(opr) {
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		default:
			break;
		}
		
		throw new RuntimeException("undefined opr!");
	}

}
