package medium;

/*
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 */
public class MaximumProductOfWorldLengths {
    public int maxProduct(String[] words) {
    		if(words == null || words.length == 0) return 0;
    		int len = words.length;
    		int[] value = new int[len];
    		for(int i=0;i<len;i++) {
    			String temp = words[i];
    			for(Character c: temp.toCharArray()) {
    				value[i] |= 1 << (c - 'a');
    			}
    		}
    		
    		int max = 0;
    		for(int i=0;i<len;i++) {
    			for(int j=i+1;j<len;j++) {
    				if((value[i] & value[j]) == 0 && (words[i].length()*words[j].length() > max)) {
    					max = words[i].length()*words[j].length();
    				}
    			}
    		}
    		return max;
    }
}
