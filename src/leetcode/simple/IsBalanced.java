package leetcode.simple;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

 *	本题中，一棵高度平衡二叉树定义为：

 *	一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @author BingMax
 * @Statement:
 *
 */

public class IsBalanced {
	
	public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if(root.left != null){
            leftHeight = getHeight(root.left);
        }

        if(root.right != null){
            rightHeight = getHeight(root.right);
        }

        if(leftHeight > rightHeight && (leftHeight - rightHeight) > 1){
            return false;
        }else if(leftHeight < rightHeight && (rightHeight - leftHeight) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int getHeight(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }

        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = getHeight(root.left);
        }

        if(root.right != null){
            rightHeight = getHeight(root.right); 
        }

        return leftHeight > rightHeight? (leftHeight + 1) : (rightHeight + 1);
    }

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
