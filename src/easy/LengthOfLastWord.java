package easy;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		//If string is empty or null return 0
		//Trim trailing and leading spaces
		s = s.trim();
		if(s==null || s.length()==0){
			return 0;
		}
		
		//Start from the end and find the index of last space and hence length of the word
		int length = 0;
		for(int i=s.length()-1;i>=0;i--){
			if(s.charAt(i) == ' '){
				//If space break the loop
				break;
			}else{
				//Increase the count
				length++;
			}
		}
		
		return length;
    }
}
