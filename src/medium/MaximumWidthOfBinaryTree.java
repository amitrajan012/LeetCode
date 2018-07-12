package medium;

import java.util.ArrayDeque;

/*
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
    		if(root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<Integer>  count = new ArrayDeque<>();
        queue.offer(root);
        count.offer(0);
        int max = 1;
        
        while(!queue.isEmpty()) {
        		int size = queue.size();
        		int left = 0, right = 0;
        		for(int i=0;i<size;i++) {
        			TreeNode node = queue.poll();
        			int index = count.poll();
        			if(i==0) left = index;
        			if(i == size-1) right = index;
        			if(node.left != null) {
        				queue.add(node.left);
        				count.add(2*index); //As index of left child in the array representation will be 2i
        			}
        			if(node.right != null) {
        				queue.add(node.right);
        				count.add(2*index+1);
        			}
        		}
        		max = Math.max(max, right-left+1);
        }
    		return max;
    }
}
