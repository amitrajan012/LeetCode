package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/car-fleet/description/
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        List<float[]> list = new ArrayList<>();
        for(int i=0;i<position.length;i++) {
        		list.add(new float[] {position[i], (float)(target-position[i])/(float)speed[i]});
        }
        Collections.sort(list, Comparator.comparing(i -> -i[0]));
        for(float[] A: list) {
        		System.out.println(Arrays.toString(A));	
        }
        
        int fleet = 0;
        for(int i=0;i<list.size();i++) {
        		float time = list.get(i)[1];
        		int j=i+1;
        		while(j < list.size() && Float.compare(list.get(j)[1], time) < 0) {
        			j++;
        		}
        		System.out.println(j);	
        		i=j;
        		fleet++;
        }
        
    		return fleet;
    }
}
