package recursion;

import java.util.Arrays;

public class EightQueen {
	
	//用于存放棋子放置棋盘的位置
	private static int[] map = new int[8];
	private static int count = 0;
	
	public static void main(String[] args) {
		check(0);
		System.out.printf("all %d kinds solutions!", count);
	}
	
	/**
	 * 判断第n枚棋子目前的位置是否合适
	 * @param n
	 */
	public static boolean judge(int n) {
		// 对于之前的每一枚棋子都需要判断是否同一列，同一斜线
		for(int i = 0;  i < n; i++) {
			// 只要与某一棋子同一列，或同一斜线，则失败
			if(map[i] == map[n] || Math.abs(i - n) == Math.abs(map[i] - map[n])) {
				return false;
			}
		}
		
		return true;
	}
	
	//放置棋子递归函数
	public static void check(int n) {
		if(n == 8) {
			print();
			return;
		}
		
		// 如果没有到最后，那么每一枚棋子都尝试所有的列
		for(int i = 0; i < 8; i++) {
			// 棋子先放置在i这一列，第n枚棋子，处在n行
			map[n] = i;
			
			if(judge(n)) {
				// 如果该位置可行，那么继续放置下一枚棋子，向下递归
				check(n + 1);
				// 一直回溯到这里向下一位值移动，
				// 如果有解，输出结果然后移动棋子继续回溯与递归寻找下一解
				// 如果没解，回溯到这里，那么向下一个位置移动，向下递归，寻找解
			}
		}
		
	}

	public static void print() {
		count++;
		System.out.println(Arrays.toString(map));
	}
}
