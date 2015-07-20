package permutations2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {
		int[] testNums = {1, 1, 2};
		Solution sol = new Solution();
		List<List<Integer>> result = sol.permuteUnique(testNums);
		print(result);
	}
	@org.junit.Test
	public void test2() {
		int[] testNums = {1, 1, 2};
		Solution2ProgramCreek sol = new Solution2ProgramCreek();
		ArrayList<ArrayList<Integer>> result = sol.permuteUnique(testNums);
		print(result);
	}
	
	public void print(List<List<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}
	
	public void print(ArrayList<ArrayList<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}

}
