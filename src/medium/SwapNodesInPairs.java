package medium;
/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode l = new ListNode(0);
        l.next = head;
        res = l;
        
        while(l.next != null && l.next.next != null) {
        		ListNode temp1 = l.next.next.next;
        		ListNode temp2 = l.next;
        		l.next = l.next.next;
        		l.next.next = temp2;
        		l.next.next.next = temp1;
        		l = l.next.next;
        }
        
        return res.next;
    }
}
