package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
	public static void main(String[] args) {
//		int arr[] = {3, 9, -1, 10, -2};
//		int arr[] = {-2, 3, 9, -1, 10};
//		
//		bubbleSort(arr);
//		
//		System.out.println(Arrays.toString(arr));
		
		int arr[] = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
		bubbleSort(arr);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());
		
		
	}
	
	public static void bubbleSort(int[] arr) {
		//用于交换的中介
		int temp;
		boolean flag = false;
		// 需要进行 n-1 轮的遍历-> 第一次只需要比较 n-1次，两两相邻就比完了
		// 一直到最后一次比较，只需要比较两个数，比较一次
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					flag = true;
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			
//			System.out.println(Arrays.toString(arr));
			//一轮执行结束，查看flag，看是否发生了交换
			if(!flag) {
				break;
			}else {
				//如果有交换发生，就重置flag
				flag = false;
			}
		}
	}

}
