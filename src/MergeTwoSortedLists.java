/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
        
		if(l1.val < l2.val){
			//l1 is the start node
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else{
			//l2 is the start node
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
    	}
}

