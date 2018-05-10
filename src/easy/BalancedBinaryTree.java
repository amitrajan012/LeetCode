package easy;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        //Base case
		if(root == null){
			return true;
		}
		
		int height_left = height(root.left);
		int height_right = height(root.right);
		
		//Tree is balanced if right and left subtrees are balanced and height difference between them is at max 1
		if(Math.abs(height_left-height_right) <=1 && isBalanced(root.left) && isBalanced(root.right)){
			return true;
		}
		//Returns false when tree is not balanced
		return false;
    }
	
	int height(TreeNode root){
		//Base case
		if(root == null){
			return 0;
		}
		//If not empty, height is maximum(height_left, height_right)+1
		return Math.max(height(root.left), height(root.right))+1;
	}
}
