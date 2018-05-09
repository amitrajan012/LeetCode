import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 */
public class TwoSum4BST {
	Set<Integer> set = new HashSet<Integer>();
	public boolean findTarget(TreeNode root, int k) {
		if(root == null) return false;
		if(set.contains(root.val)) return true;
		else set.add(k-root.val);
		
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
}
