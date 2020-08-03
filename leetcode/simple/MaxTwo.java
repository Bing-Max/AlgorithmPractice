package leetcode.simple;

public class MaxTwo {
	
	/**
	 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

	 * 请你计算并返回该式的最大值。
	 * 简单来说就是找数组中最大的两个值
	 */
	
	/**
	 * 我的方法是2n， 冒泡排序的一部分
	 * @param nums
	 * @return
	 */
    public int maxProduct(int[] nums) {
        partsort(nums);
        int len = nums.length;
        return (nums[len-1] - 1) * (nums[len-2] - 1);
    }

    public void partsort(int[]nums){
        int temp = 0;
        for(int j = 1; j < 3; j++){
            for(int i = 0; i < nums.length-j; i++ ){
                if(nums[i] > nums[i+1]){
                    temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
    
    /**
     * 更好的方法是连个指针，遇到大数时，替换到小的那个数
     * js 中也可以利用短路操作进行简化
     */
//    public int maxProduct(int[] nums) {
//        int a = nums[0];
//        int b = nums[1];
//
//        for(int i = 2; i < nums.length; i++){
//            if(a > b){
//                b = b > nums[i] ? b : nums[i];
//            }else{
//                a = a > nums[i] ? a : nums[i];
//            }
//        }
//
//        return ( a - 1 ) * ( b - 1 );
//     }

}
