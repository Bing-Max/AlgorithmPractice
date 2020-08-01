package leetcode;

public class GoodNumPairs {

	/**
	 * 给你一个整数数组 nums 。

	* 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

	* 返回好数对的数目。

	//来源：力扣（LeetCode）
	//链接：https://leetcode-cn.com/problems/number-of-good-pairs
	//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param nums
	 * @return
	 */
    public int numIdenticalPairs(int[] nums) {
        // int len = nums.length;
        // int count = 0;
        // for(int i = 0; i < len-1; i++ ){
        //     for(int j = i+1; j < len; j++ ){
        //         if(nums[i] == nums[j]){
        //             count ++;
        //         }
        //     }
        // }

        // return count;
        int[] temp = new int[101];
        for(int i:nums){
            ++temp[i];
        }
        int count=0;
        for(int i:temp){
            if(i==0){
                continue;
            }else{
                count+=(i*(i-1)/2);
            }
        }
        return count;
    }
}
