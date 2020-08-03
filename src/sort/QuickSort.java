package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = {-9,78,0,23,-567,70,0};
//		
//		quickSort(arr, 0, arr.length-1);
		
		int arr[] = new int[8000000];
		for(int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
		quickSort(arr, 0, arr.length-1);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		
		int leftIndex = left;
		int rightIndex = right;
		
		int pivot = arr[(left+right)/2];
		
		int temp;
		
		//接下来开始循环,只要左指针在右指针的左侧，就说明还没遍历完，可能还有元素没有按要求分布
		while(leftIndex < rightIndex) {
			
			// 左侧找到比pivot 大或者相等的数
			while(arr[leftIndex] < pivot) {
				leftIndex++;
			}
			
			//右侧找到比pivot 小或者相等，或者 就是pivot
			while(arr[rightIndex] > pivot) {
				rightIndex--;
			}
			if(leftIndex >= rightIndex) {
				break;
			}
			
			// 经过上述循环，找到两个值，这两个值需要交换位置
			temp = arr[leftIndex];
			arr[leftIndex] = arr[rightIndex];
			arr[rightIndex] = temp;
			
			//交换结束，如果两个数都没有到达中位，继续循环
			//如果左侧指针到达中位，说明刚才的置换，将中位数置换到右侧指针了
			//这里的主要作用是防止出现两个相同的数交换，之后进入死循环
			if(arr[rightIndex] == pivot) {
				leftIndex++;
			}
			
			if(arr[leftIndex] == pivot) {
				rightIndex--;
			}
		}
		
		//经过循环之后，我们把数组大致分成了比pivot小的， 比pivot大的
//		System.out.println(Arrays.toString(arr));
		
		//然后进行递归调用：左侧，右侧数组，到最后，左指针和右指针一定是都到了pivot的位置
		if(left < --leftIndex) {			
			quickSort(arr, left, leftIndex);
		}
		
		if(right > ++rightIndex) {			
			quickSort(arr, rightIndex, right);
		}
	}
}
