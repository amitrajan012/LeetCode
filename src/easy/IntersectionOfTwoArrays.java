package easy;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> hs1 = new HashSet<>();
		HashSet<Integer> intersection = new HashSet<>();
		for(int i=0;i<nums1.length;i++) {
			hs1.add(nums1[i]);
		}
		
		for(int i=0;i<nums2.length;i++) {
			if(hs1.contains(nums2[i])) {
				intersection.add(nums2[i]);
			}
		}
		int[] result = new int[intersection.size()];
        int i = 0;
        for (Integer num : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
