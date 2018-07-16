package medium;
/*
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node = new ListNode(0);
        node.next = root;
        
        int len = 0;
        while(node.next != null) {
        		len++;
        		node = node.next;
        }
        
        int rem = len % k, elements = len/k;
        
        node = root;
        ListNode[] res = new ListNode[k];
        for(int i=0;i<k;i++) {
        		res[i] = new ListNode(0);
        		ListNode dummyHead = res[i];
        		for(int count=0; count<elements; count++){
        			dummyHead.next = new ListNode(node.val);
        			dummyHead = dummyHead.next;
        			node = node.next;
        		}
        		if(rem!=0) {
        			dummyHead.next = new ListNode(node.val);
        			dummyHead = dummyHead.next;
        			node = node.next;
        			rem--;
        		}
        		res[i] = res[i].next;
        }
    		return res;
    }
}
