package dynamic.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
	
	public static void main(String[] args) {
		
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		
		
		System.out.println(str1.toLowerCase());
		
		System.out.println((""+'A').toLowerCase());
//		
//		System.out.println(Arrays.toString(nextKMP(str2)));
//		System.out.println(kmpSearch(str1, str2));
	}
	
	public static int[] nextKMP(String s) {
		// 部分匹配表，表示s 的前缀，后缀相同子串的长度
		int len = s.length();
		int[] next = new int[len];
		
		for(int i = 1, j = 0; i < len; i++) {
			
			// 从next[j - 1] 获取新的j
			// KMP算法的核心点
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j-1];
			}
			// 有 
			if(s.charAt(i) == s.charAt(j)) {
				j++;
			}
			
			next[i] = j; 
		}
		
		return next;
		
	}
	
	/**
	 * 
	 * @param str1 字符串1
	 * @param str2 子串
	 * @return
	 */
	public static int kmpSearch(String str1, String str2) {
		
		str1.toLowerCase();
		// 获取部分匹配表
		int next[] = nextKMP(str2);
		
		int s1Len = str1.length();
		int s2Len = str2.length();
		
		for(int i = 0, j = 0; i < s1Len; i++ ) {
			
			// 如果不匹配，查看字符匹配表，j 向前移，（s1的后缀去匹配s2的前缀）
			while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			// 如果字符匹配，继续后移
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			
			// 匹配结束
			if(j == s2Len) {
				return i - j + 1;
			}
		}
		
		
		// 到最后都没找到，返回-1
		return -1;
	}

}
