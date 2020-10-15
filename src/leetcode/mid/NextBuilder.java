package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

import leetcode.Node;

public class NextBuilder {
	
	 //bfs
	/**
	 * 
	 * @param root
	 * @return
	 
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        List<Node> queue = new ArrayList<Node>();
        queue.add(root);

        int size;
        Node cur;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                cur = queue.remove(0);

                if(i != size - 1){
                    cur.next = queue.get(0);
                }

                if(cur.left != null){
                    queue.add(cur.left);
                }

                if(cur.right != null){
                    queue.add(cur.right);
                }
            }

        }

        return root;
    }
    
    */
	
	// next
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        Node node = root;
        Node nextFirst = root.left;
        while(nextFirst != null){
            while(node != null){
                if(node.left != null && node.right != null){
                    node.left.next = node.right;
                }

                if(node.next != null){
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            node = nextFirst;
            nextFirst = node.left;
        }

        return root;
    }

}
