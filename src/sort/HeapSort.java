package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
		
		int arr[] = new int[8000000];
		for(int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); //产生随机数
		}
		
		Date date1 = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formate.format(date1));
		heapSort(arr);
		
		Date date2 = new Date();
		System.out.println(formate.format(date2));
		System.out.println(date2.getTime() - date1.getTime());
	}
	
	public static void heapSort(int[] arr) {
		
		// 从第一个非叶子节点开始
		// 根据顺序话二叉树的操作，i-- ，  即实现该节点的前一节点的
		for(int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		
		for(int j = arr.length - 1; j > 0; j--) {
			// 将堆顶元素（下标为0） 与 堆的最后一个元素交换
			int temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			
			// 接下来只需要从顶元素向下堆排即可，因为下边的元素都是按大顶堆的方式进行的
			// 同时需要除去最后的最大的元素（即数组缩短）
			adjustHeap(arr,0, j);
			
		}
	}
	
	/**
	 * 
	 * @param arr 待调整的数组
	 * @param i	非叶子节点的下标
	 * @param length 数组的长度（待处理的长度）
	 */
	public static void adjustHeap(int[] arr, int i, int length) {
		
		// 记录下来非叶子节点的值
		int temp = arr[i];
		
		// 这里的前提在于我们在每次选定一个i 之后进行转换为大顶堆，确保其左右子树都是大顶堆的
		// 因为我们是可以规定从什么情况开始 -> 即规定从最后一个非叶子节点开始，向前进行堆排序
		// 又因为我们的堆的结构是完全二叉树
		for(int k = (2 * i + 1); k < length; k = (k * 2 +1)) {
			
			// 比较左右子节点的大小
			if(k + 1 < length && arr[k] < arr[k+1]) {
				k++;
			}
			
			// 大数放到顶堆上
			// 同时，我们也需要将相应的兑换后的树重新进行排序使之满足大顶堆的要求
			if(arr[k] > arr[i]) {
				arr[i] = arr[k];
				i = k;
			} else {
				// 否则，直接break 就好了
				// 提高效率
				break;
			}
			
			arr[i] = temp;
		}
	}

}
