package strobogrammaticNumber2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestCase {

	@Test
	public void test() {
		Solution sol = new Solution();
		List<String> result = sol.findStrobogrammatic(2);
		System.out.println(Arrays.toString(result.toArray()));
	}

}
