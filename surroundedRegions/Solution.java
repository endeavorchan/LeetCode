package surroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private Queue<Integer> queue = new LinkedList<Integer>();
	
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
			if (board[i][n - 1] == 'O') {
				bfs(board, i, n - 1);
			}
		}
		
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				bfs(board, 0, j);
			}
			if (board[m - 1][j] == 'O') {
				bfs(board, m - 1, j);
			}
		}
		
		this.printBoard(board);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	private void bfs(char[][] board, int i, int j) {
		int n = board[0].length;
		fillCell(board, i, j);
		
		while (!queue.isEmpty()){
			int cur = queue.poll();
			int x = cur / n;
			int y = cur % n;
			
			fillCell(board, x - 1, y);
			fillCell(board, x + 1, y);
			fillCell(board, x, y - 1);
			fillCell(board, x, y + 1);
		}
	}

	private void fillCell(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
			return;
		queue.offer(i * n + j);
		board[i][j] = '#';
	}
	
	private void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();;
		}
		System.out.println();
	}
}
