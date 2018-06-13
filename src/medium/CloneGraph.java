package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/clone-graph/description/
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //Base case 
		if(node == null) return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		return cloneGraph(node, map);
    }

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone); //Means that node is already cloned
		for(UndirectedGraphNode child : node.neighbors) {
			UndirectedGraphNode childClone = map.get(child.label);
			if(childClone == null) {
				//Child not cloned
				childClone = cloneGraph(child, map);
			}
			clone.neighbors.add(childClone);
		}
		return clone;
	}
}
