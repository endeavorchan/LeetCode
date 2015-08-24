package strobogrammaticNumber2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<String>();
        char[] current = new char[n];
        dfs(result, current, 0, n - 1);
        
        Collections.sort(result, new Comparator<String>() {
        	public int compare(String a, String b) {
        		return a.compareTo(b);
        	}
        });
        return result;
    }
    
    public void dfs(List<String> result, char[] current ,int start, int end) {
    	if (start > end) {
    		String currentString = new String(current);
    		result.add(currentString);
    	}
    	
    	if (start == end) {
    		current[start] = '1';
    		dfs(result, current, start + 1, end - 1);
    		current[start] = '8';
    		dfs(result, current, start + 1, end - 1);
    		current[start] = '0';
    		dfs(result, current, start + 1, end - 1);
    		
    	}
    	
    	if (start < end) {
    		current[start] = current[end] = '1';
    		dfs(result, current, start + 1, end - 1);
    		current[start] = current[end] = '8';
    		dfs(result, current, start + 1, end - 1);
    		if (start > 0) {
    			current[start] = current[end] = '0';
    			dfs(result, current, start + 1, end - 1);
    		}
    		
    		current[start] = '6';
    		current[end] = '9';
    		dfs(result, current, start + 1, end - 1);
    		
    		current[start] = '9';
    		current[end] = '6';
    		dfs(result, current, start + 1, end - 1);
    	}
    }
}