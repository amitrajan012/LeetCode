package medium;

/*
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
    		int count = 0, h = height(root);
    		while(root !=  null) {
    			if(height(root.right) == h-1) {
    				count += 1 << h;
    				root = root.right;
    			}else {
    				count += 1 << (h-1);
    				root = root.left;
    			}
    			h--;
    		}
    		return count;
    }

	private int height(TreeNode root) {
		return root == null ? -1 : 1+height(root.left);
	}
}
