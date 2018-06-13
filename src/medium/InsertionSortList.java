package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/insertion-sort-list/description/
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		List<Integer> l = new ArrayList<Integer>();
		while(head != null) {
			l.add(head.val);
			head = head.next;
		}
		
		Collections.sort(l);
		ListNode res = new ListNode(0);
		ListNode temp = new ListNode(0);
		res.next = temp;
		for(int i: l) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		return res.next.next;
	}
}
