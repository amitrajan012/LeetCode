package medium;
/*
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res;
        //Base cases
        if(l1 == null && l2 == null) {
        		return null;
        }else if(l1 == null) {
        		return l2;
        }else if(l2 == null) {
        		return l1;
        }else {
        		res = new ListNode((l1.val + l2.val)%10);
        		carry = (l1.val + l2.val)/10;
        		l1 = l1.next;
        		l2 = l2.next;
        }
         
        ListNode node = res;
        
        while(l1 != null || l2 != null) {
        		int val = 0;
        		if(l1 != null) {
        			val = l1.val;
        			l1 = l1.next;
        		}
        		if(l2 != null) {
        			val = val+l2.val;
        			l2 = l2.next;
        		}
        		val += carry;
        		res.next = new ListNode(val%10);
        		res = res.next;
        		carry = val/10;
        }
        if(carry == 1) {
        		res.next = new ListNode(1);
        }
		return node;
    }
}
