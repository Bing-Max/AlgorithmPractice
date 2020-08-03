package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
//		int[] temp = new int[arr.length];
//		mergeSort(arr, 0, arr.length - 1, temp);
		
		int arr[] = new int[800000];
		for(int i = 0; i < 800000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());

	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {

		//提供跳出递归的条件，即分到最小单位就不能进行归并，返回上一级处理，开始合并，合并结束后，再向上返回以及合并
		if (left < right) {
			mergeSort(arr, left, (left + right) / 2, temp);

			// 中值要+1， 因为中值已经计算到前边的数组中了
			mergeSort(arr, (left + right) / 2 + 1, right, temp);

			//左侧，右侧数组处理完毕，开始合并
			merge(arr, left, right, temp);
		}
	}

	/**
	 * 合并的过程
	 * 
	 * @param arr   待归并的数组
	 * @param left  待归并数组的左数组的索引
	 * @param mid   待归并数组的右数组的索引
	 * @param right 待归并数组的最右边界
	 * @param temp  中间用于转换的数组
	 */
	public static void merge(int[] arr, int left, int right, int[] temp) {
		int leftIndex = left;
		int mid = (left + right) / 2;
		int rightIndex = mid + 1;

		// 记录temp数组目前填充的位置
		int tempIndex = 0;

		// 跳出循环的条件是有一个数组已经填充完毕
		while (leftIndex <= mid && rightIndex <= right) {
			// 填充到temp数组中

			if (arr[leftIndex] <= arr[rightIndex]) {
				temp[tempIndex++] = arr[leftIndex++];
			} else {
				temp[tempIndex++] = arr[rightIndex++];
			}

		}

		// 左边数组有剩余
		while (leftIndex <= mid) {
			temp[tempIndex++] = arr[leftIndex++];
		}

		// 右边数组有剩余
		while (rightIndex <= right) {
			temp[tempIndex++] = arr[rightIndex++];
		}

		tempIndex--;
		// temp数组向回拷贝：
		for (; tempIndex >= 0; tempIndex--) {
			arr[left + tempIndex] = temp[tempIndex];
		}

//		System.out.println(Arrays.toString(arr));
	}
}
