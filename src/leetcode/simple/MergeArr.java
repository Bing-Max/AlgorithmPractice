package leetcode.simple;

public class MergeArr {
	
	/**
	 * 合并两个排序好的数组，A的容量大到可以容纳两个数组全部有效数据
	 */
	
	
	/**
	 * 归并排序的归并操作
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void merge1(int[] A, int m, int[] B, int n) {
        int iA = 0;
        int iB = 0;
        int[] res = new int[A.length];
        int index = 0;
        while(iA < m && iB < n){
            if(A[iA] <= B[iB]){
                res[index++] = A[iA++];
            }
            // 这里可以跳出循环，使用continue， 但是不跳出循环直接下一判断更好，减少了部分的循环
            if(A[iA] >= B[iB]){
                res[index++] = B[iB++];
            }
        }

        while(iA < m){
            res[index++] = A[iA++];
        }

        while(iB < n){
            res[index++] = B[iB++];
        }

        for(int i = 0; i < A.length; i++){
            A[i] = res[i];
        }
    }
	
	/**
	 * 逆序指针 -> 上述双向指针需要额外的 temp 数组，原因是可能导致重写了A数组的有效数据而造成数据丢失
	 * 逆序的好处从A 数组的反方向重写 大数靠后，不会影响A 数组的有效数据
	 * 但是上述方法 在第一个循环中，第一个判断指针后移后，并不会造成数组越界，反过来写就会出现问题，在写完一个数据之后，A数组的指针会到达-1，这时就要跳出循环了，如果继续下一判断，就会数组越界
	 * 解决方式就是 if 之后 continue, 或者 第二次判断多加条件，我比较倾向第二个，多了判断，但是见少了循环次数
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void merge(int[] A, int m, int[] B, int n) {
        int iA = m-1;
        int iB = n-1;
        int index = A.length -1;
        while(iA > -1 && iB > -1){
            if(A[iA] >= B[iB]){
                A[index--] = A[iA--];
            }

            if(iA > -1 && iB > -1 && A[iA] <= B[iB]){
                A[index--] = B[iB--];
            }
        }

        while(iA > -1){
            A[index--] = A[iA--];
        }

        while(iB > -1){
            A[index--] = B[iB--];
        }
    }

}
