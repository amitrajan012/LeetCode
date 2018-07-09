package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 */
public class EncodeAndDecodeTinyURL {

}

class Codec {
	private final static int SHORTURL_LEN = 6;
	private Map<String, String> shortURLMap = new HashMap<>();
	private Map<String, String> longURLMap = new HashMap<>();
	private Random rand = new Random();
	
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longURLMap.containsKey(longUrl)) return longURLMap.get(longUrl);
        
        String shortURL = generateShortURL();
        shortURLMap.put(shortURL, longUrl);
        longURLMap.put(longUrl, shortURL);
        return shortURL;
    }

    private String generateShortURL() {
    		String s = randomGenerator();
    		while(shortURLMap.containsKey(s))
    			s = randomGenerator();
		return s;
	}

	private String randomGenerator() {
		StringBuilder s = new StringBuilder();
		for(int i=1;i<=SHORTURL_LEN;i++) {
			int r = rand.nextInt(62); //To cover 1-9, a-z, A-Z
			if(r<10) s.append(r);
			else if(r < 36) s.append((char)(r-10)+'a');
			else s.append((char)(r-36)+'A');
		}
		return s.toString();
	}

	// Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortURLMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));