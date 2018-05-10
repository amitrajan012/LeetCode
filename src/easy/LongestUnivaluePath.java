package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 */
public class LongestUnivaluePath {
	int result = 0;
	public int longestUnivaluePath(TreeNode root) {
        //Base case
		if(root == null || (root.left == null && root.right == null)) return 0;
		
		traverse(root);
		return result;
    }
	
	private int traverse(TreeNode root) {
		int l=0, r=0;
		if(root.left != null) {
			if(root.val == root.left.val) {
				l = 1+traverse(root.left);
			}else {
				traverse(root.left);
			}
		}
		if(root.right != null) {
			if(root.val == root.right.val) {
				r = 1+traverse(root.right);
			}else {
				traverse(root.right);
			}
		}
		
		result = Math.max(result, l+r);
		return Math.max(l, r);
	}
}
