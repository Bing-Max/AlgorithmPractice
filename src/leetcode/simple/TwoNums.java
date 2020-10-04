package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

public class TwoNums {
	
	public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // 每次存放数据之前先判断是否已经有了对应的解，可以提前结束，而且避免了与自己相匹配。
        // 有相同值时，只匹配第一个出现的；
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            
            if(!map.containsKey(nums[i])){

                map.put(nums[i], i);
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;

    }

}
