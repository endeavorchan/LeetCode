package singleNumber3;

public class Solution {
    public int[] singleNumber(int[] nums) {
     
    	int aXorB = 0;
    	
    	for (int num : nums) {
    		aXorB ^= num;
    	}
    	
    	int differentBit = 1;
    	while ((differentBit & aXorB) == 0) {
    		differentBit = differentBit << 1;
    	}
    	
    	int a = 0;
    	int b = 0;
    	for (int num : nums) {
    		if ((num & differentBit) == 0) {
    			a ^= num;
    		} else
    		{
    			b ^= num;
    		}
    	}
    	return new int[] {a, b};
    }
}
