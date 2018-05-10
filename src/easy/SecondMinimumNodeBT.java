package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 */
public class SecondMinimumNodeBT {
	public int findSecondMinimumValue(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) return -1; //Base case
		
		int l = root.left.val;
		if(l == root.val) {
			l = findSecondMinimumValue(root.left);
		}
		
		int r = root.right.val;
		if(r == root.val) {
			r = findSecondMinimumValue(root.right);
		}
		
		if(l == -1) return r;
		if(r == -1) return l;
		return Math.min(l, r);
    }
}
