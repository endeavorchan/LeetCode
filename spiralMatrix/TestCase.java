package spiralMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void test() {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		Solution sol = new Solution();
		sol.spiralOrder(matrix);
	}

}
