package tic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTicTacToe {

private Main _testMain;
	
	@BeforeEach
	public void setUp() {
		_testMain = new Main();
	}
	
	
	@DisplayName("Test Print Board ")
	@Test
	void PrintBoardCheck() {
		String[] boardTest1= {"X", "O", "O", "O", "O", "X", "X", "X", "X"};
		String[] boardTest2= {"X", "O", "X", "X", "O", "X", "X", "O", "X"};
		String[] emptyBoard= {" ", " ", " ", " ", " ", " ", " ", " ", " "};
		assertEquals(_testMain.prepareTicTacToeBoard(boardTest1),"|-----------|\n| X | O | O |\n|-----------|\n| O | O | X |\n|-----------|\n| X | X | X |\n|-----------|\n");
		assertEquals(_testMain.prepareTicTacToeBoard(boardTest2),"|-----------|\n| X | O | X |\n|-----------|\n| X | O | X |\n|-----------|\n| X | O | X |\n|-----------|\n");
		assertEquals(_testMain.prepareTicTacToeBoard(emptyBoard),"|-----------|\n|   |   |   |\n|-----------|\n|   |   |   |\n|-----------|\n|   |   |   |\n|-----------|\n");


	}
	
	@DisplayName("Test Check Winner")
	@Test
	void TestGameWinner() {
		String[] winerXhorizontal= {"X", "O", "O", "O", "O", "X", "X", "X", "X"};
		String[] winerXvertical= {"X", "O", "O", "X", "O", " ", "X", " ", "X"};
		String[] winerOvertical= {"X", "O", "O", "X", "X", "O", "O", "X", "O"};
		String[] winerOhorizontal= {"X", "O", "X", "O", "X", "O", "O", "O", "O"};
		
		String[] winerOdiagonal= {"O", "X", "X", " ", "O", "X", " ", " ", "O"};
		String[] nowinner= {"X", "O", "X", "O", "X", "O", "O", "O", " "};
		
		String[] badData2winner= {"O", "O", "X", "O", "X", "O", "X", "X", "X"};
		assertEquals(_testMain.checkGameWinner(badData2winner), "Something is terribly wrong!");
		
		
		assertEquals(_testMain.checkGameWinner(winerXhorizontal), "Player X won with a horizontal line!");
		assertEquals(_testMain.checkGameWinner(winerXvertical), "Player X won with a vertical line!");
		
		assertEquals(_testMain.checkGameWinner(winerOvertical), "Player O won with a vertical line!");
		assertEquals(_testMain.checkGameWinner(winerOhorizontal), "Player O won with a horizontal line!");
		assertEquals(_testMain.checkGameWinner(winerOdiagonal), "Player O won with a diagonal line!");
		
		
		String[] winerMultiple= {"X", "X", "X", "O", "O", "X", "O", "O", "O"};
		//assertEquals(_testMain.checkGameWinner(winerMultiple), null);
	
		assertEquals(_testMain.checkGameWinner(nowinner), null);
		
		String[] badData= {"X", "O", "1", "O", "X", "C", "O", "O", " "};
		assertEquals(_testMain.checkGameWinner(badData), null);
		
		
		String[] raw= {"O", "O", "X", "X", "X", "O", "O", "X", "X"};
		assertEquals(_testMain.checkGameWinner(raw), null);
		
	}

}
