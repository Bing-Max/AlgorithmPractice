package hashtable;

import java.util.Scanner;

public class HashTableDemo {
	
	public static void main(String[] args) {
		System.out.println("[add]  for add emp");
		System.out.println("[list]  for iter table");
		System.out.println("[find] for search");
		System.out.println("[exit]  for exit the program");
		HashTable hashTable = new HashTable(8);
		
		Scanner scanner = new Scanner(System.in);
		int id;
		while(true) {			
			String cmd = scanner.next();
			switch (cmd) {
			case "add":
				System.out.println("id:");
				id = scanner.nextInt();
				System.out.println("name:");
				String name = scanner.next();
//				System.out.println(name);
				hashTable.add(new Emp(id, name));
				break;
			case "list":
				hashTable.list();
				break;
			case "find":
				System.out.println("id:");
				id = scanner.nextInt();
				hashTable.findEmpById(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
		
	}

}

class HashTable{
	
	private EmpLinkedList[] empLinkedLists;
	private int size;
	
	public HashTable(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.empLinkedLists = new EmpLinkedList[size];
		
		// 很容易忘记导致nullPointerException
		for(int i = 0 ; i < size; i++) {
			this.empLinkedLists[i] = new EmpLinkedList();
		}
	}
	
	// 计算hash值
	public int hash(int i) {
		return i % size;
	}
	
	public void add(Emp emp) {
		
		this.empLinkedLists[hash(emp.id)].add(emp);
	
	}
	
	// 遍历
	public void list() {
		for(int i = 0; i < size; i++) {
			System.out.printf("第 %d :", i + 1);
			empLinkedLists[i].list();
		}
	}
	
	public void findEmpById(int id) {
		int empHashNo = hash(id);
		Emp emp = empLinkedLists[empHashNo].findEmpById(id);
		
		if(emp == null) {
			System.out.println("没有找到该雇员");
		} else {
			System.out.printf("在table [%d] 链表中找到了id为 %d 的雇员name: %s\n", empHashNo+1 , id, emp.name);
		}
		
	}
}

class Emp{
	public int id;
	public String name;
	public Emp next;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
		
}

class EmpLinkedList{
	// 头指针，直接指向第一个雇员
	private Emp head = null; // 默认为空
	
	// 添加雇员
	public void add(Emp emp) {
		if(head == null) {
			head = emp;
			return;
		}
		
		Emp cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		
		cur.next = emp;
		emp.next = null;
		
	}
	
	// 遍历
	public void list() {
	
		if(head == null) {
			System.out.println("null List");
			return;
		}
		
		Emp cur = head;
		while(cur != null) {
			System.out.printf("->%s", cur.toString());
			cur = cur.next;
		}
		System.out.println();
	}
	
	//
	public Emp findEmpById(int id) {
		Emp cur = this.head;
		while(cur != null) {
			if(cur.id == id) {
				return cur;
			}
			cur = cur.next;
		}
		
		return null;
	}
	
	
}
