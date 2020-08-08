package leetcode.simple;

public class LongPrefix {

	public static void main(String[] args) {
		String s = "hellio";
		System.out.println(s.substring(0, 5));
	}

	public String longestCommonPrefix(String[] strs) {
		if (!(strs.length > 0)) {
			return "";
		}
		int index = 0;
		String prefix;
		for (int i = 0; i < strs[0].length(); i++) {
			prefix = strs[0].substring(0, i + 1);
			index = i + 1;
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() < index || !strs[j].substring(0, i + 1).equals(prefix)) {
					return strs[0].substring(0, index - 1);
				}
			}

		}

		return strs[0].substring(0, index);
	}

}
