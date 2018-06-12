package medium;
/*
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        ListNode list = new ListNode(0);
        res.next = list;
        n = n-m+1;
        
        while(m > 1) {
        		list.next = new ListNode(head.val);
        		list = list.next;
        		head = head.next;
        		m--;
        }
        
        while(n > 0) {
        		ListNode l = list.next;
        		list.next = new ListNode(head.val);
        		list.next.next = l;
        		n--;
        		head = head.next;
        }
        
        if(head != null) {
        		while(list.next != null) {
        			list = list.next;
        		}
        		list.next = new ListNode(head.val);
        		list.next.next = head.next;
        }
        
		return res.next.next;
    }
}
