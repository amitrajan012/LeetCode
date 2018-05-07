
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		//Base case
		if(root == null){
			return false;
		}else{
			//Subtract root value from sum and find as you reach leaf value goes to 0
			boolean result = false;
			int temp = sum-root.val;
			if(temp == 0 && root.left == null && root.right == null){
				return true;
			}
			if(root.left != null){
				result = result || hasPathSum(root.left, temp);
			}
			if(root.right != null){
				result = result || hasPathSum(root.right, temp);
			}
			return result;
		}
    }
}
