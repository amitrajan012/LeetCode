package medium;
/*
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 */

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	 public BSTIterator(TreeNode root) {
	        pushAll(root);
	 }

	 private void pushAll(TreeNode node) {
	    	while(node != null) {
	    		stack.push(node);
	    		node = node.left;
	    	}
	 }

	 /** @return whether we have a next smallest number */
	 public boolean hasNext() {
		 return !stack.isEmpty();
	 }

	 /** @return the next smallest number */
	 public int next() {
		 TreeNode temp = stack.pop();
		 pushAll(temp.right);
		 return temp.val;
	 }
}
