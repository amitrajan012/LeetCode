package easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		
		if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        //Loop till the shorter string
		int length_a = a.length()-1;
		int length_b = b.length()-1;
		
		int carry = 0;
		int m = 0;
		int n = 0;
		StringBuilder result = new StringBuilder("");
		while(length_a>=0 || length_b>=0){
			if(length_a>=0){
				//Add from string a
				if(a.charAt(length_a) == '0'){
					m=0;
				}else{
					m=1;
				}
				length_a--;
			}else{
				m=0;
			}
			
			if(length_b>=0){
				//Add from string b
				if(b.charAt(length_b) == '0'){
					n=0;
				}else{
					n=1;
				}
				length_b--;
			}else{
				n=0;
			}
			
			result.append(Integer.toString((m+n+carry)%2));
			carry = (m+n+carry)/2;
		}
		
			//Handle the carry only
		if(carry == 1){
			result.append('1');
		}
		
		return result.reverse().toString();
    }
}
