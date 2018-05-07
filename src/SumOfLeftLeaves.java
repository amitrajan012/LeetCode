
public class SumOfLeftLeaves {
	 public int sumOfLeftLeaves(TreeNode root) {
		 //Base case
		 if(root == null) {
			 return 0;
		 }
		 int ans = 0;
		 if(root.left != null) {
			 if(root.left.left == null && root.left.right == null) {
				 //Hence a leaf
				 ans += root.left.val;
			 }else {
				 //Not a leaf
				 ans += sumOfLeftLeaves(root.left);
			 }
		 }
		 ans += sumOfLeftLeaves(root.right);
		 return ans;
	 }
}
