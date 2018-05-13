package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 */

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int start = 0, end = letters.length-1;
		while(start+1 < end) {
			int mid = start + (end-start)/2;
			if(letters[mid] <= target) {
				start = mid;
			}else {
				end = mid;
			}
		}
        
		if(letters[start] > target) {
			return letters[start];
		}
		if(letters[end] > target) {
			return letters[end];
		}
		return letters[0];
    }
}
