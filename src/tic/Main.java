package tic;

public class Main {
	
	// CheckWinner method will
	// decide the combination
	// of three box given below.
	static String checkGameWinner(String[] board) {
		String returnVal=null;
		String returnValMessage=null;
		for (int a = 0; a < 8; a++) {
			String line = null;
			returnVal=null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				returnVal= "horizontal";
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				returnVal= "horizontal";
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				returnVal= "horizontal";
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				returnVal= "vertical";
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				returnVal= "vertical";
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				returnVal= "vertical";
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				returnVal= "diagonal";
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				returnVal= "diagonal";
				break;
			}
			
			
			if (line.equals("XXX")) {
				if(returnValMessage!=null) return returnValMessage="Something is terribly wrong!"; 
				returnValMessage= "Player X won with a "+ returnVal+" line!";
			}

			// For O winner
			if (line.equals("OOO")) {
				if(returnValMessage!=null) return returnValMessage="Something is terribly wrong!"; 
				returnValMessage= "Player O won with a "+ returnVal+" line!";
			}

		}
		return returnValMessage;
	}
	
	static String changeNullToSpace(String value) { //To print null places in board as space
		if (value == null) return " ";
		else return value;
	}
	
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
					sb.append(line);
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
		sb.append(line);
		return sb.toString();
	}
	public static void main(String[] args) {
		
	}
}
