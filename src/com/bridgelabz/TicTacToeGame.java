package com.bridgelabz;
import java.util.Scanner;
/**
 * Purpose - To simulate a Tic Tac Toe Game
 * @author Sakshi Shetty
 * @version 16.0
 * @since 2021-08-11
 */

public class TicTacToeGame {
	static char[] board = new char[10];
	static char playerChoice;
	static char computerChoice;

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

	/**
	 * This method allows user to choose X or O
	 * @return playerChoice will return option selected by the player
	 */
	public static char chooseOption(char choice) {
		if (choice == 'X') {
			playerChoice = 'X';
			computerChoice = 'O';
		} else if (choice == 'O') {
			playerChoice = 'O';
			computerChoice = 'X';
		} else
			System.out.println("Enter a valid Choice");
		return playerChoice;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Tic Tac Toe Game");
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an option X or O");
		char choice = sc.next().charAt(0);
		createBoard();
		chooseOption(choice);
		sc.close();
	}
}