package medium;
/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class ConstructBTFromPostOrderAndInOrderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inEnd = inorder.length-1;
        TreeNode res = buildTree(postorder, inorder, postorder.length-1, 0, inEnd);
		return res;
    }

	private TreeNode buildTree(int[] postorder, int[] inorder, int postEnd, int inStart, int inEnd) {
		if(postEnd < 0 || inStart > inEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		for(int i=inStart;i<=inEnd;i++) {
			if(inorder[i] == postorder[postEnd]) {
				inIndex = i;
				break;
			}
		}
		
		root.right = buildTree(postorder, inorder, postEnd-1, inIndex+1, inEnd);
		root.left = buildTree(postorder, inorder, postEnd-(inEnd-inIndex+1), inStart, inIndex-1);
		return root;
	}
}
