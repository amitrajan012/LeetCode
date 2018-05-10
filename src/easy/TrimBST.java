package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
 *
 */
public class TrimBST {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null) return null; //Base case
		//Recursive solution
		if(root.val < L) {
			root = trimBST(root.right, L, R);
		}else if(root.val > R) {
			root = trimBST(root.left, L, R);
		}else {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
		}
		return root;
    }
}
