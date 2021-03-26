# TicTacToe

- TicTacToe in Bot mode

	- Game play by bots,
	- Numbers will be picked up randomly.
	- Game can be win via vertical,horizontal or diagonal way
	- Bot needs to pick up X and O by sequence
	- check the winner after every move
	- show the game after finish, even if there is no winner
	- no winner, play again
	
- Test

	- Test checkTheWinner
		- Send valid inputs, with no winner
		- Send invalid inputs
		- Send valid inputs with winner
		- Send valid inputs with winner in different possibilities
		
	- Test showBorad method.
		- Send different combination of board
		- Send empty board
		
 - Code
 
 	- CheckWinner
 		- winner should compare the values in board
 		- vertical,horizontal and diagonal combinations should be checked
 		- according to winner combination result should change
 		- method should return winner explanation
 		- if no winner return will be null
 		
 	- PrintBoard
 		- Board will be array of 9. 
 		- in loop will split it to 3 to have lines
 		- if the value is null it means nothing in the cell so be empty
 		- needs to have lines and seperatorsfor better look