package easy;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        //If null
		if(root == null){
			return 0;
		}else{
			int depth_left = maxDepth(root.left);
			int depth_right = maxDepth(root.right);
			
			//Return the maximum of the two
			if(depth_left > depth_right){
				return depth_left+1;
			}else{
				return depth_right+1;
			}
		}
    }
}
