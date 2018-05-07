import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if(root != null) {
			searchBinaryTree(root, "", answer);
		}
		return answer;
    }

	private void searchBinaryTree(TreeNode root, String path, List<String> answer) {
		if(root.left == null && root.right == null) {
			answer.add(path + root.val);
		}
		if(root.left != null) {
			searchBinaryTree(root.left, path + root.val + "->", answer);
		}
		if(root.right != null) {
			searchBinaryTree(root.right, path + root.val + "->", answer);
		}
		
	}
}
