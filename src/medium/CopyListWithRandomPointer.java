package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        //Base case
		if(head == null) return null;
		Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
		return copyRandomList(head, map);
    }

	private RandomListNode copyRandomList(RandomListNode node, Map<Integer, RandomListNode> map) {
		RandomListNode clone = new RandomListNode(node.label);
		map.put(clone.label, clone);
		if(node.next != null) {
			RandomListNode nextNode = map.get(node.next.label);
			if(nextNode == null) {
				//Node not cloned
				nextNode = copyRandomList(node.next, map);
			}
			clone.next = nextNode;
		}
		if(node.random != null) {
			RandomListNode randomNode = map.get(node.random.label);
			if(randomNode == null) {
				//Node not cloned
				randomNode = copyRandomList(node.random, map);
			}
			clone.random = randomNode;
		}
		return clone;
	}
}
