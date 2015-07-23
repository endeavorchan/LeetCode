package candy;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		int[] ratings = {4,2,3,4,1};
		Solution sol = new Solution();
		System.out.println(sol.candy(ratings));
	}

}
