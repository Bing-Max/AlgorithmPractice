package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RedisSort {

	public static void main(String[] args) {
		int[] arr = {53,3,542,748,14,214};
		
		redisSort(arr);

//		int arr[] = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 产生随机数
//		}
//
//		Date date1 = new Date();
//		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(formate.format(date1));
//		int[] temp = new int[arr.length];
//		redisSort(arr);
//
//		Date date2 = new Date();
//		System.out.println(formate.format(date2));
//		System.out.println(date2.getTime() - date1.getTime());
	}

	public static void redisSort(int[] arr) {
		// 最大值，用于判断最大长度，即我们桶排序需要循环的次数
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int maxLength = (max + "").length();

		int[][] redis = new int[10][arr.length];
		int[] indexSize = new int[10];
		int index = 0;// 记录每个元素应该放置在哪个桶中
		int cor = 0;// 记录拷到数组的哪个位置
		// n 就是每次我们取的位
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

			// 循环遍历数组->将元素放置到对应位置上
			for (int j = 0; j < arr.length; j++) {
				index = arr[j] / n % 10;

				redis[index][indexSize[index]++] = arr[j];
			}

			cor = 0;
			// 全部都放到桶中，然后从桶里放回到数组
			for (int k = 0; k < 10; k++) {
				index = indexSize[k]; // 记录桶中元素个数
				while (indexSize[k] > 0) {
					// 将桶中的元素拷贝到原数组，并且拷贝一次，计数数组相应位置-1
					arr[cor++] = redis[k][index - (indexSize[k]--)];
				}
			}

			System.out.println(Arrays.toString(arr));
		}

	}
}
