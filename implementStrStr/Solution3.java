package implementStrStr;

// KMP method, using DFA
public class Solution3 {
	private String pat;
	private int[][] dfa;
	private void buildDFA(String pat) {
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];
			dfa[pat.charAt(j)][j] = j + 1;
			X = dfa[pat.charAt(j)][X];
		}
	}
	public int strStr(String txt, String pat) {
		int h = txt.length();
		int n = pat.length();
		if (n > h)
			return -1;
		if (n == 0)
			return 0;
		buildDFA(pat);
		return search(txt);
	}
	
	public int search(String txt) {
		int i, j, N = txt.length(), M = pat.length();
		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[txt.charAt(i)][j];
		if (j == M) return i - M;
		else return -1;
	}
}
