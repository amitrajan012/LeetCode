import java.util.Stack;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		//Base case
		if(head == null || head.next == null) {
			//Palindrome
			return true;
		}
		//Push the value of nodes on stack and pop it and recheck it with the values on the linked list
		Stack<Integer> temp = new Stack<Integer>();
		ListNode a = head;
		
		while(a.next != null) {
			temp.push(a.val);
			a = a.next;
		}
		//Push the last element
		temp.push(a.val);
		//Check the linked list again
		while(!temp.isEmpty()) {
			if(head.val != temp.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
    }
}