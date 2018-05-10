package easy;

public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder(); 
		int count = 0;
		for(int i=S.length()-1;i>=0;i--) {
			if(S.charAt(i) != '-') {
				if(count==K) {
					//Add - and reset count
					sb.append('-');
					i = i+1; // No need to increase counter
					count = 0;
				}else {
					sb.append(Character.toUpperCase(S.charAt(i)));
					count++;
				}
			}
		}
		return sb.reverse().toString();
    }
}
