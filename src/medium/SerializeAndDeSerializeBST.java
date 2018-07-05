package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 */
public class SerializeAndDeSerializeBST {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
	private static final String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return null;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        		TreeNode r = stack.pop();
        		sb.append(r.val).append(SEP);
        		if(r.left != null) stack.push(r.left);
        		if(r.right != null) stack.push(r.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    		if(data == null) return null;
    		String[] S = data.split(SEP);
    		Queue<Integer> queue = new LinkedList<>();
    		for(String s: S) {
    			queue.offer(Integer.parseInt(s));
    		}
    		
        return getNode(queue);
    }

	private TreeNode getNode(Queue<Integer> queue) {
		if(queue.isEmpty()) return null;
		
		TreeNode root = new TreeNode(queue.poll());
		Queue<Integer> small = new LinkedList<>();
		while(!queue.isEmpty() && queue.peek() < root.val) {
			small.offer(queue.poll());
		}
		
		root.left = getNode(small);
		root.right = getNode(queue);
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
