package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int res = root.val;
        queue.offer(root);

        while(true) {
        		int nodeCount = queue.size();
        		if(nodeCount == 0) break;
        		res = queue.peek().val;
        		while(nodeCount > 0) {
        			TreeNode node = queue.poll();
        			if(node.left != null) queue.offer(node.left);
        			if(node.right != null) queue.offer(node.right);
        		}
        }
    		return res;
    }
}
