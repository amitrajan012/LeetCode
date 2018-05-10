package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 */
public class ConvertBSTtoGreaterTree {

	TreeNode previous;
	public TreeNode convertBST(TreeNode root) {
		traverseBSTReverse(root);
		return root;
    }
	
	private void traverseBSTReverse(TreeNode root) {
		//Reverse InOrder Traversal implementation
		if(root == null) return;
		traverseBSTReverse(root.right);
		if(previous != null)
			root.val = root.val+previous.val;
		previous = root;
		traverseBSTReverse(root.left);
	}

}
