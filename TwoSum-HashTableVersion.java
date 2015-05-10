import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> indexMap = new Hashtable<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
            indexMap.put(nums[i], i);
        for(int i1 = 0; i1 < nums.length; i1++) {
            Integer i2 = indexMap.get(target - nums[i1]);
            if (i2 != null && i2 != i1) {
                int i2Num = i2.intValue();
                int returnNums[] = new int[2];
                returnNums[0] = (i1 > i2Num) ? (i2Num + 1) : (i1 + 1);
                returnNums[1] = (i1 > i2Num) ? (i1 + 1) : (i2 + 1);
                return returnNums;
            }
        }
        return null;
    }
    
}
