package medium;
/*
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        TreeNode res = new TreeNode(0);
        res.left = buildTree(nums, 0, nums.length-1);
    		return res.left;
    }

	private TreeNode buildTree(int[] nums, int start, int end) {
		if(start > end) return null;
		int i=start, j=end;
		int maxIndex = i;
		while(i <= j) {
			if(nums[i] > nums[maxIndex]) maxIndex = i;
			if(nums[j] > nums[maxIndex]) maxIndex = j;
			i++; j--;
		}
		TreeNode r = new TreeNode(nums[maxIndex]);
		r.left = buildTree(nums, start, maxIndex-1);
		r.right = buildTree(nums, maxIndex+1, end);
		return r;
	}
}
