import java.util.Arrays;

public class ConvertSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        //Base case
		if(nums == null || nums.length == 0){
			return null;
		}
		
		//Make middle element root
		int middle = (nums.length-1)/2;
		TreeNode node =  new TreeNode(nums[middle]);
		
		//Recursively call for left and right subtree
		node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
		node.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle+1, nums.length ));
		return node;
    }
}
