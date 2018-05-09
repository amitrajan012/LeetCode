/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 */
public class DiameterOfBinaryTree {
	int diameter = 0;
	public int diameterOfBinaryTree(TreeNode root) {
        traverseBTPostOrder(root);
		return diameter;
    }
	
	private int traverseBTPostOrder(TreeNode root) {
		//Post Order traversal
		if(root == null) return -1;
		int left = traverseBTPostOrder(root.left)+1;
		int right = traverseBTPostOrder(root.right)+1;
		if(left+right > diameter) diameter = left+right;
		return left>right ? left : right;
	}
}
