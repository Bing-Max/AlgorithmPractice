package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
//		int[] arr = {101, 34, 119, 1};
//		
//		selectSort(arr);
		
		int arr[] = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
		selectSort(arr);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());
	}
	
	public static void selectSort(int[] arr) {
		
		//数组最小值的位置
		int minIndex = 0;
		// 用于交换的数
		int temp;
		
		//需要进行n-1轮，最后一轮交换玩之后只剩一个数，不再需要新一轮
		for(int i = 0; i < arr.length-1; i++) {
			//‘哨兵’-> 每次需要交换的位置  i
			minIndex = i;
			// 这里需要从 i 后一位 到数组末尾都遍历到，才能找到最小值
			for(int j = i + 1; j < arr.length; j++) {
				// 找到比当前认为的最小值 小的值,替换认为的最小值的位置
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			//每一轮遍历完成之后，交换最小值和当前的哨兵，哨兵后移
			if(minIndex != i) {
				temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
			
//			System.out.println(Arrays.toString(arr));
		}
		
	}
}
