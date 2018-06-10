package medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		//This solution not uses the property of the sorted list
		//Base case
		if(head == null) {
			return head;
		}
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> nodesToRemove = new HashSet<Integer>();
        ListNode iterator = head;
        while(iterator != null) {
        		if(set.contains(iterator.val)) {
        			nodesToRemove.add(iterator.val);
        		}else {
        			set.add(iterator.val);	
        		}
        		iterator = iterator.next;
        }
        
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode result = temp;
        while(temp.next != null) {
        		if(nodesToRemove.contains(temp.next.val)) {
        			//Remove the node
        			temp.next = temp.next.next;
        		}else{
                    temp = temp.next;   
                }
        }
        
		return result.next;
    }
	
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode temp = new ListNode(0);
        temp.next = head;
        while(temp.next != null) {
        		if(temp.next.next != null) {
        			if(temp.next.val == temp.next.next.val) {
        				
        			}
        		}
        }
		return null;
	}
}
