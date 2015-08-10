package shortestPalindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestString {

	@Test
	public void test() {
		Solution sol = new Solution();
		String a = sol.shortestPalindrome("aba");
		System.out.println(a);
	}

}
