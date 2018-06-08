package medium;
/*
 * https://leetcode.com/problems/rotate-list/description/
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		//Base case
		if(k==0 || head == null) {
			return head;
		}
        ListNode pointer1 = head; //Take pointer1 to k first
        //Find the length of list first
        int len = 0;
        while(pointer1 != null) {
        		pointer1 = pointer1.next;
        		len++;
        }
        if(len == 1 || k % len == 0) {
    			return head;
        }
        pointer1 = head;
        int temp = len - k % len;
        while(temp > 0) {
        		pointer1 = pointer1.next;
        		temp--;
        }
        ListNode newHead = pointer1;
        temp = k % len;
        while(temp > 1) {
        		pointer1 = pointer1.next;
        		temp--;
        }
        temp = len - k % len;
        ListNode pointer2 = head;
        while(temp > 0) {
        		pointer1.next = pointer2;
        		pointer1 = pointer1.next;
        		pointer2 = pointer2.next;
        		temp--;
        }
        pointer1.next = null;
		return newHead;
    }
}
