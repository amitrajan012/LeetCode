
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		//If both the trees are null
		if(p == null && q == null){
			return true;
		}
		//If both are not null
		if(p != null && q != null){
			//Recursively call the function with left and right child and compare where data is same or not
			return (p.val == q.val &&
					isSameTree(p.left, q.left) &&
					isSameTree(p.right, q.right));
		}
		//If one is null and other not
		return false;
    }
}
