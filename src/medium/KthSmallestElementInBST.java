package medium;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        int countLeft = countNodes(root.left);
        if(k == countLeft+1) return root.val;
        else if(k <= countLeft) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - countLeft -1);
    }

	private int countNodes(TreeNode root) {
		if(root == null) return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

}
