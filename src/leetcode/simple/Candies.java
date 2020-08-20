package leetcode.simple;

import java.util.HashSet;
import java.util.Set;

public class Candies {
	
	public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i : candies){
            set.add(i);
        }

        return (set.size() > (candies.length / 2) ? candies.length/2 : set.size());
    }

}
