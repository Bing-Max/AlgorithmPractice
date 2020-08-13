package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	private static List<Integer> resList = new ArrayList<Integer>();

	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1000, 1234 };

//		System.out.println(binarySearch(arr, 0, arr.length -1 , 7));
//		System.out.println(binarySearch2(arr, 0, arr.length - 1, 88).toString());
		binarySearch3(arr, 0, arr.length - 1, 1000);
		System.out.println(resList.toString());
	}

	public static int binarySearch(int[] arr, int left, int right, int value) {
		// 结束递归的条件
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (value < midVal) {
			// 向左递归
			return binarySearch(arr, left, mid - 1, value);
		} else if (value > midVal) {
			// 向右递归
			return binarySearch(arr, mid + 1, right, value);
		} else {
			// 返回位置
			return mid;
		}
	}

	public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
		// 结束递归的条件
		if (left > right) {
			// 返回空列表，表示没找到
			return new ArrayList<Integer>();
		}

		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (value < midVal) {
			// 向左递归
			return binarySearch2(arr, left, mid - 1, value);
		} else if (value > midVal) {
			// 向右递归
			return binarySearch2(arr, mid + 1, right, value);
		} else {
			// 返回位置
			List<Integer> list = new ArrayList<Integer>();
			int temp = mid - 1;

			while (temp > -1 && arr[temp] == value) {
				list.add(0, temp--);
			}

			list.add(mid);

			temp = mid + 1;
			while (temp < arr.length && arr[temp] == value) {
				list.add(temp++);
			}

			return list;
		}
	}

	public static void binarySearch3(int[] arr, int left, int right, int value) {
		// 结束递归的条件
		if (left > right) {
			// 直接返回，说明不能继续向下寻找了
			return;
		}

		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (value < midVal) {
			// 向左递归
			binarySearch3(arr, left, mid - 1, value);
		} else if (value > midVal) {
			// 向右递归
			binarySearch3(arr, mid + 1, right, value);
		} else {
			/*
			 * 这里继续递归的原因在于我们不会因为缩小范围而丢失位置
			 * 因为我们每次向左，向右递归，第一次找到一个位置之前，那个位置一定不是这个值
			 * 保证了所有的值一定在我们第一次找到的值的左右范围中
			 */
			// 如果找到了对应位置，因该先左递归继续寻找
			binarySearch3(arr, left, mid - 1, value);
			// 每次遇到合适的值就添加到列表中
			resList.add(mid);
			// 然后向右递归继续寻找
			binarySearch3(arr, mid + 1, right, value);
		}
	}

}
