package medium;
/*
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode res = new TreeNode(0);
        res.left = root;
        
        while(root != null) {
        		if(root.left == null && root.right == null) break;
        		if(root.val < val) {
        			//Traverse right subtree
        			if(root.right == null) break;
        			else root = root.right;
        		}else {
        			//Traverse left subtree
        			if(root.left == null) break;
        			else root = root.left;
        		}
        }
        
        if(root.val < val) root.right = new TreeNode(val);
        else root.left = new TreeNode(val);
    		return res.left;
    }
}
