package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/brick-wall/description/
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<wall.size();i++) {
        		//Access each row
        		List<Integer> row = wall.get(i);
        		int sum = 0;
        		for(int j=0;j<row.size()-1;j++) {
        			//Don't add the entire sum to the map as we can't cut there. Hence the loop does not find the last edge position
        			sum += row.get(j);
        			map.put(sum, map.getOrDefault(sum, 0)+1);
        		}
        }
        
        //Find the highest count in the map
        int max = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
        		max = Math.max(max, e.getValue());
        }
        
        return wall.size()-max;
    }
}
