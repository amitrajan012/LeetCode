package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/find-and-replace-in-string/description/
 */
public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        //Sort indexes in descending order (need to keep track of the corresponding index as well to retrieve the source and target)
    		//After this sorting values can be replaced in the original string as well
    		List<int[]> sortedList = new ArrayList<>();
    		for(int i=0; i<indexes.length;i++) sortedList.add(new int[] {indexes[i], i});
    		Collections.sort(sortedList, Comparator.comparing(i -> -i[0]));
    		
    		for(int[] index: sortedList) {
    			int i = index[0], j = index[1];
    			String s = sources[j], t = targets[j];
    			if(S.substring(i, i+s.length()).equals(s)) {
    				S = S.subSequence(0, i) + t + S.substring(i+s.length());
    			}
    		}
    		return S;
    }
}
