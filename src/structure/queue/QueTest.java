package structure.queue;

import java.util.Scanner;

public class QueTest {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("please enter the len of que:");
		int size = sc.nextInt();
//		ArrayQue queue = new ArrayQue(size);
		ArrayLoopQue queue = new ArrayLoopQue(size);
		System.out.println("a(add): add element");
		System.out.println("g(get): get element");
		System.out.println("h(head): read head element(not pop)");
		System.out.println("i(iter): scaner the que");
		System.out.println("q(quit): quit the program");
//		System.out.println("n(new): new que");
		boolean loop = true;
		while(loop) {
//			System.out.println("please enter command:");
			String cmd = sc.nextLine();
			
			switch (cmd) {
			case "a":
				System.out.println("please enter a number");
				int n = sc.nextInt();
				queue.add(n);
				break;
			case "g":
				try {					
					System.out.printf("pop: %d\n",queue.get());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "h":	
				try {					
					System.out.printf("head: %d\n",queue.head());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "i":
				queue.iterQue();
				break;
			case "q":
				loop = false;
				break;

			default:
				break;
			}
		}
	}
}
