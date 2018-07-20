package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 */
public class AllNodesDistanceKInBinaryTree {
	Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target, K);
        dfs(root, target, K, map.get(root), res);
    		return res;
    }
    
	private void dfs(TreeNode root, TreeNode target, int K, int distance, List<Integer> res) {
		if(root == null) return;
		if(map.containsKey(root)) distance = map.get(root);
		if(distance == K) res.add(root.val);
		dfs(root.left, target, K, distance+1, res);
		dfs(root.right, target, K, distance+1, res);
		
	}
	private int find(TreeNode root, TreeNode target, int K) {
		if(root == null) return -1;
		if(root == target) {
			map.put(root, 0);
			return 0;
		}
		
		int left = find(root.left, target, K);
		if(left >= 0) {
			map.put(root, left+1);
			return left+1;
		}
		int right = find(root.right, target, K);
		if(right >= 0) {
			map.put(root, right+1);
			return right+1;
		}
		return -1;
		
	}
}
