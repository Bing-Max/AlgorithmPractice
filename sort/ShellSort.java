package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
//
//		shellSwapSort(arr);
//		shellInsertSort(arr);
		int arr[] = new int[8000000];
		for(int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
//		shellSwapSort(arr);
		shellInsertSort(arr);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());
	}

	public static void shellSwapSort(int[] arr) {
		// 用于交换存放临时值
		int temp;

		// 设定步长
		// 希尔排序一种思路就是每次步长减半
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {// 步长要求大于0，1 / 2 = 0--> 步长为1排序之后就结束了
			// 一下采用交换的思路解决
			// 外层循环需要保证每个按照步长划分的数组元素都參與插值
			for (int i = gap; i < arr.length; i++) {
				// 設定好插入的邊界，也就是插入的最前邊的位置
				// 交換若兩值逆序，則交換，保證順序
				for (int j = i; j >= gap; j -= gap) {
					if (arr[j] < arr[j - gap]) {
						temp = arr[j];
						arr[j] = arr[j - gap];
						arr[j - gap] = temp;
					}
				}
			}

			// 打印每次定步長數組排序之後的内容
			System.out.println(Arrays.toString(arr));
		}

		//
	}
	
	
	public static void shellInsertSort(int[] arr) {
		// 待插入的值
		int insertVal;
		//判断待插入的位置
		int insertIndex;
		
		// 设定步长
		// 希尔排序一种思路就是每次步长减半
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {// 步长要求大于0，1 / 2 = 0--> 步长为1排序之后就结束了
			// 一下采用交换的思路解决
			// 外层循环需要保证每个按照步长划分的数组元素都参与插值
			for (int i = gap; i < arr.length; i++) {
				insertVal = arr[i];
				// 往前找一位
				insertIndex = i - gap;
				while (insertIndex >= 0 && arr[insertIndex] > insertVal) {// 只要它前‘一个’值比他大,他前面的值就后移
					arr[insertIndex + gap] = arr[insertIndex];
					insertIndex -= gap;
				}
				insertIndex += gap;
				if (arr[insertIndex] != insertVal) {
					arr[insertIndex] = insertVal;
				}
			}

			// 打印每次定步長數組排序之後的内容
//			System.out.println(Arrays.toString(arr));
		}

	}

}
