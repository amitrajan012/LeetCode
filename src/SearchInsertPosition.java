
public class SearchInsertPosition {
	 public static int searchInsert(int[] nums, int target){
		 
		 //Corner case handling
		 if(nums[nums.length-1] < target){
			 return nums.length;
		 }
		 int index = 0;
		 for(int i=0;i<nums.length;i++){
			 if(nums[i] < target){
				 continue;
			 }else{
				 index = i;
				 break;
			 }
		 }
		 return index;
	 }

}
