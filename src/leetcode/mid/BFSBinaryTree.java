package leetcode.mid;

import java.util.*;

public class BFSBinaryTree {

	/**
	 * 层序遍历二叉树
	 * 思路： 借助队列这种数据结构实现层序遍历
	 * 注意： 返回的结果也是按层返回List, 在每层遍历时，需要将当层的数据放入List中，不能直接输出
	 * 目前的实现方式是比较复杂的n^2， 循环套循环 （×）
	 * 看似是循环套循环，其实实际上是每个节点进出队列各一次（本题中是两次），所以是n
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<TreeNode> queue = new ArrayList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        List<Integer> hichy = new ArrayList<Integer>();
        List<TreeNode> hichyList;
        TreeNode node;
        while(!queue.isEmpty()){
            // 记录每一层结点
            hichyList = new ArrayList<TreeNode>();
            // 将本层结点入层结点队列
            while(!queue.isEmpty()){
                node = queue.remove(0);
                hichyList.add(node);
            }

            hichy = new ArrayList<Integer>();

            for(TreeNode temp : hichyList){
                hichy.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }

            }

            res.add(hichy);
        }

        return res;
    }
	
	
	/**
	 * 针对上述方法，修改为层list 每次存放下一层的结点，最后直接将 queue 替换为 hichyList即可，时间消耗更少 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<TreeNode> queue = new ArrayList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        List<Integer> hichy = new ArrayList<Integer>();
        List<TreeNode> hichyList;
        TreeNode node;
        while(!queue.isEmpty()){
            // 记录每一层结点
            hichyList = new ArrayList<TreeNode>();

            hichy = new ArrayList<Integer>();

            for(TreeNode temp : queue){
                hichy.add(temp.val);
                if(temp.left != null){
                    hichyList.add(temp.left);
                }

                if(temp.right != null){
                    hichyList.add(temp.right);
                }

            }
            queue = new ArrayList<TreeNode>();
            queue.addAll(hichyList);
            res.add(hichy);
        }

        return res;
    }
}
