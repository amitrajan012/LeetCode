package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
public class MostFrequentSubtreeSum {
	Map<Integer, Integer> map;
    int maxCount;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        helper(root);
        
        List<Integer> res = new ArrayList<>();
        for(Entry<Integer, Integer> e: map.entrySet()) {
        		if(e.getValue() == maxCount) res.add(e.getKey());
        }
        
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++) {
        		result[i] = res.get(i);
        }
        
        return result;
    }
    
	private int helper(TreeNode root) {
		if(root == null) return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		
		int sum = root.val + left + right;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		maxCount = Math.max(maxCount, map.get(sum));
		return sum;
	}
}
