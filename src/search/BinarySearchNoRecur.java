package search;

public class BinarySearchNoRecur {

	public static void main(String[] args) {
		int arr[] = {0,1,2,3,4,5,6,7};
		System.out.println("index = "+ binarySearch(arr, -1));
		System.out.println("index = "+ binarySearchRecur(arr, 0, 7, 5));
	}
	
	/**
	 * 非递归方式
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {			
			int mid = (left + right) / 2 ;
			if(arr[mid] == target) {
				// 已找到
				return mid;
			}else if(arr[mid] > target) {
				right = mid - 1;
				
			}else {
				left = mid + 1;
			}
		}
		
		return -1;// 未找到
	}
	
	/**
	 * 递归方式
	 * @param arr
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	public static int binarySearchRecur(int[] arr, int left, int right ,int target) {
		if(left > right) {
			return -1;
		}
		int mid = (left + right) /2;
		if(arr[mid] == target) {
			return mid;
		} else if(target < arr[mid]) {
			return binarySearchRecur(arr, left, mid - 1, target);
		} else {
			return  binarySearchRecur(arr, mid + 1, right, target);
		}
	}
}
