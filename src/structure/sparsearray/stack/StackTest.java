package structure.sparsearray.stack;

import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) {
		System.out.println("enter the maxSize please:");
		Scanner sc = new Scanner(System.in);
		int maxSize = sc.nextInt();
		
		ArrayStack stack = new ArrayStack(maxSize);
		boolean loop = true;
		while(loop) {
			String cmd = sc.nextLine();
			
			switch (cmd) {
			case "help":
				System.out.println("show : show all elements in stack");
				System.out.println("push : push element");
				System.out.println("pop : pop element");
				System.out.println("exit : exit this program");
				break;
			case "show":
				stack.show();
				break;
			case "push":
				System.out.println("enter a number:");
				int val = sc.nextInt();
				try {
					stack.push(val);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "pop":
				try {
					System.out.printf("pop the element: %d\n", stack.pop());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				sc.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}
