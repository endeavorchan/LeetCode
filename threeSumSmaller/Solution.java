package threeSumSmaller;

import java.util.Arrays;

public class Solution {
	public int threeSumSmaller(int[] nums, int target) {
		int n = nums.length;
		Arrays.sort(nums);
		
		int count = 0;
		for (int k = 0; k < n - 2; k++) {
			int i = k + 1;
			int j = n - 1;
			while (i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum >= target) {
					j--;
				} 
				else {
					count += j - i;
					i++;
				}
			}
		}
		return count;
	}
	
}
