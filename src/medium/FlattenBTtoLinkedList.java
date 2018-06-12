package medium;
/*
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
public class FlattenBTtoLinkedList {
	public void flatten(TreeNode root) {
        helper(root);
    }

	private TreeNode helper(TreeNode root) {
		if(root == null) return null;
		TreeNode node = root;
		TreeNode right = helper(node.right);
		node.right = helper(node.left);
		node.left = null;
		while(node.right != null) {
			node = node.right;
		}
		node.right = right;
		
		return root;
	}
	
	//Need to check
	private void helper2(TreeNode temp, TreeNode root) {
		if(root == null) {
			return;
		}
        System.out.println(root.val);
		temp.right = new TreeNode(root.val);
		temp = temp.right;
		helper2(temp, root.left);
		helper2(temp, root.right);
	}
}
