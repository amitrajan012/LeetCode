package medium;
/*
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		ListNode slowPointer = head, fastPointer = head;
		ListNode meet = null;
		while(fastPointer != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			if(fastPointer == null) {
				return null;
			}
			fastPointer = fastPointer.next;
			if(fastPointer == slowPointer) {
				meet = fastPointer;
				break;
			}
		}
		if(meet == null) {
			return null;
		}
		while(meet != null && head != null) {
			if(meet == head) {
				return meet;
			}
			meet = meet.next; head = head.next;
		}
		return null;
    }
}
