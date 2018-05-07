
public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
        Integer firstMax = null, secondMax = null, thirdMax = null;
		for(Integer n : nums) {
			if(n.equals(firstMax) || n.equals(secondMax) || n.equals(thirdMax)) {
				continue;
			}
			if(firstMax == null || n > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = n;
			}else if(secondMax == null ||n > secondMax) {
				thirdMax = secondMax;
				secondMax = n;
			}else if(thirdMax == null || n > thirdMax) {
				thirdMax = n;
			}
		}
		return (thirdMax == null ? firstMax : thirdMax);
    }
}
