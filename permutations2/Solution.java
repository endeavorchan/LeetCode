package permutations2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
        	return result;
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        boolean[] isOutput = new boolean[nums.length];
        addPermutation(nums,permutation, result, isOutput);
        
        return result;
    }

	private void addPermutation(int[] nums,
			ArrayList<Integer> permutation, List<List<Integer>> result, boolean[] isOutput) {
		if (permutation.size() == nums.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>(permutation);
			result.add(temp);
		}
		else {
			HashSet<Integer> header = new HashSet<Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (!isOutput[i] && !header.contains(nums[i])) {
					isOutput[i] = true;
					header.add(nums[i]);
					permutation.add(nums[i]);
					addPermutation(nums, permutation, result, isOutput);
					isOutput[i] = false;
					permutation.remove(permutation.size() - 1);
				}
			}
		}
	}
}