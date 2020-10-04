package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class SetCover {
	
	
	public static void main(String[] args) {
		
		// 案例：
		Map<String, HashSet<String>> boradcasts = new HashMap<String, HashSet<String>>();
		
		HashSet<String> set1 = new HashSet<String>();
		set1.add("北京");
		set1.add("上海");
		set1.add("天津");
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("北京");
		set2.add("广州");
		set2.add("深圳");
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("成都");
		set3.add("杭州");
		set3.add("上海");
		
		HashSet<String> set4 = new HashSet<String>();
		set4.add("天津");
		set4.add("上海");
		
		HashSet<String> set5 = new HashSet<String>();
		set5.add("杭州");
		set5.add("大连");
		
		boradcasts.put("K1", set1);
		boradcasts.put("K2", set2);
		boradcasts.put("K3", set3);
		boradcasts.put("K4", set4);
		boradcasts.put("K5", set5);
		
		
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.addAll(set1);
		allAreas.addAll(set2);
		allAreas.addAll(set3);
		allAreas.addAll(set4);
		allAreas.addAll(set5);
		
		ArrayList<String> selects = new ArrayList<String>();
		String maxKey = null; 
		int maxSize = 0; // 不重复元素集合的最大的size
		
		while(!allAreas.isEmpty()) {			
			for(String key : boradcasts.keySet()) {
				
				HashSet<String> temp = new HashSet<String>();
				temp.addAll(boradcasts.get(key));
				temp.retainAll(allAreas);	//取交集，allAreas 不断remove 加入的元素
				if(!temp.isEmpty() && (maxKey == null || maxSize < temp.size())) {
					maxKey = key;
					maxSize = temp.size();
				}
			}
			if(maxKey != null && boradcasts.get(maxKey)!= null) {
				selects.add(maxKey);
				allAreas.removeAll(boradcasts.get(maxKey));
				maxSize = 0;
				maxKey = null;
				
			}
		}
		
		System.out.println(selects.toString());
		
	}

}
