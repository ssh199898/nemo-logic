/**
 * 
 */
package nemoBoard;

/**
 * 
 *org.dimigo.nemoBoard
 *	|_ Board
 *
 * 1. outline : 기본적인 보드 추상클래스. 다른 보드들은 모두 이를 상속받는다.
 * 2. Written Data : 2015. 11. 24.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public abstract class Board {
	//메인 로직이 될 판이다.
	protected byte[][] board = new byte[20][25];
	
	//네모로직 판의 넓이와 높이를 지정한다.
	public final static int WIDTH = 25;
	public final static int HEIGHT = 20;
	
	//지정된 셀이 1인지 여부를 파악한다.
	public boolean isCellFilled(int i, int j) {
		if(board[i][j] == 1)
			return true;
		else
			return false;
	}
}
