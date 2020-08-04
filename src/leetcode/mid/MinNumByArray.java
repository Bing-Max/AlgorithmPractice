package leetcode.mid;

public class MinNumByArray {
	private String[] numsO;

    public String minNumber(int[] nums) {
    	numsO = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	numsO[i] = String.valueOf(nums[i]);
        }
//        for(int i = 0; i < numsO.length - 1 ; i++){
//            for(int j = 0 ; j < numsO.length - 1 - i; j++){
//                if(compare(numsO[j], numsO[j+1])){
//                    int temp = numsO[j+1];
//                    numsO[j + 1] = numsO[j];
//                    numsO[j] = temp;
//                }
//            }
//            
//            System.out.println(Arrays.toString(numsO));
//        }
        shellInsertSort(numsO);
        
        StringBuilder sub = new StringBuilder();
        for(String i : numsO) {
        	sub.append(i);
        }
        
        return sub.toString();
    }

    public boolean compare(int num1, int num2){
        if(num1 == num2){
            return false;
        }
//
//        long before = Long.valueOf(String.valueOf(num1) + String.valueOf(num2));
//        long after = Long.valueOf(String.valueOf(num2) + String.valueOf(num1));
//        
//        return before > after;
        /*
         *         String nums1 = String.valueOf(num1);
        String nums2 = String.valueOf(num2);
        int p1 = 0;
        int p2 = 0;

        int c1 = nums1.charAt(0) - '0';
        int c2 = nums2.charAt(0) - '0';
        while(true){
            if(c1 < c2){
                return false;
            }

            if(c1 > c2){
                return true;
            }

            if(p1 == nums1.length() - 1 && p2 == nums2.length() - 1) {
        		break;
        	}
            
            if(p1 < nums1.length() -1){
                c1 = nums1.charAt(++p1) - '0';
            }

            if(p2 < nums2.length() -1){
                c2 = nums2.charAt(++p2) - '0';
            }
        }

        return nums1.length() < nums2.length();
         */
        
        char[] nums1 = (String.valueOf(num1) + String.valueOf(num2)).toCharArray();
        char[] nums2 = (String.valueOf(num2) + String.valueOf(num1)).toCharArray();

        // long before = Long.valueOf(String.valueOf(num1) + String.valueOf(num2));
        // long after = Long.valueOf(String.valueOf(num2) + String.valueOf(num1));
        for(int i = 0; i < nums1.length; i++ ){
        	if(nums1[i] < nums2[i]) {
        		return false;
        	}
        	
            if(nums1[i] > nums2[i]){
                return true;
            }
        }
        
        return false;
    }
    
    public void shellInsertSort(String[] arr) {
		// 待插入的值
		String insertVal;
		//判断待插入的位置
		int insertIndex;
		
		// 设定步长
		// 希尔排序一种思路就是每次步长减半
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {// 步长要求大于0，1 / 2 = 0--> 步长为1排序之后就结束了
			// 一下采用交换的思路解决
			// 外层循环需要保证每个按照步长划分的数组元素都参与插值
			for (int i = gap; i < arr.length; i++) {
				insertVal = arr[i];
				// 往前找一位
				insertIndex = i - gap;
				while (insertIndex >= 0 && (arr[insertIndex] + insertVal).compareTo(insertVal + arr[insertIndex]) > 0) {// 只要它前‘一个’值比他大,他前面的值就后移
					arr[insertIndex + gap] = arr[insertIndex];
					insertIndex -= gap;
				}
				insertIndex += gap;
				if (!arr[insertIndex].equals(insertVal)) {
					arr[insertIndex] = insertVal;
				}
			}

			// 打印每次定步長數組排序之後的内容
//			System.out.println(Arrays.toString(arr));
		}

	}

}
