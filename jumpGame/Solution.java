package jumpGame;

public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        int[] steps = new int[nums.length];
        for (int i = 0; i < steps.length; i++)
            steps[i] = -1;
        steps[0] = 0;
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (steps[steps.length - 1] != -1)
                return steps[steps.length - 1];
            if (steps[i] != -1) {
                int currentJump = i + nums[i];
                if (currentJump > maxJump) {
                    for (int j = maxJump + 1; j <= currentJump && j < steps.length; j++) {
                        steps[j] = steps[i] + 1;
                    }
                    maxJump = currentJump;
                }
                
            }
        }
        return steps[steps.length - 1];
    }
}