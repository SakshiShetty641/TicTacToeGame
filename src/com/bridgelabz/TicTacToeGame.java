package com.bridgelabz;

/**
 * Purpose - To simulate a Tic Tac Toe Game
 * @author Sakshi Shetty
 * @version 16.0
 * @since 2021-08-11
 */

public class TicTacToeGame {
	static char[] board = new char[10];

	/**
	 * This method implements to create an empty TicTacToe board
	 * @index This is used to initialize the index from 1 to 9
	 * @return board This will return the board
	 */
	public static char[] createBoard() {
		for (int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
		return board;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Tic Tac Toe Game");
		createBoard();
	}
}