public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //sort numbers
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int num1, num2, i2;
        for(int i = 0; i < sorted.length - 1; i++) {
            num1 = sorted[i];
            i2 = Arrays.binarySearch(sorted, i + 1, sorted.length, target - num1);
            if (i2 > -1) {
                num2 = sorted[i2];
                int[] returnNum = new int[2];
                for(int j = 0; j < nums.length; j++) {
                    if (nums[j] == num1 || nums[j] == num2) {
                        if (returnNum[0] == 0)  {
                            returnNum[0] = j + 1;
                        }
                        else 
                            returnNum[1] = j + 1;
                    } 
                }
                return returnNum;
            }
        }
        return null;
    }
    
