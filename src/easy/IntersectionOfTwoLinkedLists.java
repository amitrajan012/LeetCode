package easy;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Solution approach 1: Time Complexity - O(mn)
		//Use 2 nested loops and iterate over lists separately 
		
		//Solution approach 2: Time Complexity - O(m+n) but extra space is needed of data structure is modified
		//Have a visited flag with each node and iterate over the first list and marks the flag as visited.
		//Iterate over the second list and if a visited node is encountered again, an intersection is found and hence return the node
		
		//Solution approach 3: Time Complexity - O(m+n) and O(1) space needed
		//Get the difference of node counts (let it be d) in both the lists
		//Traverse the bigger list from head up to d nodes and finally traverse both the lists in parallel until a common node is found
		//Return the node as the intersection point
		
		//Implementation of Approach 3
		int countA = getCount(headA);
		int countB = getCount(headB);
		
		System.out.println("Node count in List A: " +countA);
		System.out.println("Node count in List B: " +countB);
		
		int d = Math.abs(countA-countB);
		
		//Traverse the larger list up to the difference in node count
		if(countA > countB) {
			while(d>0) {
				d--;
				headA = headA.next;
			}
		}else {
			while(d>0) {
				d--;
				headB = headB.next;
			}
		}
		
		//Traverse both the list in parallel and return the result if intersection is found
		while(headA != null) {
			if(headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
    }
	
	int getCount(ListNode node) {
		//Returns the node counts in a list 
		int count = 0;
		ListNode current = node;
		
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
