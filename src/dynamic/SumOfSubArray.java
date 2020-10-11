package dynamic;

public class SumOfSubArray {
	
	/**
	 * O(n) 时间内解决数组连续子数组求和的最大值。
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int len = nums.length;

        int[] dp = new int[len];
        int max = nums[0];
        for(int i = 0; i < len; i++){
            dp[i] = nums[i];
        }

        int j = 1;
        for(; j < len; j++){
            dp[j] = Math.max(dp[j-1] + dp[j], dp[j]);
            max = Math.max(dp[j], max);
        }

        return max;
    }

}
