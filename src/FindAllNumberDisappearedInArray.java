import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedInArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans= new ArrayList<Integer>();
		boolean arr[]=new boolean[nums.length+1];
		for(int i=0;i<nums.length;i++)
		{
			arr[nums[i]]=true;
		}
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==false)
				ans.add(i);
		}
		return ans;
    }
}
