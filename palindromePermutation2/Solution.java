package palindromePermutation2;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum  = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        long bound = n;
        bound *= n + 1;
        bound /= 2;
        int missingNum = (int) (bound - sum);
        return missingNum;
    }
}