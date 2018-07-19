package medium;
/*
 * https://leetcode.com/problems/binary-tree-pruning/description/
 */
public class BinaryTreePurning {
    public TreeNode pruneTree(TreeNode root) {
        constructTree(root);
    		return root;
    }

	private void constructTree(TreeNode root) {
		if(root == null) return;
		constructTree(root.left);
		constructTree(root.right);
		
		//If left/right child is a leaf and value is 0, purne it
		if(root.left != null && isLeaf(root.left) && root.left.val == 0) root.left = null;
		if(root.right != null && isLeaf(root.right) && root.right.val == 0) root.right = null;
		
		return;
	}

	private boolean isLeaf(TreeNode root) {
		return (root.left == null) && (root.right == null);
	}
}
