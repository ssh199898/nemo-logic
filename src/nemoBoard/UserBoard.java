/**
 * 
 */
package nemoBoard;

/**
 * 
 *org.dimigo.nemoBoard
 *	|_ UserBoard
 *
 * 1. outline : 네모로직에서 사용하기 위한 보드이다. 채워진 이후 MapBoard와 비교된다.
 * 2. Written Data : 2015. 11. 24.
 *
 * @author		: ssh19
 * @version		: 1.0
 */

public class UserBoard extends Board{
	public UserBoard() {}
	
	public void emptyCell(int i, int j) {
		board[i][j] = 0;
	}
	
	public void fillCell(int i, int j) {
		board[i][j] = 1;
	}
	
}
