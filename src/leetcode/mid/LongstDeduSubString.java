package leetcode.mid;

import java.util.HashMap;
import java.util.Map;

public class LongstDeduSubString {
	
	public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> curIndex = new HashMap<Character, Integer>();

        char[] chars = s.toCharArray();
        int maxLen = 0;
        int maxStart = 0;
        
        int curStart = 0;
        int curLen = 0;
        
        for(int i = 0; i < chars.length; i++) {
        	if(curIndex.containsKey(chars[i])&&curIndex.get(chars[i]) >= curStart){
                if(curLen > maxLen){
                    maxLen = curLen;
                    maxStart = curStart;
                }

                // 窗口滑动的关键，重新指定窗口的左侧为重复字符的右一位
                curStart = curIndex.get(chars[i]) + 1;
                // 更新窗口的宽度
                curLen = i - curStart + 1;
                continue;
            }else{
                curLen++;
            }
            // 更新位置
            curIndex.put(chars[i], i);
        }
        
        if(curLen > maxLen){
            maxLen = curLen;
            maxStart = curStart;
        }

        return maxLen;

        
    }

}
