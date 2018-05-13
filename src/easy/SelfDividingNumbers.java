package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 */

public class SelfDividingNumbers {    
	public List<Integer> selfDividingNumbers(int left, int right) {
		//Find Self Dividing number in the range
        List<Integer> res = new ArrayList<Integer>();
        for(int i=left; i<=right; i++) {
        		if(helper(i))
        			res.add(i);
        }
		return res;
    }

	private boolean helper(int i) {
		int temp = i;
		while(temp > 0) {
			if(temp%10 == 0) {
				return false;
			}else if(i%(temp%10) != 0) {
				return false;	
			}
			temp /= 10;
		}
		return true;
	}
}
