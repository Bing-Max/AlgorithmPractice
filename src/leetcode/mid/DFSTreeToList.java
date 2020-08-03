package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

public class DFSTreeToList {
	
	private List<TreeNode> list = new ArrayList<>();

	/**
	 * 给定一个二叉树，原地将它展开为一个单链表。
	 * 这里的单链表是每个节点右节点指向下一节点，左节点置空
	 * @param root
	 */
	public void flatten(TreeNode root) {
        if(root != null){
        	// 存放根节点的左右子树的根节点
            TreeNode rC = root.right;
            TreeNode lC = root.left;
            if(lC != null){
            	//左节点不为空，接在根节点的右树上
                root.right = lC;
                //左节点置空
                root.left = null;
                //原来的左节点递归处理
                flatten(lC);

                // 把原来的右节点接在右子树的最后
                while(lC.right != null){
                    lC = lC.right;
                }
                lC.right = rC;
            }
            if(rC != null){
            	// 处理右子树
                flatten(rC);
            }
        }
        
    }
	
	// 也可以说是中序遍历， 深度优先遍历
	 public void flatten1(TreeNode root) {
	        iter(root);
	        if(list.size()>0){
	            root = list.get(0);
	            list.remove(0);
	        }
	        for(TreeNode n : list){
	            root.left = null;
	            root.right = n;
	            root = root.right;
	        }
	    }

	    public void iter(TreeNode root){
	        if(root != null){
	            list.add(root);

	            iter(root.left);
	            iter(root.right);
	        } 
	    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
