package textJustification;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestSolution {

	@Test
	public void testSample() {
		String[] testString = {"This", "is", "an", "example", "of", "text", "justification."};
		Solution sol = new Solution();
		List<String> output = sol.fullJustify(testString, 16);
		for(String line : output) 
			System.out.println(line);
	}
	@Test 
	
	public void testSample2() {
		String[] testString = {"a", "b", "c", "d", "e"};
		Solution sol = new Solution();
		List<String> output = sol.fullJustify(testString, 1);
		for(String line : output) 
			System.out.println(line);
	}
	
	@Test
	public void testSample3() {
		String[] testString = {"Listen","to","many,","speak","to","a","few."};
		Solution sol = new Solution();
		List<String> output = sol.fullJustify(testString, 6);
		for(String line : output) 
			System.out.println(line);
	}
	
	
	@Test
	public void testSample4() {
		String[] testString = {"What","must","be","shall","be."};
		Solution sol = new Solution();
		List<String> output = sol.fullJustify(testString, 12);
		for(String line : output) 
			System.out.println(line);
	}

}
