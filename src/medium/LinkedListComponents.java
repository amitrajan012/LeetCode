package medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/linked-list-components/description/
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<> ();
        for(int i: G) set.add(i);
        int res = 0;
        while(head!=null) {
            if(set.contains(head.val)) res++;
            while(head!=null && set.contains(head.val)) {
                head = head.next;
            }
            if(head!=null) head = head.next;
        }
        return res;
    }
}
