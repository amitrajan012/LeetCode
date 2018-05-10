package easy;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        
		return isMirror(root, root);
    }
	
	boolean isMirror(TreeNode node1, TreeNode node2){
		//If both the trees are null
		if(node1 == null && node2 == null){
			return true;
		}
		//For the two trees to be mirror
		//Value at root must be same
		//Left subtree of left and right subtree of right have to be mirror images
		//Right subtree of left and left subtree of right have to be mirror images
		if(node1 != null && node2 != null && node1.val==node2.val){
			return (isMirror(node1.left, node2.right)) &&
					(isMirror(node1.right, node2.left));
		}
		//Else
		return false;
	}
}
