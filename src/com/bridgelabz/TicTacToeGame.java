package com.bridgelabz;
import java.util.Scanner;
import java.util.Locale;
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

	/**
	 * This method implements toss to assign accordingly whether the player or
	 * computer starts the game
	 */

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

	public static char playerWon(char[] board) {
		int[][] game = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 5, 9 }, { 3, 5, 7 }, { 1, 4, 7 }, { 2, 5, 8 },
				{ 3, 6, 9 } };
		char won = 'W';
		for (int i = 0; i < game.length; i++) {
			if (board[game[i][0]] == board[game[i][1]] && board[game[i][1]] == board[game[i][2]]) {
				if (board[game[i][0]] != ' ') {
					won = board[game[i][0]];
					break;
				}
			}
		}
		return won;
	}

	// method to check for empty spaces on game board
	public static boolean isBoardFilled(char[] board) {
		boolean filled = true;
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				filled = false;
				break;
			}
		}
		return filled;
	}

	// method to check game state
	public static char getGameState(char[] board, char user, char computer, char current) {
		char won = playerWon(board);
		char tie = ' ', state = ' ';
		if (current == user) {
			tie = computer;
		} else {
			tie = user;
		}
		switch (won) {
		case 'F':
			state = tie;
			break;
		case 'X':
			System.out.println("X has won the game");
			state = 'E';
			break;
		case 'O':
			System.out.println("O has won the game");
			state = 'E';
			break;
		}
		if (isBoardFilled(board)) {
			state = 'E';
		}
		return state;
	}

	public static int winningPosition(char userChoice, char[] board) {
		int[][] game = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 5, 9 }, { 3, 5, 7 }, { 1, 4, 7 }, { 2, 5, 8 },
				{ 3, 6, 9 } };
		int place = -1;
		for (int i = 0; i < game.length; i++) {
			if (board[game[i][0]] == userChoice && board[game[i][0]] == board[game[i][1]] && board[game[i][2]] == ' ') {
				if (board[game[i][0]] != ' ') {
					place = game[i][2];
				}
			}
			if (board[game[i][0]] == userChoice && board[game[i][0]] == board[game[i][2]] && board[game[i][1]] == ' ') {
				if (board[game[i][0]] != ' ') {
					place = game[i][1];
				}
			}
			if (board[game[i][1]] == userChoice && board[game[i][1]] == board[game[i][2]] && board[game[i][0]] == ' ') {
				if (board[game[i][1]] != ' ') {
					place = game[i][0];
				}
			}
		}
		return place;
	}

	static void computerSmartPlay() {
		 int[] border = {1, 3, 7, 9};
	        int[] center = {2, 4, 6, 8};
	        int placeWin = winningPosition(computerChoice, board);
	        int losing = winningPosition(playerChoice, board);
	        if (losing != -1) {
	            board[losing] = computerChoice;
	        } else if (placeWin != -1) {
	            board[placeWin] = computerChoice;
	        } else if (losing == -1 && placeWin == -1) {
	            for (int i = 0; i < border.length; i++) {
	                if (board[border[i]] == ' ') {
	                    board[border[i]] = computerChoice;
	                    break;
	                }
	            }
	        }
	        else{
	            if(board[5]==' '){
	                board[5]=computerChoice;
	            }else{
	                for(int i=0;i<center.length;i++){
	                    if(board[center[i]] == ' '){
	                        board[center[i]]=computerChoice;
	                        break;
	                    }
	                }
	            }
	        }
	        showBoard();
	    }

		public static void playTillEnd(char playerLetter, char[] board, char computerLetter) {
			char start = playerChoice;
			if (start == playerLetter) {
				System.out.println("Player wins coin toss, start first");
			} else {
				System.out.println("Player loses coin toss, computer starts first");
			}
			char gameState = start;
			while (gameState != 'E') {
				if (gameState == playerLetter) {
					userPlay();
					gameState = getGameState(board, playerLetter, computerLetter, gameState);
				}
				if (gameState == computerLetter) {
					move();
					gameState = getGameState(board, playerLetter, computerLetter, gameState);
				}
			}
		}

		public static void main(String[] args) {
			// displaying welcome message
			System.out.println("Welcome to Tic Tac Toe Game");
			boolean playAgain = false;
			Scanner sc = new Scanner(System.in);
			do {
				createBoard();
				userPlay();
				showBoard();
				playTillEnd(playerChoice, board, computerChoice);
				System.out.println("Do you want to continue?");
				System.out.println("Press y for Yes, n for No");
				char choice = sc.next().toLowerCase(Locale.ROOT).charAt(0);
				switch (choice) {
				case 'n':
					playAgain = false;
					break;
				case 'y':
					playAgain = true;
					break;
				default:
					System.out.println("Incorrect Input");
					break;
				}
			} while (playAgain);
		}
	}
