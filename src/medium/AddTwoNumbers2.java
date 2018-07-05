package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    		//Base case
    		if(l1 == null || l1.val == 0) return l2;
    		if(l2 == null || l2.val == 0) return l1;
    		
        int len1 = 1, len2 = 1;
        ListNode temp1 = new ListNode(0);
        temp1.next = l1;
        ListNode temp2 = new ListNode(0);
        temp2.next = l2;
        temp1 = temp1.next; temp2 = temp2.next;
        
        while(temp1.next != null) {
        		len1++;
        		temp1 = temp1.next;
        }
        
        while(temp2.next != null) {
        		len2++;
        		temp2 = temp2.next;
        }
        
        int max = Math.max(len1, len2);
        int min = Math.min(len1, len2);
        int[] res = new int[max+1];
        
        while(max > min) {
        		if(len1 > len2) {
        			res[res.length-max] += l1.val;
        			l1 = l1.next;
        			max--;
        		}else {
        			res[res.length-max] += l2.val;
        			l2 = l2.next;
        			max--;
        		}
        }
        while(max >= 1) {
        		res[res.length-max] += (l1.val+l2.val);
			l1 = l1.next;
			l2 = l2.next;
			max--;
        }
        
        for(int i=res.length-1;i>=0;i--) {
        		if(res[i] > 9) {
        			res[i-1]++;
        			res[i] %= 10;
        		}
        }
        
        ListNode result = new ListNode(0);
        ListNode temp = new ListNode(0);
        result.next = temp;
        if(res[0] != 0) {
        		temp.next = new ListNode(res[0]);
        		temp = temp.next;
        }
        
        for(int i=1;i<res.length;i++) {
        		temp.next = new ListNode(res[i]);
        		temp = temp.next;
        }
        
    		return result.next.next;
    }
}
