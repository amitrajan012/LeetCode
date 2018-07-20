package medium;

import java.util.TreeMap;

/*
 * https://leetcode.com/problems/advantage-shuffle/description/ 
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
    		TreeMap<Integer, Integer> map = new TreeMap<>();
    		for(int i: A) map.put(i, map.getOrDefault(i, 0)+1);
    		
    		int[] res = new int[A.length];
    		for(int i=0;i<B.length;i++) {
    			Integer temp = map.higherKey(B[i]);
    			if(temp == null) temp = map.firstKey();
    			map.put(temp, map.get(temp)-1);
    			
    			if(map.get(temp) == 0) map.remove(temp);
    			res[i] = temp;
    		}
    		return res; 
    }
}
