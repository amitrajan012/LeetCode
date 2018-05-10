package easy;

public class CountAndSay {
	public static String countAndSay(int n){
		
		String previousSequence = "11";
		
		if(n==1){
			return "1";
		}
		if(n==2){
			return "11";
		}
	
		for(int i=3;i<=n;i++){
			//Loop over the entire previous sequence 
			System.out.println("III>>>" +i);
			StringBuffer sb = new StringBuffer();
			//Take first character out
			Character c = previousSequence.charAt(0);
			int count = 1;
			for(int j=1;j<previousSequence.length();j++){
				//For the last character
				if(j == previousSequence.length()-1){
					if(c == previousSequence.charAt(j)){
						//If match found
						//Increase the count and add the sequence
						count++;
						sb.append(Integer.toString(count));
						sb.append(c);
					}else{
						//Add previous character and the last one
						sb.append(Integer.toString(count));
						sb.append(c);
						sb.append("1");
						sb.append(previousSequence.charAt(j));
					}
				}else{
					if(c == previousSequence.charAt(j)){
						//If match found
						//Increase the count
						count++;
					}else{
						//Add previous character and the last one
						sb.append(Integer.toString(count));
						sb.append(c);
						//Reset count
						c = previousSequence.charAt(j);
						count = 1;
					}
				}
			}
			System.out.println(sb.toString());
			previousSequence = sb.toString();
		}
		return previousSequence;
	}
}
