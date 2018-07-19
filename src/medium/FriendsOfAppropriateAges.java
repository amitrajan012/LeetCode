package medium;
/*
 * https://leetcode.com/problems/friends-of-appropriate-ages/description/
 */
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
    		int[] count =  new int[121]; //Used to save count first and when count is processed sum is saved 
    		for(int age: ages) count[age]++;
    		int res = 0;
    		for(int i=1;i<121;i++) {
    			if(i > 14)
    				res += count[i] * (count[i]-1 + count[i-1] - count[i/2 + 7]);  // First term deals with the condition: B == A
    				//Second term deals with the condition: B >= A and B > 100 and A < 100
    				//Third term deals with the condition: B <= 0.5 * A + 7 {Here B should be less hence the term is subtracted}
    			count[i] += count[i-1]; //Store sum
    		}
    		return res;
    }
}
