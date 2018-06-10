package medium;
/*
 * https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode dummyBefore = new ListNode(-1);
		ListNode dummyAfter = new ListNode(-1);
		ListNode before = dummyBefore, after = dummyAfter;

		while(head != null) {
            if(head.val < x) {
				 before.next = head;
				 head = head.next;
				 before = before.next;
				 before.next = null;
			 } else {
				 after.next = head;
				 head = head.next;
				 after = after.next;
				 after.next = null;
			 }
		}
		
		before.next = dummyAfter.next;
		return dummyBefore.next;
	}
}
