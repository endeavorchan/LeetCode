package jumpGame;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Solution sol = new Solution();
		int[] nums = {2, 0, 2, 0, 1};
		System.out.println(sol.jump(nums));
	}

}
