package palindromePartitioningDFS;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
    	List<List<String>> resultList = new ArrayList<List<String>>();
    	if (s == null || s.length() == 0)
    		return resultList;
    	ArrayList<String> partition = new ArrayList<String>();

    	addPalindrome(s, 0, partition, resultList);
        return resultList;
        
    }
    private void addPalindrome(String s, int start, ArrayList<String> partition, 
    		List<List<String>> result) {
    	if (start == s.length()) {
    		ArrayList<String> temp = new ArrayList<String>(partition);
    		result.add(temp);
    		return;
    	}
    	for (int i = start + 1; i <= s.length(); i++) {
    		String str = s.substring(start, i);
    		if (isPalindrome(str)) {
    			partition.add(str);
    			addPalindrome(s, i, partition, result);
    			partition.remove(partition.size() - 1); // to restore recursively 
    			// to show restore is correct.
    			System.out.print("start is " + start + "[");
    			for (int j = 0; j < partition.size(); j++) {
    				System.out.print(partition.get(j) + ",");
    			}
    			System.out.println("]");
    		}
    	}
    }
    private boolean isPalindrome(String str) {
    	int left = 0;
    	int right = str.length() - 1;
     
    	while (left < right) {
    		if (str.charAt(left) != str.charAt(right)) {
    			return false;
    		}
     
    		left++;
    		right--;
    	}
     
    	return true;
    }
}
