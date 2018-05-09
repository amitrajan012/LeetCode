/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 * BST Traversals:
 * 1) Inorder (Type of Depth First Traveresal) : (Left, Root, Right)
 * 		Inorder traversal gives nodes in non-decreasing order.  To get nodes of BST in non-increasing order,
 *  		a variation of Inorder traversal where Inorder traversal is reversed, can be used.
 *  		Steps: Traverse the left subtree InOrder
 *  			   Visit the node
 *  			   Traverse the right subtree InOrder
 *  		Implementation : Recursive (implicit stack) and Iterative(can be implemented using explicit stack)
 */
public class MinimumAbsoluteDifferenceInBST {
	int difference = Integer.MAX_VALUE;
	TreeNode previous;
	public int getMinimumDifference(TreeNode root) {
        traverseBST(root);
		return difference;
    }
	
	private void traverseBST(TreeNode root) {
		if(root == null) return;
		traverseBST(root.left);
		if(previous != null)
			difference = Math.min(difference, root.val-previous.val);
		previous = root;
		traverseBST(root.right);
	}
}
