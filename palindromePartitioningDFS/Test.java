package palindromePartitioningDFS;

import static org.junit.Assert.*;

import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {
		Solution sol = new Solution();
		print(sol.partition("aaa"));
	}
	
	public void print(List<List<String>> result) {
		for (int i = 0 ; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}

}
