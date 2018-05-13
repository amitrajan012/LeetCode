package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 *
 */

public class MinimumDistanceBetweenBSTNodes {
	Integer res = Integer.MAX_VALUE;
	Integer prev = null;
	public int minDiffInBST(TreeNode root) {
		traverse(root);
		return res;
    }
	private void traverse(TreeNode root) {
		//InOrder Traversal (Root, Left, Right)
		if(root == null) return;
		traverse(root.left);
		if(prev != null)
			res = Math.min(res, root.val-prev);
		prev = root.val;
		traverse(root.right);
	}

}
