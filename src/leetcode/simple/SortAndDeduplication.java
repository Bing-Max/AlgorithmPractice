package leetcode.simple;

import java.util.Arrays;
import java.util.Scanner;

public class SortAndDeduplication {
	
	/**
	 * 一种比较好的思路：
	 * 	因为题目中说到 n <= 1000, 可以用数组的下标代替数组元素，boolean 数组说明是否有这个元素
	 * 	最后遍历数组，输出所有的index，即可实现去重与排序
	 * @param args
	 */
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            boolean[] arr = new boolean[1001];
            while(n > 0){
                int index = sc.nextInt();
                arr[index] = true;
                n--;
            }
            for(int i = 0; i < arr.length; i++){
                if(arr[i]){
                    System.out.println(i);
                }
            }
        }
    }
    
	/**
	 * 排序方式：
	 * 几种常见的排序方法
	 * 去重可以
	 * @param arr
	 * @return
	 */
    public static int[] sort(int[] arr){
        Arrays.sort(arr);
        int[] res = new int[arr.length];
        int index = 0;
        res[index] = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != res[index]){
                res[++index] = arr[i];
            }
        }
        return Arrays.copyOfRange(res, 0, index + 1);
    }

}
