package medium;
/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;
       
        while(n>=0) {
        		fast = fast.next;
        }
        
        while(fast != null) {
        		fast = fast.next;
        		slow = slow.next;
        }
        
        slow.next = slow.next.next;
		return start.next;
    }
}
