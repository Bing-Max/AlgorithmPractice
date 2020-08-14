package search;

import java.util.Arrays;

public class FibonacciSearch {
	private static int maxsize = 20;

	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1001 ,1234 };
		
//		System.out.println(Arrays.toString(fib()));
		System.out.println(fibSearch(arr, 1234));
	}
	
	public static int[] fib() {
		int[] arr = new int[maxsize];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2 ; i < maxsize; i++ ) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr;
	}
	
	public static int fibSearch(int arr[], int val) {
		
		int low = 0;
		
		int high = arr.length;
		int f[] = fib();
		int index = 1;
		// 一直找到第一大于等于原数组长度的斐波那契数列的数
		while(high > f[index]) {
			index++;
		}
		
		// 对数组进行扩容
		int a[] = Arrays.copyOf(arr, f[index] - 1);
		for(int i = high; i < a.length; i++) {
			a[i] = a[high - 1];
		}
		
		high = f[index] -1;
		// 判断循环结束的条件
		while(low <= high) {
			int mid = low + f[index - 1] - 1;
			
			if(val > a[mid]) {// 向右寻找
				// low 向右移一位
				low = mid + 1;
				// k -= 2;
				// 原因在于 f[k] = f[k - 1] + f[k-2];
				index -= 2;
			} else if(val < a[mid]) {// 向左寻找
				
				// 向左寻找则low 不变， index -1 即可完成寻找
				index--;
				high = mid -1;
			} else {
				// 最后，应该找到了对应的值
				// 判断mid 是否超出了arr.length - 1;
				return mid > (arr.length - 1) ? (arr.length -1) : mid;
			}
		}
		
		// 如果找不到， 最后返回 -1 
		return -1;
	}

}
