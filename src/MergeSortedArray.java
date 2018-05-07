
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	
    	while(m > 0 && n > 0){
    		//Copy the elements in array nums1 as this has enough space
    		//Start from the end
    		if(nums1[m-1] > nums2[n-1]){
    			nums1[m+n-1] = nums1[m-1];
    			m--;
    		}else{
    			nums1[m+n-1] = nums2[n-1];
    			n--;
    		}
    	}
    	
    	//Copy rest of the elements
    	while(n>0){
    		nums1[m+n-1] = nums2[n-1];
    		n--;
    	}
        
    }
}
