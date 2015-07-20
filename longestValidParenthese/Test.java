package longestValidParenthese;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Solution sol = new Solution();
		String s = "[()][()()()";
		int length = sol.longestValidParentheses(s);
		System.out.println(length);
		System.out.println(s.length());
	}
	
	@org.junit.Test
	public void testLong() {
		Solution sol = new Solution();
		String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
		int length = sol.longestValidParentheses(s);
		System.out.println(length);
		System.out.println(s.length());
	}
}
