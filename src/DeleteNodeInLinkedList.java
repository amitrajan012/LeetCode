
public class DeleteNodeInLinkedList {
	public void deleteNode(ListNode node) {
		//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
		node.val = node.next.val;
		node.next = node.next.next;
		return;
    }
}
