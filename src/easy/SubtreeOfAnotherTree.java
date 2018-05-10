package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 */
public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) return t == null;
		if(isIdentical(s, t)) return true;
		
		return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

	private boolean isIdentical(TreeNode s, TreeNode t) {
		if(s == null) return t == null;
		if(t == null) return s == null;
		if(s.val != t.val) return false;
		
		return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
	}
}
