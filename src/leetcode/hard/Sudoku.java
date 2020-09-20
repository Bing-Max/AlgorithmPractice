package leetcode.hard;

import java.util.Arrays;

import sun.security.util.Length;

class Sudoku {

	private boolean[][] rows;
	private boolean[][] cols;
	private boolean[][] cells;

	private char[][] board;

	public static void main(String[] args) {

		char[][] board = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
				
		Sudoku sudoku = new Sudoku();
		sudoku.solveSudoku(board);
	}

	public void solveSudoku(char[][] board) {
		this.board = board;
		this.rows = new boolean[10][10];
		this.cols = new boolean[10][10];
		this.cells = new boolean[10][10];
		
		int rowIndex = -1;
		int colIndex = -1;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					int val = board[i][j] - '0';
					rows[i][val] = true;
					cols[j][val] = true;
					cells[i / 3 * 3 + j / 3][val] = true;
					continue;
				}
				
				if(rowIndex == -1) {
					rowIndex = i;
					colIndex = j;
				}
			}
		}
		
		setVal(rowIndex, colIndex);
		
		board = this.board;
		

	}

	public boolean setValIndex(int i, int j, int val) {
		int cell = i / 3 * 3 + (j / 3);
		if (rows[i][val] || cols[j][val] || cells[cell][val]) {
			return false;
		}

		return true;
	}
	
	public boolean win() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == '.') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean setVal(int i, int j) {
		for (int k = 1; k < 10; k++) {
			if (setValIndex(i, j, k)) {
				board[i][j] = (char) (k + '0');
				rows[i][k] = true;
				cols[j][k] = true;
				cells[i / 3 * 3 + j / 3][k] = true;
//				System.out.println(Arrays.toString(board[i]));
				
				int nextRow = i;
				int nextCol = j;
				while (nextRow < board.length) {
					if (nextCol < board[0].length && board[nextRow][nextCol] != '.') {
						nextCol++;
						continue;
					}

					if (nextCol >= board[0].length) {
						nextRow++;
						nextCol = 0;
						continue;
					}

					if (!setVal(nextRow, nextCol)) {
						board[i][j] = '.';
						rows[i][k] = false;
						cols[j][k] = false;
						cells[i / 3 * 3 + j / 3][k] = false;
						System.out.println(Arrays.toString(board[i]));
						break;
					}
				}
				
				if(win()) {
					return true;
				}

			}
		}

		return false;
	}
}
