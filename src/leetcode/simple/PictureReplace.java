package leetcode.simple;

public class PictureReplace {
	
	/**
	 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。

	 *	为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
		
	 *	最后返回经过上色渲染后的图像。
		
	 *	来源：力扣（LeetCode）
	 *	链接：https://leetcode-cn.com/problems/flood-fill
	 *	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	private int[][] image;
    private int newColor;
    private int oldColor;


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.newColor = newColor;
        this.oldColor = image[sc][sc];
        return floodReplace(sr, sc);
    }

//    public int[][] floodReplace(int sr, int sc){
//        // 结束递归的条件
//        if(sr < 0 || sc <0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor ){
//            return image;
//        }
//        // 上,下，左,右
//        int[] above = {sr, sc - 1};
//        int[] below = {sr, sc + 1};
//        int[] left = {sr - 1, sc};
//        int[] right = {sr + 1, sc};
//        int[][] neghbors = {above, below, left, right};
//
//        image[sr][sc] = newColor;
//        for(int i = 0; i < 4; i++){
//            floodReplace(neghbors[i][0], neghbors[i][1]);
//        }
//
//        return image;
//    }
    
    /**
     * 本质还是深度优先，递归解决，但是递归进栈有条件，否则爆出超出内存限制
     * @param sr
     * @param sc
     * @return
     */
    public int[][] floodReplace(int sr, int sc){

        image[sr][sc] = newColor;

        if(sr -1 >= 0 && image[sr - 1][sc] == oldColor){
             floodReplace(sr - 1, sc);
        }

        if(sr +1 < image.length && image[sr + 1][sc] == oldColor){
             floodReplace(sr + 1, sc);
        }

        if(sc -1 >= 0 && image[sr][sc - 1] == oldColor){
             floodReplace(sr, sc - 1);
        }

        if(sc + 1 < image[0].length && image[sr][sc + 1] == oldColor){
             floodReplace(sr, sc + 1);
        }

        return image;
    }

}
