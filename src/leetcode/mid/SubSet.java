package leetcode.mid;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSet {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = subsets(nums);
		for(List<Integer> temp : res) {
			System.out.println(temp.toString());
		}
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        list.add(new ArrayList<Integer>());
        for(int i : nums){
        	List<Integer> temp = new ArrayList<>();
        	temp.add(i);
            list.add(temp);
        }
        int count = 2;
        while(count <= nums.length){
        	List<List<Integer>> listTemp = new ArrayList<>();
            for(List<Integer> temp : list){
                if(temp.size() == count - 1){
                    Integer j = temp.get(count - 2);
                    for(int k = count - 1; k < nums.length; k++){
                        if(nums[k] > j){
                            List<Integer> swap = new ArrayList<Integer>();
                            swap.addAll(temp);
                            swap.add(nums[k]);
                            listTemp.add(swap);
                        }
                    }
                    
                }
            }
            list.addAll(listTemp);
            count++;
        }
        
        return list;
    }

}
