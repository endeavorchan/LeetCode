package permutations2;

import java.util.ArrayList;

//似乎也是 dfs 的解法。

public class SolutionProgramCreek {
	public ArrayList<ArrayList<Integer>> permutationUnique(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(nums, 0, result);
		return result;
	}

	private void permuteUnique(int[] nums, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start >=  nums.length) {
			ArrayList<Integer> item = convertArrayToList(nums);
			result.add(item);
		}
		for (int j = start; j < nums.length; j++) {
			if (containsDuplicate(nums, start, j)) { // make a new header 
				swap(nums, start, j);
				permuteUnique(nums, start + 1, result);
				swap(nums, start, j);
			}
		}
 		
	}

	private boolean containsDuplicate(int[] nums, int start, int end) {
		for (int i = start; i <= end - 1; i++) {
			if (nums[start] == nums[end])
				return false;
		}
		return true;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

	private ArrayList<Integer> convertArrayToList(int[] nums) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			item.add(nums[i]);
		}
		return item;
	}
}
