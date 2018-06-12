package medium;
/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class ConstructBTFromPreOrderAndInOrderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int inEnd = inorder.length-1;
        TreeNode res = buildTree(preorder, inorder, 0, 0, inEnd);
		return res;
    }

	private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
		if(preStart > preorder.length-1 || inStart > inEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0;
		for(int i=inStart;i<=inEnd;i++) {
			if(inorder[i] == preorder[preStart]) {
				inIndex = i;
				break;
			}
		}
		
		root.left = buildTree(preorder, inorder, preStart+1, inStart, inIndex-1);
		root.right = buildTree(preorder, inorder, preStart+inIndex-inStart+1, inIndex+1, inEnd);
		return root;
	}
}
