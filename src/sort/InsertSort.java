package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
//		int[] arr = {101, 34, 119, 1, 56};
//		insertSort(arr);
		
		int arr[] = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
		insertSort(arr);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());
	}
	
	public static void insertSort(int[] arr) {
		
		// 先将待插入到前边有序组的元素取出来
		int insertVal;
		//待插入位置
		int insertIndex;
		
		for(int i = 1; i < arr.length ;i++) {//第一次分割整个数组，有序表中只有第一元素，从位置1的元素开始往前差
			insertVal = arr[i];
			// 从他前一个元素开始找，找到第一个比他小的元素的位置，插在该元素后边，若没有这样的元素，那么就是插在0 这个位置
			insertIndex = i - 1;
			
			// 帮助待插入的元素找到属于他的位置
			// 只要位置上的数字比待插入的元素大，就把这个位置上的数字往后移
			while(insertIndex >= 0 && arr[insertIndex] > insertVal) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			
			//当待插入的位置不等于我们取出来的元素的位置时才将该元素插入到该位置上
			//但是当我们经过了上面的循环，我们找到的位置比真正的位置往前偏了一位
			//最简单的理解就是：没有经过循环，当前位置就是应该插入的位置。
			if(++insertIndex != i) {
				arr[insertIndex] = insertVal;
			}
			
//			System.out.println(Arrays.toString(arr));
		}
	}
}
