package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/binary-tree-tilt/description/
 *
 */
public class BinaryTreeTilt {
	int tilt = 0;
	public int findTilt(TreeNode root) {
        traverseBTPostOrder(root);
		return tilt;
    }
	
	private int traverseBTPostOrder(TreeNode root) {
		//Postorder Traversal (Left, Right, Root)
		if(root == null) return 0;
		int left = traverseBTPostOrder(root.left);
		int right = traverseBTPostOrder(root.right);
		tilt += Math.abs(left-right);
		return left+right+root.val;
	}
}
