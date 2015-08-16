package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(num == null || num.length == 0)
	        return result;
	 
	    Arrays.sort(num);            
	 
	    ArrayList<Integer> temp = new ArrayList<Integer>();    
	    getCombination(num, 0, target, temp, result);
	 
	    HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
	 
	    //remove duplicate lists
	    result.clear();
	    result.addAll(set);
	 
	    return result;
	}
	 
	public void getCombination(int[] num, int start, int target, ArrayList<Integer> temp, List<List<Integer>> result){
	    if(target == 0){
	        ArrayList<Integer> t = new ArrayList<Integer>(temp);
	        result.add(t);
	        return;
	    }
	 
	    for(int i=start; i<num.length; i++){
	        if(target < num[i])
	            continue;
	 
	        temp.add(num[i]);
	        getCombination(num, i+1, target-num[i], temp, result);
	        temp.remove(temp.size()-1);
	    }
	}
}
