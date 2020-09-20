package recursion;

import java.util.Arrays;

public class RecursionTest {
	
	public static void main(String[] args) {
		
//		test1(4);
		
		int map[][] = new int[8][7];
		
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		
		for(int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		
		map[1][2] = 1;
		map[2][2] = 1;
		map[2][3] = 1;
		map[3][3] = 1;
		map[4][1] = 1;
		map[4][2] = 1;
		map[4][3] = 1;
		
		map[6][5] = -1;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.printf("%d\t", map[i][j]);
			}
			System.out.println();
		}
		
		
		if(!setWay(map, 1, 1)) {
			System.out.println("no way!!!");
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.printf("%d\t", map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void test1(int num) {
		if(num > 2) {
			test1(num - 1);
		}
		
		System.out.println(num);
	}
	
	/**
	 * 移动顺序依次是 下，右，上，左,这里的策略可以修改，按照不同策略，路径不同，记录每种策略的步数，可以寻找最小路径
	 * @param map 地图，二维数组，数组中0 代表可走，1 代表墙（障碍）， 2 代表足迹，3 代表走过此路不通，-1代表出口
	 * @param i 起始位置的横坐标
	 * @param j 起始位置的纵坐标
	 */
	public static boolean setWay(int [][] map, int i, int j) {
		if(map[i][j] == -1) {
			System.out.println("win!!!");
			return true;
		} 
		
		if(map[i][j] == 0) {
			map[i][j] = 2;
			if(setWay(map, i+1, j)) {
				return true;
			}else if(setWay(map, i, j+1)) {
				return true;
			}else if(setWay(map, i - 1, j)) {
				return true;
			}else if(setWay(map, i, j - 1)) {
				return true;
			} else {
				
				// 走不通，那么就置为3，标识此路不通，返回false
				map[i][j] = 3;
				return false;
			}
		}else {
			// 改变不通，或者已经走过
			return false;
		}
	}

}
