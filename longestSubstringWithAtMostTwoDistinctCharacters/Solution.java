package longestSubstringWithAtMostTwoDistinctCharacters;

import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int maxLen = 0;
		String maxSubstring = null;
		int m = 0;
		
		if (s == null || s.length() == 0)
			return 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		int i;
		for ( i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.size() == 2 && !map.containsKey(c)) {
				if (i - m > maxLen) {
					System.out.println();
					maxLen = i - m;
					maxSubstring = s.substring(m, i);
				}
				
				int leftMost = s.length();
				for(Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() < leftMost) {
						leftMost = entry.getValue();
					}
				}
				
				m = leftMost + 1;
				map.remove(s.charAt(leftMost));
			}
			
			
			map.put(c, i);
		}
		
		maxLen = Math.max(maxLen, i - m);
		
		if (maxLen == 0)
			return s.length();
		return maxLen;
	}
}
