package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/partition-labels/description/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = -1, pointer = 0;
        
        while(pointer < S.length()) {
        		if(right == -1) right = S.lastIndexOf(S.charAt(pointer));
        		if(pointer == right) {
        			res.add(right-left+1);
        			pointer++;
        			left = pointer;
        			right = -1;
        			continue;
        		}
        		int index = S.lastIndexOf(S.charAt(pointer));
        		right = Math.max(right, index);
        		if(right == S.length()-1) {
        			res.add(right-left+1);
        			break;
        		}
        		pointer++;
        }
        
    		return res;
    }
}
