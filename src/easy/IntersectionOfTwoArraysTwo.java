package easy;
import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysTwo {
	public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0,pointer2 = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while((pointer1 < nums1.length) && (pointer2 < nums2.length)) {
        		if(nums1[pointer1] < nums2[pointer2]) {
        			pointer1++;
        		}else if(nums1[pointer1] > nums2[pointer2]) {
        			pointer2++;
        		}else {
        			result.add(nums1[pointer1]);
        			pointer1++;
        			pointer2++;
        		}
        }
        
        int[] intersection = new int[result.size()];
        for(int i=0;i<result.size();i++) {
        		intersection[i] = result.get(i);
        }
        return intersection;
    }
}
