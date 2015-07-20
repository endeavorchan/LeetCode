package interleavingString;
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {  	
    	if (s1 == null || s2 == null || s3 == null)
    		return false;
    	if (s1.length() + s2.length() != s3.length())
    		return false;
    	int m = s1.length();
    	int n = s2.length();
    	boolean[][] isInterleaving = new boolean[m + 1][n + 1];
    	isInterleaving[0][0] = true;
    	for (int i = 0; i < s3.length(); i++) {
    		for (int j = 0; j <= i && j < s1.length(); j++) {
    			if (i - j <= s2.length() && 
    					s3.charAt(i) == s1.charAt(j) && isInterleaving[j][i - j]) {
    				isInterleaving[j + 1][i - j] = true;
    			}
    		}
    		for (int j = 0; j <= i && j < s2.length(); j++) {
    			if (i - j <= s1.length() &&
    					s3.charAt(i) == s2.charAt(j) && isInterleaving[i - j][j]){
    				isInterleaving[i - j][j + 1] = true;
    			}
    		}
    	}
        return isInterleaving[m][n];
    }
}
