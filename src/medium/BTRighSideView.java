package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BTRighSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        		return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
        		TreeNode node = queue.poll();
        		Queue<TreeNode> temp = new LinkedList<TreeNode>();
        		res.add(node.val);
        		if(node.right != null) {
        			temp.add(node.right);
        		}
        		if(node.left != null) {
        			temp.add(node.left);
        		}
        		while(!queue.isEmpty()) {
        			TreeNode n = queue.poll();
        			if(n.right != null) {
            			temp.add(n.right);
            		}
            		if(n.left != null) {
            			temp.add(n.left);
            		}
        		}
        		queue = temp;
        }
        return res;
    }
}
