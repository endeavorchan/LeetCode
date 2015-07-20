package nqueen;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	public int totalNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		enumerate(n, result);
		return result.size();
	}
	public void enumerate(int n, List<String[]> result) {
		int[] a = new int[n];
		enumerate(a,0, result);
	}
	public void enumerate(int[] q, int n, List<String[]> result) {
		int N = q.length;
		if (n == N)  addToList(q, result);
		else {
			for (int i = 0; i < N; i++) {
				q[n] = i;
				if (isConsistent(q, n)) enumerate(q, n+1, result);
			}
		}
	}
	private boolean isConsistent(int[] q, int n) {
		for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;  
            if ((q[i] - q[n]) == (n - i)) return false;   
            if ((q[n] - q[i]) == (n - i)) return false;  
        }
        return true;
	}
	private void addToList(int[] q, List<String[]> result) {
		String[] board = new String[q.length];
		for(int i = 0; i < q.length; i++) {
			String line = "";
			for (int j = 0; j < q.length; j++) {
				if (q[i] == j) line += "Q";
				else line += ".";
			}
			board[i] = line;
			System.out.println(line);
		}
		
		result.add(board);
		System.out.println("--------------------");
		
		
	}
	
	
}
