package factorCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        dfs(result, current, n);
        return result;
        
    }
    public void dfs(List<List<Integer>> result, List<Integer> current,  int remain) {
    	if (current.size() > 0 && remain >= current.get(current.size() - 1)) {
    		List<Integer> temp = new ArrayList<Integer>();
    		temp.addAll(current);
    		temp.add(remain);
    		result.add(temp);
    	}
    	
		int factor = (current.size() == 0) ? 2 : current.get(current.size() - 1);
		
		for (; factor < remain; factor++) {
			if (remain % factor == 0 && remain / factor >= factor) {
				current.add(factor);
				dfs(result, current, remain / factor);
				current.remove(current.size() - 1);
			}
		}
    }
}
