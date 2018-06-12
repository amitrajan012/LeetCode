package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
		
		//Traverse the tree
		while(stack.size() > 0) {
			//Visit the top node
			TreeNode t = stack.pop();
			res.add(t.val);
			if(t.right != null) {
				t = t.right;
				while(t != null) {
					stack.push(t);
					t = t.left;
				}
			}
		}
		return res;
    }
	
	public List<Integer> inOrder2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}

	private void helper(TreeNode node, List<Integer> res) {
		if(node == null) {
			return;
		}
		helper(node.left, res);
		res.add(node.val);
		helper(node.right, res);
	}
}
