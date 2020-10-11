package leetcode.mid;

import java.util.Arrays;

public class PartitionJudge {
	
	// 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
	
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }else{
            Arrays.sort(nums);
            return canSum(sum/2, nums);
        }
    }

    public boolean canSum(int target, int[] nums){

        if(nums[nums.length - 1] == target){
            return true;
        }
        int max = 0;
        if(nums[nums.length - 1] < target){
            boolean[] vals = new boolean[target + 9];

            for(int i = 0; i < nums.length; i++){
                for(int j = max; j > -1; j--){
                    if(vals[j] && (j + nums[i]) <= target){
                        vals[j + nums[i]] = true;
                        max = Math.max(max, j+nums[i]);
                    }
                }
                vals[nums[i]] = true;
                max = Math.max(max, nums[i]);
            }

            return vals[target];
        }

        return false;
    }

}
