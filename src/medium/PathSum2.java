package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, sum, new ArrayList<Integer>());
		return res;
    }

	private void helper(List<List<Integer>> res, TreeNode root, int sum, ArrayList<Integer> list) {
		if(root == null) {
			return;
		}
		
		sum = sum-root.val;
		list.add(root.val);
		if(sum == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<>(list));
		}else {
			helper(res, root.left, sum, list);
			helper(res, root.right, sum, list);
		}
		list.remove(list.size()-1);
	}
}
