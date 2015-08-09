package longestSubstringWithAtMostTwoDistinctCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResult {

	@Test
	public void test() {
		Solution sol = new Solution();
		int result = sol.lengthOfLongestSubstringTwoDistinct("ab");
		System.out.println(result);
		result = sol.lengthOfLongestSubstringTwoDistinct("a");
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		Solution sol = new Solution();
		int result = sol.lengthOfLongestSubstringTwoDistinct("bacc");
		System.out.println(result);
	}
	
	

}
