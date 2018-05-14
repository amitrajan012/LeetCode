package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/positions-of-large-groups/description/
 *
 */

public class PositionOfLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //Base case
        if(S == null || S.length() <=2) {
        		return res;
        }
        int startIndex = 0, endIndex = -1;
        for(int i=1;i<S.length();i++) {
        		if(S.charAt(i-1) == S.charAt(i)) {
        			//Same character found
        			endIndex = i;
        		}else {
        			if(endIndex-startIndex >=2) {
        				//Add start and end index of large groups
        				res.add(Arrays.asList(new Integer[] { startIndex, endIndex}));
        			}
        			//Reset start and end Index
        			startIndex = i;
        			endIndex = i;
        		}
        }
        
        if(endIndex-startIndex >=2) {
			//Add start and end index of large groups
			res.add(Arrays.asList(new Integer[] { startIndex, endIndex}));
		}
        
        return res;
    }
}
