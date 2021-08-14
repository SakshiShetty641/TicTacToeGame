package com.bridgelabz;
import java.util.Scanner;
/**
 * Purpose - To simulate a Tic Tac Toe Game
 * @author Sakshi Shetty
 * @version 16.0
 * @since 2021-08-11
 */

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	static char[] board = new char[10];
	static char playerChoice;
	static char computerChoice;

	/**
	 * This method implements to create an empty TicTacToe board
	 * 
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
	 * 
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

	/**
	 * This method is used to display the empty Tic Tac Toe board
	 */
	public static void showBoard() {
		System.out.println("Tic Tac Toe Board");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
	}

	/**
	 * This method allows the user to choose a desired location in the board To
	 * select between index 1 to 9 to make the move
	 */

	static void userPlay() {
		System.out.println("Enter board index(1-9) to set your game move ");
		int userMove = sc.nextInt();
		switch (userMove) {
		case 1:
			if (board[1] == ' ') {
				board[1] = playerChoice;
			}
			break;
		case 2:
			if (board[2] == ' ') {
				board[2] = playerChoice;
			}
			break;
		case 3:
			if (board[3] == ' ') {
				board[3] = playerChoice;
			}
			break;
		case 4:
			if (board[4] == ' ') {
				board[4] = playerChoice;
			}
			break;
		case 5:
			if (board[5] == ' ') {
				board[5] = playerChoice;
			}
			break;
		case 6:
			if (board[6] == ' ') {
				board[6] = playerChoice;
			}
			break;
		case 7:
			if (board[7] == ' ') {
				board[7] = playerChoice;
			}
			break;
		case 8:
			if (board[8] == ' ') {
				board[8] = playerChoice;
			}
			break;
		case 9:
			if (board[9] == ' ') {
				board[9] = playerChoice;
			}
			break;
		default:
			System.out.println("Invalid Move");
		}
		showBoard();
	}

	/**
	 * This method checks for free space for the computer to make the move
	 */
	static void move() {
		boolean played = false;
		while (!played) {
			int playMove = (int) (Math.random() * 10) % 9 + 1;
			if (playMove > 0 && playMove < 10) {
				if (board[playMove] == ' ') {
					board[playMove] = computerChoice;
					played = true;
				}
			}
		}
		showBoard();
	}

	static void toss() {
		int turn = (int) Math.floor(Math.random() * 10) % 2;
		System.out.println("To start the game enter 1 to play the toss: ");
		Scanner sc = new Scanner(System.in);
		int playerToss = sc.nextInt();
		if (playerToss == turn) {
			System.out.println("Player won the toss, enter your first Move");
			userPlay();
			move();

		} else {
			System.out.println("Computer won the toss, enter your first move");
			move();
			userPlay();

		}

	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Tic Tac Toe Game");
		System.out.println("Player choose an option X or O");
		char choice = sc.next().charAt(0);
		createBoard();
		chooseOption(choice);
		toss();
		sc.close();
	}
}