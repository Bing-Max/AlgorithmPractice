package sort.modification;

import java.util.Arrays;

public class StringSortV1 {

	public static void main(String[] args){
		String str = "#$Y^!#Pf&~#FUyTtAfZhCs&Dly%M@(muOI@Le^mydvc((w$x-cP&t-f$R%CCp)bCck@P-ag";
//		String str = "%M@(muOI@Le^mydvc((w$x-cP&t-f$R%CCp)bCck@P-ag";
//		String str = "#$Y^!#Pf&~#FUyTtAfZhCs&Dly%";
//		String str = "#$Y^#Pf";
        char []chars = str.toCharArray();
        System.out.println(chars.length);
        System.out.println(Arrays.toString(chars));
        mergeSort(chars,0, chars.length - 1);
        System.out.println(new String(chars));
    }
    
    // 需要稳定性，所以快排等不稳定的排序方式不行
    public static void bubbleSort(char[] chars){
        
    }
    
    public static void mergeSort(char[] chars, int left, int right){
        if(right > left){
            mergeSort(chars, left, (right + left) / 2);
            mergeSort(chars, (right + left) / 2 + 1, right);
            merge(chars, left, right, (right + left) / 2 + 1);
        }
    }
    
    public static void merge(char[] chars, int left, int right, int mid){
        if(right - left == 1){
            if(isSwap(chars[left], chars[right])){
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
            }
            return;
        }
        int count = 0;
       char[] temp = new char[mid - left];
        for(int i = left; i < mid; i++){
            if(isValidCha(chars[i]) >= 0){
                temp[count] = chars[i];
                count++;
                
            }
            
        }
        
        int j = 0;
        int k = mid;
        int index = left;
        while(j < count && k <= right){
            while(isValidCha(chars[index]) == -1){
                index++;
                
            }
            while(isValidCha(chars[k]) == -1 && k < right){
                k++;
            }
            if(!isSwap(temp[j], chars[k])){
                chars[index++] = temp[j++];
            }else {
                chars[index++] = chars[k++];
            }
        }
        
        
        
        while(j < count){
        	
        	while(isValidCha(chars[index]) == -1){
                index++;
            }
        	
            chars[index++] = temp[j++];
        }
        
       
    }
    
    // 是否需要交换
    public static boolean isSwap(char charA, char charB){
        if(isValidCha(charA) < 0 || isValidCha(charB) < 0){
            return false;
        }
        int xa = (isValidCha(charA) > 0)? charA - 65 : charA - 97;
        int xb = (isValidCha(charB) > 0)? charB - 65 : charB - 97;
        
        return xa > xb;
    }
    
    public static int isValidCha(char c){
        if(c >= 65 && c <= 90){
            return 1;
        }
        
        if(c >= 97 && c <= 122){
            return 0;
        }
        
        return -1;
    }

}
