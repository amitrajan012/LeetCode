package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		
		while(!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			if(!q1.isEmpty()) {
				while(!q1.isEmpty()) {
					TreeNode r = q1.poll();
					temp.add(r.val);
					if(r.left != null) q2.add(r.left);
					if(r.right != null) q2.add(r.right);	
				}
			}else if(!q2.isEmpty()) {
				while(!q2.isEmpty()) {
					TreeNode r = q2.poll();
					temp.add(r.val);
					if(r.left != null) q1.add(r.left);
					if(r.right != null) q1.add(r.right);	
				}
			}
			res.add(temp);
		}
		return res;
    }
}
