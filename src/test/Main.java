package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[][] candies = new int[2][n];
			int index = 0;
			while(n > 0) {
				int num = sc.nextInt();
				int type = sc.nextInt();
				candies[type -1][index++] = num;
				n--;
			}		
			int[] res = mostCandies(candies[0], candies[1]);
			if(res[0] == -1) {
				System.out.println("null");
			}else {				
				System.out.printf("%d %d %d\n%d\n%d\n", res[2],res[3],res[4],res[0],res[1]);
			}
		}
		
		

	}
	
	public static int[] mostCandies(int[] red, int[] blue) {
		int[] res = new int[5];
		List<Integer> redList = new ArrayList();
		for(int i: red) {
			if(i != 0) {
				redList.add(i);
			}
		}
		List<Integer> blueList = new ArrayList<Integer>();
		for(int j : blue) {
			if(j != 0) {
				blueList.add(j);
			}
		}
		
		Collections.sort(redList);
		Collections.sort(blueList);
		
		int[] redRes = mostCandies(redList, red);
		int[] blueRes = mostCandies(blueList, blue);
		if(redRes[0] == -1 && blueRes[0] == -1) {
			res[0] = -1;
			return res;
		}
		
		if(redRes[0] == -1 && blueRes[0] != -1) {
			res = blueRes;
			res[0] = 2;
		}
		
		if(blueRes[0] == -1 && redRes[0] != -1) {
			res = redRes;
			res[0] = 1;
		}
		
		if(redRes[1] > blueRes[1]) {
			res = redRes;
			res[0] = 1;
			
		} else if(redRes[1] < blueRes[1]) {
			res = blueRes;
			res[0] = 2;
			
		} else {
			if(redRes[2] < blueRes[2]) {
				res = redRes;
				res[0] = 1;
				
			}else {
				res = blueRes;
				res[0] = 2;
			}
		}
		
		return res;
	}
	
	public static int[] mostCandies(List<Integer> list, int[] candies) {
		int[] res = new int[5];
		if(list.size() < 3) {
			res[0] = -1;
			return res;
		}
		int len = list.size();
		res[2] = list.get(len-1);
		res[3] = list.get(len-2);
		res[4] = list.get(len-3);
		
		res[1] = (res[2] + res[3] + res[4]);
		for(int i = 2; i < 5; i++) {
			for (int j = 0; j < candies.length; j++) {				
				if(candies[j] == res[i]) {
					res[i] = j+1;
					break;
				}
			}
		}
		
		
		Arrays.parallelSort(res, 2, 5);
		
		return res;
	}
    
	
}
