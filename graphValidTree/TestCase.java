package graphValidTree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void test() {
		int[][] edges = { {0, 1},
				          {0, 2},
				          {1, 2},
				          {2, 3},
				          {2, 4},
		};
		Solution sol = new Solution();
		boolean result = sol.validTree(5, edges);
		System.out.println(result);
		
		int[][] edges2 = { {0, 1},
				           {2, 3}
		};
		boolean result2 = sol.validTree(4, edges2);
		System.out.println(result2);
	
	}

}
