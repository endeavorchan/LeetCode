package palindromePermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canPermutePalindrome(String s) {
    	if (s.length() < 1) 
    		return true;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for (char letter : s.toCharArray()) {
    		if (map.containsKey(letter) && map.get(letter) == 1) {
    			map.put(letter, 0);
    		} else {
    			map.put(letter, 1);
    		}
    	}
    	if (s.length() % 2 == 0) {
    		return !map.containsValue(1);
    	} else {
    		int count = Collections.frequency(new ArrayList<Integer>(map.values()), 1);
    		return count <= 1;
    	}
    }
}
