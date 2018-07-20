package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        int countVisited = 0;
        queue.offer(0);
        
        while(!queue.isEmpty()) {
        		int room = queue.poll();
        		if(!visited[room]) {
        			countVisited++;
        			List<Integer> temp = rooms.get(room);
        			for(int i: temp) {
        				queue.offer(i);
        			}
        		}
        		if(countVisited == rooms.size()) return true;
        }
    		return false;
    }
}
