package search;

public class SeqSearch {
	
	public static void main(String[] args) {
		
		int arr[] = {1,9,11,-1,34,89};
		
		int index = seqSearch(arr, -1);
		if(  index == -1) {
			System.out.println("没有找到");
		} else {
			System.out.printf("找到%d 的位置 %d", -1, index );
		}
		
	}
	
	/**
	 * 线性查找，遍历数组，只招一个位置即可，如果想找到所有位置，那么用集合或者数组进行记录返回
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] arr, int value) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	

}
