package uglyNumber;

public class Solution {
	public boolean isUgly(int num) {
		if (num == 1) {
			return true;
		}
		if (num == 0) {
			return false;
		}
		
		return unwrap(num) == 1;
		
		
	}
	public int unwrap(int num) {
		int unwrapped = num;
		while (unwrapped % 2 == 0) {
			unwrapped /= 2;
		}
		while (unwrapped % 3 == 0) {
			unwrapped /= 3;
		}
		while (unwrapped % 5 == 0) {
			unwrapped /= 5;
		}
		return unwrapped;
	}
}
