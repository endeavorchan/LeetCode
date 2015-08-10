package shortestPalindrome;

public class Solution {

	// S is the pattern to be preprocessed
	// output[i] is the failure index that output redirected to
	public static int[] KMPpreprocess(String S) {
		int[] pi = new int[S.length()];
		// init start of pi
		pi[0] = -1;
		// get each index in pi, i is the index being processed
		for (int i = 1; i < pi.length; i++) {
			int j = pi[i - 1];
			while (j != -1 && S.charAt(j + 1) != S.charAt(i)) {
				j = pi[j];
			}
			if (j == -1) {
				if (S.charAt(0) == S.charAt(i))
					pi[i] = 0;
				else
					pi[i] = -1;
			} else if (S.charAt(j + 1) == S.charAt(i)) {
				pi[i] = j + 1;
			}

		}

		return pi;
	}

	public static String reverse(String s) {
		char[] outC = new char[s.length()];
		for (int i = 0; i < outC.length; i++) {
			outC[i] = s.charAt(outC.length - 1 - i);
		}
		return new String(outC);
	}

	public String shortestPalindrome(String s) {
		String sPlus = s + "#" + reverse(s);
		int[] PI = KMPpreprocess(sPlus);
		int palinIndex = Math.min(PI[PI.length - 1], s.length() - 1);

		String nonPalin = s.substring(palinIndex + 1);
		String Palin = s.substring(0, palinIndex + 1);
		return reverse(nonPalin) + Palin + nonPalin;
	}
}