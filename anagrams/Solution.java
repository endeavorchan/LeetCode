package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) 
			return result;
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String t = String.valueOf(arr);
			if (map.get(t) == null) {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(t, l);
			} else {
				map.get(t).add(i);
			}
		}
		
		for(ArrayList<Integer> l : map.values()) {
			if (l.size() > 0) {
			    ArrayList<String> temp = new ArrayList<String>();
				for (Integer i: l) {
					temp.add(strs[i]);
				}
				Collections.sort(temp);
				result.add(temp);
			}
		}
		
		return result;
	}
}
