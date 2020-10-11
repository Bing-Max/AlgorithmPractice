package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = search(nums, 0, 0, 3);
		return list;
	}

	public List<List<Integer>> search(int[] nums, int start, int target, int count) {
		if (start >= nums.length) {
			return new ArrayList();
		}

		List<List<Integer>> list = new ArrayList();
		if (count > 2) {
			for (int i = start; i < nums.length - 1; i++) {
				int next = i + 1;
				List<List<Integer>> resTemp = search(nums, next, target - nums[i], count - 1);
				if (!resTemp.isEmpty()) {
					for (List temp : resTemp) {
						temp.add(0, nums[i]);
					}
					list.addAll(resTemp);
				}

				while (i < nums.length - 1 && nums[i] == nums[++i])
					;
				i--;
			}
		} else if (count == 2) {
			int front, tail;
			front = start;
			tail = nums.length - 1;
			while (front < tail) {
				if (nums[front] + nums[tail] == target) {
					List<Integer> temp = new ArrayList();
					temp.add(nums[front]);
					temp.add(nums[tail]);
					list.add(temp);

					while (front < tail && nums[front] == nums[++front])
						;
					while (tail > front && nums[tail] == nums[--tail])
						;
				} else if (nums[front] + nums[tail] > target) {
					while (tail > front && nums[tail] == nums[--tail])
						;
				} else {
					while (front < tail && nums[front] == nums[++front])
						;
				}
			}
		}

		return list;
	}

}
