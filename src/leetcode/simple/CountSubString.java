package leetcode.simple;

public class CountSubString {
	/**
	 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

	 * 重复出现的子串要计算它们出现的次数。

 	 *	来源：力扣（LeetCode）
	 *	链接：https://leetcode-cn.com/problems/count-binary-substrings
	 *	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param s
	 * @return
	 */
	
    public int countBinarySubstrings(String s) {
        if(s == null || s.equals("")){
            return 1;
        }

        int[] counts = new int[s.length()];
        int count = 0;
        int index = 0;
        char flag = s.charAt(0);
        for(int i = 0; i < counts.length; i++){
            if(s.charAt(i) == flag){
                count++;
            }

            if(s.charAt(i) != flag){
                flag = s.charAt(i);
                counts[index++] = count;
                count = 1;
            }
        }    
        counts[index++] = count;

        count = 0;
        for(int i = 0; i < index-1; i++){
            count += (counts[i] <= counts[i+1] ? counts[i] : counts[i+1]);
        }  

        return count;
    }

}
