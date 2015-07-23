package regularExpression;

/**
 * The version of regular matching support following characters:
 * Character 	Meaning 
 * c 	Matches any literal character c. 
 * . 	Matches any single character. 
 * ^ 	Matches the beginning of the input string. 
 * $ 	Matches the end of the input string. 
 * * 	Matches zero or more occurrences of the previous character. 
 * @author yunxiaozou
 *
 */
public class SolutionProgramBeautifulCode {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		if (s.length() == 0 || p.length() == 0)
			return s.length() == 0 && p.length() == 0;
		if (p.charAt(0) == '^')
			return matchHere(s, p.substring(1));
		return false;
	}

	private boolean matchHere(String s, String substring) {
		// TODO Auto-generated method stub
		return false;
	}
}
