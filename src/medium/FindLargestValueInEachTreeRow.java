package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(true) {
        		int nodeCount = queue.size();
        		if(nodeCount == 0) break;
        		int temp = queue.peek().val;
        		while(nodeCount > 0) {
        			TreeNode node = queue.poll();
        			temp = Math.max(temp, node.val);
        			if(node.left != null) queue.offer(node.left);
        			if(node.right != null) queue.offer(node.right);
        			nodeCount--;
        		}
        		res.add(temp);
        }
        
        return res;
    }
}
