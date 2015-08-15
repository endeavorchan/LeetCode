package surroundedRegions;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void test() {
		char[][] input =  {{'O', 'O', 'O', 'O', 'X', 'X'},
				           {'O', 'O', 'O', 'O', 'O', 'O'},
				           {'O', 'X', 'O', 'X', 'O', 'O'},
				           {'O', 'X', 'O', 'O', 'X', 'O'},
				           {'O', 'X', 'O', 'X', 'O', 'O'},
				           {'O', 'X', 'O', 'O', 'O', 'O'} };
		printBoard(input);
		Solution sol = new Solution();
		sol.solve(input);
		printBoard(input);
		
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


