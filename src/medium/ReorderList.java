package medium;
/*
 * https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		//Base case
		if(head==null||head.next==null) return;
		
		//Find the middle of the list
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){ 
        		slow = slow.next;
            fast = fast.next.next;
        }
        
        //Reverse the half after middle
        ListNode prev = null;
        ListNode cur = slow.next;
        while(cur != null) {
        		ListNode temp = cur.next;	
        		cur.next = prev;
        		prev = cur;
        		cur = temp;
        }
        slow.next = prev;
        
        // Merge 1 -> 2 -> 3  6 -> 5 -> 4
        ListNode dummy = new ListNode(0);
        ListNode l1 = head, l2 = slow.next;
        slow.next = null;
        boolean isLeft = true;
        while (l1 != null || l2 != null) {
            if (isLeft) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
            isLeft = !isLeft;
        }
        
	}
}
