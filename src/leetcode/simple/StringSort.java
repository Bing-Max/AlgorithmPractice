package leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSort {
	
	public static void main(String[] args) {
		String[] strs = {"hello", "Abc", "xzg"};
		
		Arrays.sort(strs, 0, strs.length);
		System.out.println(Arrays.toString(strs));
		
		System.out.println(Integer.bitCount(-5));
	
	}

}
