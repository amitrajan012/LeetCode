package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //Base case
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
        		TreeNode temp = stack.pop();
        		res.add(temp.val);
        		if(temp.right != null) stack.push(temp.right);
        		if(temp.left != null) stack.push(temp.left);
        }
		return res;
    }
}
