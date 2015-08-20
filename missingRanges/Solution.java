package missingRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	
        List<String> res = new ArrayList<String>();
        if (lower > upper)
        	return res;
        if (nums == null || nums.length == 0) {
        	if (lower == upper) 
        		res.add(Integer.toString(lower));
        	else 
        		res.add(lower + "->" + upper);
        	return res;
        }
        
        if (nums[0] > lower) {
        	if (nums[0] == lower + 1) {
        		res.add(Integer.toString(lower));
        	} else {
        		res.add(lower + "->" + (nums[0] - 1));
        	}
        }
        
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > nums[i - 1] + 1) {
        		if (nums[i] == nums[i - 1] + 2) {
        			res.add(Integer.toString(nums[i - 1] + 1));
        		}
        		else {
        			res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
        		}
        	}
        }
        
        if (nums[nums.length - 1] < upper) {
        	if (nums[nums.length - 1] == upper - 1) 
        		res.add(Integer.toString(upper));
        	else 
        		res.add((nums[nums.length - 1] + 1) + "->" + upper);
        }
        
        return res;
    }
}
