package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/design-twitter/description/
 */
class Twitter {
	Map<Integer, Set<Integer>> following;
	Map<Integer, Set<Integer>> followers;
	List<int[]> tweets;
    /** Initialize your data structure here. */
    public Twitter() {
        following = new HashMap<>();
        followers = new HashMap<>();
        tweets = new ArrayList<>();
     }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    		int[] tweet = new int[2];
    		tweet[0] = userId; tweet[1] = tweetId;
		tweets.add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    		List<Integer> l = new ArrayList<>();
        //Get following users
    		Set<Integer> s = following.get(userId);
    		for(int i=tweets.size()-1;i>=0;i--) {
    			int[] tweet = tweets.get(i);
    			if(tweet[0] == userId || (s != null && s.contains(tweet[0]))) {
    				l.add(tweet[1]);
    			}
    			if(l.size() == 10) break;
    		}
    		return l;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
        followers.computeIfAbsent(followeeId, k -> new HashSet<Integer>()).add(followerId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    		Set<Integer> s1 = following.get(followerId);
    		if(s1 != null) {
    			s1.remove(followeeId);
    	        following.put(followerId, s1);
    		}
    		
        
        Set<Integer> s2 = followers.get(followeeId);
        if(s2 != null) {
        		s2.remove(followerId);
            followers.put(followeeId, s2);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */