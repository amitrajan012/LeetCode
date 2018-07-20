package medium;
/*
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 */
public class SmallestSubtreeWithAllTheDeepestNode {
	TreeNode res;
	int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 1);
        traverse(root, 1, maxDepth);
    		return res;
    }
    
	private int traverse(TreeNode root, int level, int depth) {
		if(root == null) return level-1;
		int left = traverse(root.left, level+1, depth);
		int right = traverse(root.right, level+1, depth);
		if(left == depth && right == depth) res = root;
		return Math.max(left, right);
	}
	
	private void dfs(TreeNode root, int level) {
		if(root == null) return;
		dfs(root.left, level+1);
		dfs(root.right, level+1);
		maxDepth = Math.max(maxDepth, level);
	}
}
