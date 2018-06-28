package medium;
/*
 * https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
    		//Base case
    		if(head == null || head.next == null) return head;
    		ListNode odd = head;
    		ListNode even = head.next;
    		ListNode p = odd, q = even;
    		while(q != null && q.next != null) {
    			p.next = q.next;
    			p = q.next;
    			q.next = p.next;
    			q = p.next;
    		}
    		p.next = even;
    		return odd;
    }
}
