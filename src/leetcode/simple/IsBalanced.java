package leetcode.simple;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

 *	本题中，一棵高度平衡二叉树定义为：

 *	一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *	这里写的是自顶向下遍历，求高度
 *	但是问题在于每次遍历一棵树，他的子树的高度都要计算一次，导致高度被重复调用
 *
 *	自底向上递归调用：
 *	类似后序遍历，不必每次调用子树的高度，这里每次递归子树结束后返回子树高度+1 或者 -1，供他的父节点判断
 * @author BingMax
 * @Statement:
 *
 */

public class IsBalanced {
	
	
	/**
	 * 自顶向下
	 * 算法的时间复杂度很高
	 * 原因在于 -> 计算每颗树的高度需要递归一次 && isBalanced 还需要递归一次 -> 多次重复递归调用height
	 * @param root
	 * @return
	 */
//	public boolean isBalanced(TreeNode root) {
//
//        if(root == null){
//            return true;
//        }
//
//        if(root.left == null && root.right == null){
//            return true;
//        }
//
//        int leftHeight = 0;
//        int rightHeight = 0;
//
//        if(root.left != null){
//            leftHeight = getHeight(root.left);
//        }
//
//        if(root.right != null){
//            rightHeight = getHeight(root.right);
//        }
//
//        if(leftHeight > rightHeight && (leftHeight - rightHeight) > 1){
//            return false;
//        }else if(leftHeight < rightHeight && (rightHeight - leftHeight) > 1){
//            return false;
//        }else {
//            return isBalanced(root.left) && isBalanced(root.right);
//        }
//
//    }
//
//    public int getHeight(TreeNode root){
//        if(root.left == null && root.right == null){
//            return 1;
//        }
//
//        int leftHeight = 0;
//        int rightHeight = 0;
//        if(root.left != null){
//            leftHeight = getHeight(root.left);
//        }
//
//        if(root.right != null){
//            rightHeight = getHeight(root.right); 
//        }
//
//        return leftHeight > rightHeight? (leftHeight + 1) : (rightHeight + 1);
//    }
	
	/**
	 * 自底向上
	 * 之计算一次，递归调用height
	 * 类似于后序遍历，每颗子树的高度都是由它的左右子树决定的，只需要一次就可以确定整棵树的高度，
	 * 这里的高度为正常高度（>=0）则说明这棵树平衡
	 * 否则：-1 说明，不平衡，只要有一个子树不平衡，对应的结果传递到root节点
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		
		return height(root) >= 0;
	}
	
	public int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(leftHeight == -1 || rightHeight == -1) {
			return -1;
		}else if(leftHeight > rightHeight &&(leftHeight - rightHeight) > 1) {
			return -1;
		}else if(rightHeight > leftHeight &&(rightHeight - leftHeight) > 1) {
			return -1;
		}
		
		return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
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
