package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/print-binary-tree/description/
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
    		List<List<String>> res = new ArrayList<>();
    		int height = (root == null) ? 1 : getHeight(root);
    		int rows = height, columns = (int) (Math.pow(2, height) - 1);
    		List<String> r = new ArrayList<>();
    		
    		for(int i=0;i<columns;i++) r.add("");
    		for(int i=0;i<rows;i++) res.add(new ArrayList<>(r));
       
    		populate(root, res, 0, rows, 0, columns-1);
    		
    		return res;
    }
    
    private void populate(TreeNode root, List<List<String>> res, int row, int totalRows, int start, int end) {
    		if(row == totalRows || root == null) return;
    		res.get(row).set((start+end)/2, Integer.toString(root.val));
    		populate(root.left, res, row+1, totalRows, start, (start+end)/2-1);
    		populate(root.right, res, row+1, totalRows, (start+end)/2+1, end);
		
	}

	private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
   }
}
