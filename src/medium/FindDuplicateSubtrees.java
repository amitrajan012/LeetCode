package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        preOrder(root, res, new HashMap<>());
    		return res;
    }

	private String preOrder(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
		if(root == null) return "#";
		String S = root.val + "," + preOrder(root.left, res, map) + "," + preOrder(root.right, res, map);
		if(map.getOrDefault(S, 0) == 1) res.add(root);
		map.put(S, map.getOrDefault(S, 0)+1);
		return S;
	}
}
