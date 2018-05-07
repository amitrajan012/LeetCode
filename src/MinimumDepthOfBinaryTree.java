
public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
        //Base case
		if(root == null){
			return 0;
		}
		//If single node
		if(root.left == null && root.right == null){
			return 1;
		}
		//If left subtree is null
		if(root.left == null){
			return minDepth(root.right)+1;
		}
		//If right subtree is null
		if(root.right == null){
			return minDepth(root.left)+1;
		}
		
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
