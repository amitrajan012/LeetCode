package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertedSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		//Convert linked list to array
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		int[] l = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			l[i] = list.get(i);
		}
		return helper(l, 0, l.length-1);
    }

	private TreeNode helper(int[] l, int low, int high) {
		if(low > high) {
			return null;
		}
		int mid = low + (high-low)/2;
		TreeNode root = new TreeNode(l[mid]);
		root.left = helper(l, low, mid-1);
		root.right = helper(l, mid+1, high);
		return root;
	}
}
