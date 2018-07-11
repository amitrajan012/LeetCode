package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
    		//Base case
    		if(d == 1) {
    			TreeNode N = new TreeNode(v);
    			N.left = root;
    			return N;
    		}
    		TreeNode res = new TreeNode(0);
    		res.left = root;
    		
    		Queue<TreeNode> queue = new LinkedList<>();
    		queue.add(root);
    		d--;
    		
    		while(d > 1 && !queue.isEmpty()) {
    			Queue<TreeNode> temp = new LinkedList<>();
    			while(!queue.isEmpty()) {
    				TreeNode r = queue.poll();
    				if(r.left != null) temp.add(r.left);
    				if(r.right != null) temp.add(r.right);
    			}
    			queue = temp;
    			d--;
    		}
    		
    		if(d==1 && !queue.isEmpty()) {
    			while(!queue.isEmpty()) {
    				TreeNode r = queue.poll();
    				TreeNode left = r.left;
    				TreeNode right =  r.right;
    				r.left = new TreeNode(v);
    				r.right = new TreeNode(v);
    				r.left.left = left;
    				r.right.right = right;
    			}
    		}
    		return res.left;
    }
}
