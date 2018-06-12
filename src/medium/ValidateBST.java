package medium;
/*
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
        //Base case
		if(root == null) {
			return true;
		}
		
		if(root.left != null && root.right != null) {
			return (root.left.val <= root.val && root.val <= root.right.val && isValidBST(root.left) && isValidBST(root.right));
		}else if(root.left == null) {
			return (root.val <= root.right.val && isValidBST(root.right));
		}else if(root.right == null) {
			return (root.left.val <= root.val && isValidBST(root.left));
		}else {
			return true;
		}
    }
}
