package palindromePartitioning2;

// we need to track two cache arrays.
public class Solution {
    public int minCut(String s) {
    	int n = s.length();
    	boolean[][] dp = new boolean[n][n];
    	int[] cut = new int[n];
    	if (s == null || s.length() == 0)
    		return 0;
    	for (int j = 0; j < n; j++) {
    		cut[j] = j; // set the minimum part;
    		// o(n ^ 2) cost
    		for (int i = 0; i <= j; i++) {
    			if ((s.charAt(i) == s.charAt(j)) && (j - i <= 1 || dp[i + 1][j - 1])) {
    				dp[i][j] = true;
    				//if need to cut, add 1 to previous cut 
    				if (i > 0 ) {
    					cut[j] = Math.min(cut[j], cut[i - 1] + 1);
    				}
    				else {
    					cut[j] = 0;
    				}
    			}
    		}
    	}
    	return cut[n - 1];
    }
}
