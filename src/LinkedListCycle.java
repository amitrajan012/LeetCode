
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        //Determine if linked list has cycle or not
		//Run two pointers : One is fast moving and the other is slow
		//If linked list has cycle, both the pointers will meet otherwise loop will terminate
		ListNode fast = head;
		ListNode slow = head;
		
		//Check for the fast pointer's next to be null
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		//When end of the list is reached
		return false;
    }
}

