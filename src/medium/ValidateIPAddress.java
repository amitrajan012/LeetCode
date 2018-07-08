package medium;
/*
 * https://leetcode.com/problems/validate-ip-address/description/
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
    		if(isVlaidIPv4(IP)) return "IPv4";
    		else if(isValidIPv6(IP)) return "IPv6";
    		else return "Neither";
    }

	private boolean isValidIPv6(String iP) {
		if(iP.length() < 15) return false;
		if(iP.charAt(0) == ':') return false;
		if(iP.charAt(iP.length()-1) == ':') return false;
		
		String[] tokens = iP.split(":");
		if(tokens.length != 8) return false;
		for(String token: tokens) {
			if(!isValidIPv6Token(token)) return false; 
		}
		return true;
	}

	private boolean isValidIPv6Token(String token) {
		if(token.length() == 0 || token.length() > 4) return false;
		char[] chars = token.toCharArray();
		for(char c: chars) {
			boolean isDigit = (c>=48 && c<=57);
			boolean isAF_af = (c>=65 && c<=70) || (c>=97 && c<=102);
			if(!(isDigit || isAF_af)) return false;
		}
		return true;
	}

	private boolean isVlaidIPv4(String iP) {
		if(iP.length() < 7) return false;
		if(iP.charAt(0) == '.') return false;
		if(iP.charAt(iP.length()-1) == '.') return false;
		
		String[] tokens = iP.split("\\.");
		if(tokens.length != 4) return false;
		for(String token: tokens) {
			if(!isValidIPv4Toke(token)) return false;
		}
		return true;
	}

	private boolean isValidIPv4Toke(String token) {
		if(token == null || token.length() == 0) return false;
		if(!Character.isDigit(token.charAt(0))) return false;
		if(token.startsWith("0") && token.length() > 1) return false;
		try {
			int val = Integer.parseInt(token);
			if(val < 0 || val > 255) return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
