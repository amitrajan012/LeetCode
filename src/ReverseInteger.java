
public class ReverseInteger {
	public static int reverse(int x){
		//Convert integer to string
		String str = Integer.toString(x);
		if(str.length() == 1 || (str.length() == 2 && str.charAt(0) == '-')){
			return x;
		}
		
		//Remove trailing zeroes
		int lastIndex = str.length()-1;
		for(int i=str.length()-1;i>0;i--){
			if(str.charAt(i) != '0'){
				lastIndex = i;
				break;
			}
		}
		
		
		String finalString = str.substring(0, lastIndex+1);
		if(finalString.charAt(0) == '-'){
			//Its a negative number
			String finalAnswer = '-' + new StringBuilder().append(finalString.substring(1)).reverse().toString();
			try{
				System.out.println(Integer.parseInt(finalAnswer));
				return Integer.parseInt(finalAnswer);	
			}catch(Exception e){
				System.out.println("Inside exception");
				return 0;
			}
		}else{
			String finalAnswer = new StringBuilder().append(finalString).reverse().toString();
			try{
				System.out.println(Integer.parseInt(finalAnswer));
				return Integer.parseInt(finalAnswer);
			}catch(Exception e){
				System.out.println("Inside exception");
				return 0;
			}
		}
	}
}
