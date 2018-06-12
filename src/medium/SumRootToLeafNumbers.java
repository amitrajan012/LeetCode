package medium;
/*
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

	private int sum(TreeNode node, int val) {
		if(node == null) return 0;
		if(node.right == null && node.left == null) return (10*val+node.val);
		return sum(node.left, val*10+node.val) + sum(node.right, val*10+node.val);
	}
}
