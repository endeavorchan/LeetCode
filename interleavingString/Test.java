package interleavingString;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Solution sol = new Solution();
	//	System.out.println(sol.isInterleave("a", "a", "aa"));
		System.out.println(sol.isInterleave("aa", "ba", "aaba"));
	}

}
