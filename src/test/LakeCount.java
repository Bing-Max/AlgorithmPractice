package test;

import java.util.Arrays;
import java.util.Scanner;

public class LakeCount {
	
	private static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.nextLine();
			String[] strs = str.split(",");
			
			int row = Integer.parseInt(strs[0]);
			int col = Integer.parseInt(strs[1]);
			
			char[][] map = new char[row][col];
			
			for(int i = 0; i < row; i++) {
				String line = sc.nextLine();
				char[] chars = line.toCharArray();
				for(int j = 0; j < col; j++) {
					map[i][j] = chars[j];
				}
//				map[i] = sc.nextLine().toCharArray();
//				sc.nextLine();
			}
			
			count = 0;
			for(int i =0; i < map.length; i++) {
				for(int j = 0; j < map[0].length; j++) {
					if(map[i][j] == 'S') {
						count++;
						mapSeek(map, i, j);
					}
				}
			}
			
			System.out.println(count);
		}
//		char[][]map = {
//				{'S','S','H','H','H'},
//				{'S','S','H','H','H'},
//				{'H','H','S','H','H'},
//				{'H','H','H','S','S'}
//		};
//		for(int i = 0; i < 4; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
		
	}
	
	// 走迷宫，设定起点，最后回溯到自身，那就说明封闭，走不到，走过的区域标记为走不通
	
	public static boolean mapSeek(char[][] map, int i, int j) {
		// 只要是邻接的S，就可走，走过之后标识为已走，若无路可走，回溯，直到把所有的邻接S都走完，标为此路不通，结束
		// T 代表足迹
		// F 代表此路走不通
//		map[i][j] = 'T';
		if(map[i][j] == 'S') {
			map[i][j] = 'T';
			if((i+1) < map.length && mapSeek(map, i+1, j)) {
				return true;
			}else if((j+1) < map[0].length &&mapSeek(map, i, j+1)) {
				return true;
			}else if((i -1) > 0 && mapSeek(map, i - 1, j)) {
				return true;
			}else if((j-1) >0 && mapSeek(map, i, j - 1)) {
				return true;
			} else {
				
				// 走不通，那么就置为3，标识此路不通，返回false
				map[i][j] = 'F';
				return false;
			}
		}else {
			// 改变不通，或者已经走过
			return false;
		}
	}

}
