package medium;
/*
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
    		TreeNode cur = root;
    		TreeNode pre = null;
    		while(cur != null && cur.val != key) {
    			pre = cur;
    			if(key < cur.val) {
    				cur = cur.left;
    			}else {
    				cur = cur.right;
    			}
    		}
    		
    		if(pre == null) return deleteRootNode(cur);
    		else if(pre.left == cur) pre.left = deleteRootNode(cur);
    		else pre.right = deleteRootNode(cur);
    		
    		return root;
    }

	private TreeNode deleteRootNode(TreeNode root) {
		if(root == null) return null;
		if(root.left == null) return root.right;
		if(root.right == null) return root.left;
		
		TreeNode next = root.right;
		TreeNode pre = null;
		while(next.left != null) {
			pre = next;
			next = next.left;
		}
		
		next.left = root.left;
		if(root.right != next) {
			pre.left = next.right;
			next.right = root.right;
		}
		return next;
	}
}
