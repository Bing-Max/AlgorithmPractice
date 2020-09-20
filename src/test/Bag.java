package test;

import java.util.Scanner;

public class Bag {

	public static void main(String[] args) {
//		int N = 9;
//		int nums = 5;
//		int[] w = {2, 2, 4, 6, 3};
//		int[] v = {3, 4, 8, 9, 6};
		
//		System.out.println(getLargestVal(N, nums, w, v));
		
		Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int nums = sc.nextInt();
            int[] w = new int[nums];
            int[] v = new int[nums];
            for(int i = 0; i < nums; i++){
                w[i] = sc.nextInt();
            }
            
            for(int j = 0; j < nums; j++){
                v[j] = sc.nextInt();
            }	
            System.out.println(getLargestVal(N, nums, w, v));
        }

		
	}
	

	
//	int[][] val = new int[nums+1][N+1];
//	for(int i = 0; i < val.length; i++) {
//		val[i][0] = 0;
//	}
//	
//	for(int j = 0; j < val[0].length; j++) {
//		val[0][j] = 0;
//	}
//	
//	for(int i = 1; i < val.length; i++ ) {
//		for(int j = 1; j < val[0].length; j++) {
//			if(w[i - 1] > j) {
//				val[i][j] = val[i-1][j];
//			} else {
////				val[i][j] = Math.max(v[i - 1]+ val[i-1][j - w[i - 1]], val[i-1][j]);
//				if(v[i-1] + val[i-1][j -w[i-1]] > val[i-1][j]) {
//					val[i][j] = v[i-1] + val[i-1][j -w[i-1]];
//				}else {
//					val[i][j] = val[i-1][j];
//				}
//			}
//		}
//	}
//	
//	return val[nums][N];
	
	public static int getLargestVal(int N, int nums, int[] w, int[] v) {
		int[] d = new int[N+9];
		for (int i=0; i<nums; i++) {
			for (int j=N; j>=w[i]; j--) {
				d[j]=Math.max(d[j], d[j-w[i]]+v[i]);
			}
		}
		return d[N];
	}
	
	
}
