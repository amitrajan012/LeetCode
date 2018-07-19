package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0) return res;
        
        int nodeCount = graph.length;
        int[] color = new int[nodeCount]; //0 - not visited, 1 - safe, 2 - unsafe
        
        for(int i=0;i<nodeCount;i++) {
        		if(helper(graph, i, color)) res.add(i);
        }
    		return res;
    }

	private boolean helper(int[][] graph, int startNode, int[] color) {
		if(color[startNode] != 0) return color[startNode] == 1; //Node already visited and hence check whether it's safe or not
		
		color[startNode] = 2; //Mark it unsafe
		for(int node: graph[startNode]) { //Visit the neighboring nodes (DFS)
			if(!helper(graph, node, color)) return false; //If unsafe, mark the node unsafe as well
		}
		color[startNode] = 1;
		return true;
	}
}
