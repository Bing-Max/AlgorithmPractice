package leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VocabularyCom {

	public static void main(String[] args) {
//		String[] strs = { "eat","tea","tan","ate","nat","bat" };
		String[] strs = {"hos","boo","nay","deb","wow","bop","bob","rrb","rbb","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"};
//		String[] strs = {"",""};
		
		System.out.println(groupAnagrams(strs).toString());
	}
	
	/**
	 * 1. map 存储每个词的map( 字母 count),  value 就是一个list，最后把List 存到一个List中
	 * @param strs
	 * @return
	 */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<String, Integer>, List<String>> rmap = new HashMap<Map<String, Integer>, List<String>>();
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        Map<String, Integer> counts = new HashMap();
        for(String s: strs){

            Map<String, Integer> countMap = new HashMap<String, Integer>();
            for(int i = 0; i < s.length(); i++){
                String subs =  s.substring(i, i+1);
                if(countMap.containsKey(subs)) {
                	Integer temp = countMap.get(subs);
                	countMap.put(subs, ++temp);
                } else {
                	countMap.put(subs, 1);
                }
            }
            if(rmap.containsKey(countMap)){
                rmap.get(countMap).add(s);
            }else{
                List<String> listTemp = new ArrayList();
                listTemp.add(s);
                rmap.put(countMap, listTemp);
            }
        }

        Set<Map<String, Integer>> keySet = rmap.keySet();
        Iterator<Map<String, Integer>> iterator = keySet.iterator();
        List<List<String>> list = new ArrayList();
        while(iterator.hasNext()){
            list.add(rmap.get(iterator.next()));
        }

        return list;
    }
    
    /**
     * 2.其他解法： 把每个字符串排序，然后相同的放到List中
     * 
     */
}
