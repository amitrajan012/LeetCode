
public class SingleNumber {
	public int singleNumber(int[] nums) {
		//Use XOR to find the single number
		//Properties of XOR
		//Commutative : A xor B = B xor A
		//XOR with itself: A xor A = 0
		//XOR with 0 : A xor 0 = A
		//Hence all the numbers occurring twice will be XORed as 0 and when 0 XORed with single number will give the result
		int result = 0;
		for(int i=0;i<nums.length;i++) {
			result = result ^ nums[i];
		}
		return result;
    }
}
