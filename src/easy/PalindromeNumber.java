package easy;

public class PalindromeNumber {
	public static boolean isPalindrome(int x){
		String str = Integer.toString(x);
		String reverse;
		
		//For negative integers
		if(str.charAt(0) == '-'){
			reverse = new StringBuilder(str).reverse().toString();
		}else{
			reverse = new StringBuilder(str).reverse().toString();
		}
		
		System.out.println(reverse);
		if(str.compareTo(reverse) == 0){
			System.out.println("Inside true");
			return true;
		}else{
			System.out.println("Inside false");
			return false;
		}
	}
}
