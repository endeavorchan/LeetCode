package wordBreak2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		ArrayList[] dp = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			if (dp[i] == null)
				continue;
			for (String a : wordDict) {
				int len = a.length();
				int end = i + len;
				if (end > s.length())
					continue;
				if (s.substring(i, end).equals(a)) {
					if (dp[end] == null) {
						dp[end] = new ArrayList<String>();
					}
					ArrayList list = dp[end];
					list.add(a);
				}
			}
		}

		ArrayList<String> result = new ArrayList<String>();
		addWords(dp, dp.length - 1, result, "");
		return result;
	}

	private void addWords(ArrayList[] dp, int i, ArrayList<String> result, String temp) {
		if (i == 0) {
			result.add(temp);
		}
		ArrayList<String> curr = dp[i];
		if (curr == null)
			return;
		for (String a : curr) {
			String temp2 = (temp.equals("")) ? a : (a + " " + temp);
			addWords(dp, i - a.length(), result, temp2);
		}
		
	}
}
