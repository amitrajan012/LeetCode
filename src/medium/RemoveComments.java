package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/remove-comments/description/
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
    		//Join all the lines by delimiting them with \n
    		String[] S = String.join("\n",source).replaceAll("//.*|/\\*(.|\n)*?\\*/", "").split("\n");
    		List<String> ans = new ArrayList<>();
    	    for(String str : S) if(!str.equals("")) ans.add(str);
    	    return ans;
    }
}
