/**
 * 
 */
package nemoHandler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import nemoBoard.UserBoard;
import nemoGui.GUIDrawer;

/**
 * 
 *org.dimigo.nemoHandle
 *	|_ CellHandle
 *
 * 1. outline : Cell이 클릭되었을 경우 Cell의 색을 바꾸어준다. 동시에 board의 값을 바군다.
 * 2. Written Data : 2015. 11. 24.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class CellClickedHandler implements EventHandler<Event>{

	private UserBoard board;
	//다른 셀의 좌표에 접근하지 못하도록 상수로 설정한다.
	final int i;
	final int j;
	
	/**
	 * 핸들러 등록시, 좌표를 지정하고 board를 연결한다.
	 * @param board
	 * @param i
	 * @param j
	 */
	public CellClickedHandler(UserBoard board, int i, int j) {
		this.board = board;
		this.i = i;
		this.j = j;
	}
	
	@Override
	public void handle(Event event) {
		Rectangle cell = (Rectangle) event.getSource();
		if(board.isCellFilled(i, j)) {
			GUIDrawer.emptyColor(cell);
			board.emptyCell(i, j); //자동으로 바꾸도록.
		} else {
			GUIDrawer.fillColor(cell);
			board.fillCell(i, j);
		}
	}

}
