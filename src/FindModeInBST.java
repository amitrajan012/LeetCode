import java.util.ArrayList;
import java.util.List;

/**
 * See <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/description/">Description</a>
 */
public class FindModeInBST {
	Integer previous = null;
	int count = 1;
	int max = 0;
	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];
		List<Integer> res = new ArrayList<Integer>();
		traverseBST(root, res);
		int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
        		result[i] = res.get(i);
        }
        return result;
    }
	
	private void traverseBST(TreeNode root, List<Integer> list) {
		if(root == null) return;
		traverseBST(root.left, list);
		if(previous != null) {
			if(previous == root.val) 
				count++;
			else
				count = 1;
		}
		if(count>max) {
			max = count;
			list.clear();
			list.add(root.val);
		}else if(count == max) {
			list.add(root.val);
		}
		previous = root.val;
		traverseBST(root.right, list);
	}
}
