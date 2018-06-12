package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> sLtoR = new Stack<TreeNode>();
		Stack<TreeNode> sRtoL = new Stack<TreeNode>();
		sLtoR.push(root);
		
		while(!sLtoR.isEmpty() || !sRtoL.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			if(!sLtoR.isEmpty()) {
				while(!sLtoR.isEmpty()) {
					TreeNode r = sLtoR.pop();
					temp.add(r.val);
					if(r.left != null) sRtoL.push(r.left);
					if(r.right != null) sRtoL.push(r.right);	
				}
			}else if(!sRtoL.isEmpty()) {
				while(!sRtoL.isEmpty()) {
					TreeNode r = sRtoL.pop();
					temp.add(r.val);
					if(r.right != null) sLtoR.push(r.right);	
					if(r.left != null) sLtoR.push(r.left);
				}
			}
			res.add(temp);
		}
		return res;
    }
}
