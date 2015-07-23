package wordBreak2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {
		HashSet<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		Solution sol = new Solution();
		List<String> result = sol.wordBreak("catsanddog", set);
		print(result);
	}
	private void print(List<String> list) {
		for (String a : list) {
			System.out.println(a);
		}
	}

}
