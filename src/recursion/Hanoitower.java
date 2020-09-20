package recursion;

public class Hanoitower {
	
	public static void main(String[] args) {
		hannoiTower(3, 'A', 'B', 'C');
	}
	
	/**
	 * 
	 * @param num 总共 num 个盘子
	 * @param a A 柱子
	 * @param b B 柱子
	 * @param c C 柱子
	 */
	public static void hannoiTower(int num, char a, char b, char c) {
		if(num == 1) {
			// 从A -> C
			System.out.println("plate:" + 1 +"  " +a + "->" + c);
			return;
		} else {
			
			// 上边的盘从A->B
			hannoiTower(num - 1, a, c, b);
			// A->C
			System.out.println("plate:" + num + " " + a + "->" + c);
			// B->C
			hannoiTower(num - 1, b, a, c);
		}
	}
}
