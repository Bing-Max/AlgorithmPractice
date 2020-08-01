package leetcode;

public class ReverseLeftWords {

	/**
	 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

	 *	来源：力扣（LeetCode）
	 *	链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
	 *	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
    public String reverseLeftWords(String s, int n) {
    	//1. 
        // char[] vals =s.toCharArray();
        
    	// char[] head = s.substring(0, n).toCharArray();
    	
    	// for(int i = 0; i < vals.length - n; i++ ) {
    	// 	vals[i] = vals[i + n];
    	// }
    	// for(int j = 0; j < n; j++ ) {
    	// 	vals[j + vals.length - n] = head[j];
    	// }

        // return String.valueOf(vals);

    	// 2. 
        // StringBuilder sub = new StringBuilder(s.substring(n));

        // sub.append(s.substring(0,n));

        // return sub.toString();

    	// 3. 
        // return s.substring(n) + s.substring(0,n);
    	
    	// 4. 内存占用最少
        int len = s.length();
        char[] v = s.toCharArray();
        char[] vals = new char[len];
        for(int i = 0; i < len; i++){
            vals[i] = v[(n+i)%len];
        }
        
        return vals.toString();
    }
}
