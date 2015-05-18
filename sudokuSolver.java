
import java.util.ArrayList;

public class Solution {

	int[][] intBoard;
	ArrayList<Integer>[][] candidateBoard;
	ArrayList<Pair> emptyLocations = new ArrayList<Pair>();
	boolean[] occurredNumbers;

	public void solveSudoku(char[][] board) {
		intBoard = new int[board.length][board.length];
		candidateBoard = new ArrayList[board.length][board.length];

		// init
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++) {
				candidateBoard[i][j] = null;
				if (board[i][j] == '.')
					intBoard[i][j] = 0;
				else
					intBoard[i][j] = (char) (board[i][j] - '0');
			}

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++)
				compuateCandidates(i, j);

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++)
				if (this.candidateBoard[i][j] != null)
					this.emptyLocations.add(new Pair(i, j));

		solveBoard(0);
		
		
		//udpate board
		for (int i = 0; i < this.intBoard.length; i++) {
			for (int j = 0; j < this.intBoard.length; j++)  {
				if (board[i][j] == '.')
					board[i][j] = (char) (this.intBoard[i][j] + '0');
//				System.out.print(board[i][j]);
			}
//			System.out.println();
		}

	}

	private boolean solveBoard(int i) {
		if (i == this.emptyLocations.size())
			return true;

		int row = this.emptyLocations.get(i).x;
		int column = this.emptyLocations.get(i).y;

		for (int candidate : this.candidateBoard[row][column]) {
			
		
			intBoard[row][column] = candidate;
			if (isValidMove(row, column)) {
				if (solveBoard(i + 1) == true)
					return true;
			}
		}
		intBoard[row][column] = 0;
		return false;
	}

	private boolean isValidMove(int row, int column) {
		this.occurredNumbers = new boolean[10];

		// check row
		for (int i = 0; i < this.occurredNumbers.length; i++)
			this.occurredNumbers[i] = false;

		for (int i = 0; i < this.intBoard.length; i++) {
			if (this.occurredNumbers[this.intBoard[row][i]] == true
					&& this.intBoard[row][i] != 0)
				return false;
			else
				this.occurredNumbers[this.intBoard[row][i]] = true;
		}

		// check column
		for (int i = 0; i < this.occurredNumbers.length; i++)
			this.occurredNumbers[i] = false;

		for (int i = 0; i < this.intBoard.length; i++) {
			if (this.occurredNumbers[this.intBoard[i][column]] == true
					&& this.intBoard[i][column] != 0)
				return false;
			else
				this.occurredNumbers[this.intBoard[i][column]] = true;
		}

		// check box
		int boxSection = (int) Math.sqrt(this.intBoard.length);
		for (int i = 0; i < this.occurredNumbers.length; i++)
			this.occurredNumbers[i] = false;

		for (int i = 0; i < boxSection; i++) 
			for (int j = 0; j < boxSection; j++) {
				if (this.occurredNumbers[this.intBoard[boxSection * (row / boxSection) + i][boxSection * (column / boxSection) + j]] == true
						&& this.intBoard[boxSection * (row / boxSection) + i][boxSection * (column / boxSection) + j] != 0) 
					return false;
				else 
					this.occurredNumbers[this.intBoard[boxSection * (row / boxSection) + i][boxSection * (column / boxSection) + j]] = true;
			}
		return true;
	}

	private void compuateCandidates(int row, int column) {
		if (intBoard[row][column] > 0)
			return;

		boolean[] candidates = new boolean[10];

		for (int i = 0; i < 10; i++)
			candidates[i] = true;
		// scan row
		for (int i = 0; i < intBoard.length; i++) {
			candidates[intBoard[row][i]] = false;
		}

		// scan column
		for (int i = 0; i < intBoard.length; i++) {
			candidates[intBoard[i][column]] = false;
		}

		// scan box
		int boxSection = (int) Math.sqrt(this.intBoard.length);
		for (int i = 0; i < boxSection; i++)
			for (int j = 0; j < boxSection; j++) {
				candidates[intBoard[boxSection * (row / boxSection) + i][boxSection * (column / boxSection) + j]] = false;
			}

		ArrayList<Integer> candidateList = new ArrayList<Integer>();

		for (int i = 1; i <= 9; i++)
			if (candidates[i] == true)
				candidateList.add(i);

		this.candidateBoard[row][column] = candidateList;

	}
}

class Pair {
	public int x;
	public int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
