package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */
public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
        		return new ArrayList<TreeNode>();
        }
		return helper(1, n);
    }

	private List<TreeNode> helper(int m, int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(m > n) {
			res.add(null);
			return res;
		}
		
		for(int i=m;i<=n;i++) {
			List<TreeNode> ls = helper(m, i-1);
			List<TreeNode> rs = helper(i+1, n);
			for(TreeNode l: ls) {
				for(TreeNode r: rs) {
					TreeNode cur = new TreeNode(i);
					cur.left = l;
					cur.right = r;
					res.add(cur);
				}
			}
		}
		return res;
	}
}
