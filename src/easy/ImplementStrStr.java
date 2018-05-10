package easy;

public class ImplementStrStr {
	public static int strStr(String haystack, String needle){
		
		//Case of empty string and corner case
		if((haystack == null && needle == null) ||(haystack.length() == 0 && needle.length() ==0)){
			return 0;
		}
		
		int countCharacter = 0;
		int index = -1;
		for(int i=0;i<haystack.length();i++){
			countCharacter = 0;
			for(int j=0;j<needle.length();j++){
				//Check if the length of remaining haystack is as long as needle
				if(haystack.length()-1-i < needle.length()-1-j){
					System.out.println("Inside break 1");
					break;
				}
				if(needle.charAt(j) == haystack.charAt(i+j)){
					//If character matches increase the count of the match
					countCharacter++;
				}else{
					//Else break
					break;
				}
			}
			
			//If count of character match equals the length of needle match found 
			//Break from the outer loop
			if(countCharacter == needle.length()){
				index = i;
				break;
			}
		}
		 return index;
	}
}
