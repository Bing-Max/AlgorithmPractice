package leetcode.simple;

import java.util.List;

public class ReplaceString {

	/**
	 * 1. StringBuilder 比 StringBuffer 快而且占用空间少
	 * 2. 时间、空间 -> 直接字符串切割，占用空间最少，使用StringBuilder组装，但是用时较长
	 * 3. 占用空间较多，但是时间很少的 -> String.replace()
	 * 4. 下面的方法和第三种差不多
	 * 
	 * * 关于分割split的一点说明，一些转义字符 \t \n \\等，
	 * * .  |  也是转义字符，需要 \\. \\|进行匹配
	 * @param address
	 * @return
	 */
	public String defangIPaddr(String address) {
        int len = address.length();
        StringBuffer sub = new StringBuffer();
        for(int i = 0; i < len; i++){
            if(address.charAt(i) == '.'){

                sub.append("[.]");
            }else{
                sub.append(address.charAt(i));
            }
        }
        return sub.toString();
    }
}
