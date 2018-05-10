package easy;

public class ValidPalindrome {
	public boolean isPalindrome(String s){
		//Base case
		if(s == null || s.length() == 0 || s.length() == 1){
			//Valid palindrome
			return true;
		}
		
		//Strip string of alphanumeric character
		String t =  s.replaceAll("[^A-Za-z0-9]", "");
		
		System.out.println(t);
		
		//Iterate over half of the string
		int loop_counter = t.length()/2-1;
		System.out.println(loop_counter);
		for(int i=0;i<=loop_counter;i++) {
			if(Character.toLowerCase(t.charAt(i)) != Character.toLowerCase(t.charAt(t.length()-1-i))) {
				//Not a valid palindrome
				return false;
			}
		}
		
		return true;
	}
}
