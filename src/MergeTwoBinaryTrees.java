/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 *
 */
public class MergeTwoBinaryTrees {
	TreeNode result = new TreeNode(0);
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		//Base case
		if(null == t2) return t1;
        if(null == t1) return t2;
        
        TreeNode mergedTree = new TreeNode(t1.val + t2.val);
        mergedTree.left = mergeTrees(t1.left, t2.left);
        mergedTree.right = mergeTrees(t1.right, t2.right);
		return mergedTree;
    }
	

}
