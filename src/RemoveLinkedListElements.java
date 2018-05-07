
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        
		// First shift the head if the value in the head equals the value to be removed
		while(head != null && head.val == val) {
			head = head.next;
		}
		
		ListNode current = head;
		while(current != null && current.next != null) {
			if(current.next.val == val) {
				//Remove the node and move the pointer
				current.next = current.next.next;
			}else {
				//Move the pointer
				current = current.next;
			}
		}
		return head;
    }
}

