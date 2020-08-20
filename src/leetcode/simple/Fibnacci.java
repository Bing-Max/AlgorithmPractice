package leetcode.simple;

public class Fibnacci {

	/**
	 * 递归方式 -> 问题：递归的过程中会产生很多次的重复计算
	 * 
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n <= 2) {
			return 1;
		}

		return fib(n - 2) + fib(n - 1);
		
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int fib1(int n) {
		if(n == 0){
            return 0;
        }

        if(n <= 2){
            return 1;
        }

        int arr[] = new int[101];
            arr[0] = 0;
            arr[1] = 1;

        // 这道题在这里要求取余操作， 否则 45 46 大概会超出int 的最大值 21 亿多
        for(int i = 2; i < (n + 1); i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }

        return arr[n];
	}

}
