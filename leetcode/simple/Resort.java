package leetcode.simple;

import java.util.Arrays;
import java.util.List;

public class Resort {
	
	public int[] shuffle(int[] nums, int n) {
		int[] swap = Arrays.copyOfRange(nums, 0, n);
		
		for(int i = 0; i < n; i++) {
			nums[2*i] = swap[i];
			nums[2*i+1] = nums[n+i];
		}
		
		
		return nums;
	}

}
