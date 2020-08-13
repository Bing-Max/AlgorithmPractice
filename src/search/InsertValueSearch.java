package search;

public class InsertValueSearch {
	
	public static void main(String[] args) {
		int arr[] = new int[100];
		
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		System.out.println(insertValueSearch(arr, 0, arr.length - 1, 25));
	}
	
	/**
	 * 要求数组有序，连续
	 * @param arr 传入的数组
	 * @param left 左索引
	 * @param right 右索引
 	 * @param val 值
	 * @return
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int val) {
		System.out.println("hello~");
		//arr[0] > val || arr[arr.length - 1] < val 不仅是优化
		//同时也是必须的，否则会导致数组越界
		if(left > right || arr[0] > val || arr[arr.length - 1] < val ) {
			return -1;
		}
		
		int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
		int temp = arr[mid];
		
		if(temp > val) {
			//向左递归
			return insertValueSearch(arr, left, mid - 1, val);
		}else if( temp < val) {
			//向右递归
			return insertValueSearch(arr, mid + 1, right, val);
		}else {
			return mid;
		}
	}

}
