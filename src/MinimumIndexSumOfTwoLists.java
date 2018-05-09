import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 *
 */
public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<String>();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<list1.length;i++) {
			map.put(list1[i], i);
		}
		for(int i=0;i<list2.length;i++) {
			if(map.containsKey(list2[i])) {
				int index = map.get(list2[i]);
				if(i+index < min) {
					result.clear();
					result.add(list2[i]);
					min = i+index;
				}else if(i+index == min) {
					result.add(list2[i]);
				}
			}
		}
		
		return result.toArray(new String[result.size()]);
	}
}
