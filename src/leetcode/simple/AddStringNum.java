package leetcode.simple;

public class AddStringNum {
	
	/**
	 * 直接利用char - '0' 得到数字，效率不如switch() 选择表 效率高
	 */	
	/**
	 * 数字强转 char ->  '0' + 5 -> '5'  -> 转换占用的内存变少了
	 */
//    public String addStrings(String num1, String num2) {
//        char[] numcs ;
//        char[] numcs1 = num1.toCharArray();
//        char[] numcs2 = num2.toCharArray();
//        int len1 = num1.length();
//        int len2 = num2.length();
//        int temp = 0;
//        int swap = 0;
//        if(len1 > len2){
//            int i = 1;
//            numcs = new char[len1];
//            for(; i <= len2; i++){
//                swap = (numcs1[len1 - i] - '0') + ( numcs2[len2 - i] - '0') + temp;
//                numcs[len1 - i] = (char)(swap % 10 + 48);
//                temp = swap / 10;
//            }
//            while(i <= len1){
//                swap = (numcs1[len1 - i] - '0') + temp;
//                temp = swap / 10;
//                numcs[len1 - i] = (char)(swap % 10 + 48);
//                i++;
//            }
//            
//        }else{
//            int i = 1;
//            numcs = new char[len2];
//            for(; i <= len1; i++){
//                swap =(numcs1[len1 - i] - '0') + ( numcs2[len2 - i] - '0') + temp;
//                numcs[len2 - i] = (char)(swap % 10 + 48);
//                temp = swap / 10;
//            }
//            while(i <= len2){
//                swap = ( numcs2[len2 - i] - '0') + temp;
//                temp = swap / 10;
//                numcs[len2 - i] = (char)(swap % 10 + 48);
//                i++;
//            }
//        }
//
//        return temp == 0 ? new String(numcs) : "1" + new String(numcs); 
//    }
	
	/**
	 * 利用switch 返回对应值，效率较之前提高很多，内存空间利用反而少了很多
	 * @param x
	 * @return
	 */
	public int getVal(char x){
        switch(x) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return -1;
        }
    }
	
	public String addStrings(String num1, String num2) {
        char[] numcs ;
        char[] numcs1 = num1.toCharArray();
        char[] numcs2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        int temp = 0;
        int swap = 0;
        if(len1 > len2){
            int i = 1;
            numcs = new char[len1];
            for(; i <= len2; i++){
                swap = getVal( numcs1[len1 - i]) + getVal( numcs2[len2 - i]) + temp;
                numcs[len1 - i] = (char)(swap % 10 + 48);
                temp = swap / 10;
            }
            while(i <= len1){
                swap = getVal( numcs1[len1 - i]) + temp;
                temp = swap / 10;
                numcs[len1 - i] = (char)(swap % 10 + 48);
                i++;
            }
            
        }else{
            int i = 1;
            numcs = new char[len2];
            for(; i <= len1; i++){
                swap = getVal( numcs1[len1 - i]) + getVal( numcs2[len2 - i]) + temp;
                numcs[len2 - i] = (char)(swap % 10 + 48);
                temp = swap / 10;
            }
            while(i <= len2){
                swap = getVal( numcs2[len2 - i]) + temp;
                temp = swap / 10;
                numcs[len2 - i] = (char)(swap % 10 + 48);
                i++;
            }
        }

        return temp == 0 ? new String(numcs) : "1" + new String(numcs); 
    }

}
