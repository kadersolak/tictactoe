package tic;

import java.util.Random;

public class Main {
	static Random rand = new Random();
	static String[] giveMeXorO = { "X", "O" };
	static int maxNum=9;	
	
	static String checkResult(String line, String type) {
		// For X winner
		if (line.equals("XXX")) {
			return "Player X won with a "+ type+" line!";
		}

		// For O winner
		if (line.equals("OOO")) {
			return "Player O won with a "+ type+" line!";
		}
		return null;
	}
	
	// CheckWinner method will
	// decide the combination of three box given below.
	static String checkGameWinner(String[] board) {
		String returnVal=null;
		String returnValMessage=null;
		for (int a = 0; a < 8; a++) {
			String line = null;
			returnVal=null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				returnVal=checkResult(line, "horizontal");
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				returnVal=checkResult(line, "horizontal");
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				returnVal=checkResult(line, "horizontal");
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				returnVal=checkResult(line, "vertical");
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				returnVal=checkResult(line, "vertical");
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				returnVal=checkResult(line, "vertical");
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				returnVal=checkResult(line, "diagonal");
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				returnVal=checkResult(line, "diagonal");
				break;
			}
			
			if(returnVal!=null) {
				if(returnValMessage!=null) return returnValMessage="Something is terribly wrong!"; //There is 2 winners
				
				returnValMessage=returnVal;
			}
		}
		return returnValMessage;
	}
	
	static String changeNullToSpace(String cellValue) { //Nulls in board needs to change to space, for better look
		if (cellValue == null) return " ";
		else return cellValue;
	}

	// To print out the board.
	/*
	 * |-----------| 
	 * | 1 | 2 | 3 | 
	 * |-----------| 
	 * | 4 | 5 | 6 | 
	 * |-----------|
	 * | 7 | 8 | 9 |
	 * |-----------|
	 */

	static String prepareTicTacToeBoard(String[] board) {

		String line = "|-----------|\n";
		String delimiterStart = "| ";
		String delimiterMid = " | ";
		String delimiterEnd = " |\n";
		StringBuilder sb = new StringBuilder();
		int orderInBoard=0;
		for (int i = 0; i < board.length; i++) {
			orderInBoard = i % 3;
			switch (orderInBoard) {
				case 0: {	
					sb.append(line); // line between rows
					sb.append(delimiterStart);
					sb.append(changeNullToSpace(board[i]));
					break;
				}
				case 1: {
					sb.append(delimiterMid);
					sb.append(changeNullToSpace(board[i]));
					sb.append(delimiterMid);
					break;
				}
				case 2: {
					sb.append(changeNullToSpace(board[i]));
					sb.append(delimiterEnd);
					break;
				}
			}
		}
		sb.append(line); //end line
		return sb.toString();
	}

	public static boolean checkArrayIsFull(String[] array) { //If array is not fuill then bot can continue to make moves
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return false;
			}
		}
		return true;
	}
	static String[] makeAMove(String[] board, int moveNum) { //random move according to empty spaces
		int n = rand.nextInt(maxNum);
		while (board[n] != null && !checkArrayIsFull(board)) { //if cell is already occupied and there is empty cell boat can make a move
			n = rand.nextInt(maxNum); //get again random num to check if the cell is empty
		}
		board[n] = giveMeXorO[moveNum % 2]; //pick the next value, according to mod it will come in order
		
		return board;
	}
	public static void main(String[] args) {
		String[] board = new String[maxNum];
		
		String winner = null;
		while (winner == null) { //till we have a winner will make moves

			for (int moveNum = 0; moveNum < maxNum; moveNum++) { //for every game 9 moves
				
				board=makeAMove(board, moveNum); // after every move it return board

				if (moveNum >= 5) {//before 5 moves it is impossible to win, so not checking the winner
					winner = checkGameWinner(board); // check if we have a winner
					if (winner != null) // we have a winner so it will show the board
						break;
				}
			}
			System.out.println(prepareTicTacToeBoard(board)); // print the board to see the game
			if (winner == null) { //no winner 
				System.out.println("\n It's a draw!\n");
			}

		}

		System.out.println("\n " + winner);

	}
}
