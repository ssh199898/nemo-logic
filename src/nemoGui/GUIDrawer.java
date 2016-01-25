/**
 * 
 */
package nemoGui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * 
 *org.dimigo.nemoMain
 *	|_ GuiController
 *
 * 1. outline : 자주 쓰이는 함수들을 static 메소드로 만들어 모아 놓았다.
 * 2. Written Data : 2015. 11. 25.
 *
 * @author		: ssh19
 * @version		: 1.0
 */

public class GUIDrawer {
	/**
	 * 로직의 우측에 오는 숫자들을 구별하기 위해 선을 그린다.
	 * @param vbLeft
	 * @param LINE_LENGTH
	 */
	public static void drawHLine(VBox vbLeft, int LINE_LENGTH) {
		Line ln = new Line();
		ln.setStartX(0);
		ln.setStartY(0);
		ln.setEndX(LINE_LENGTH+50);
		ln.setEndY(0);
		ln.setStroke(Color.LIGHTGRAY);
		vbLeft.getChildren().add(ln);
	}
	
	/**
	 * 로직의 위쪽에 오는 숫자들을 구별하기 위해 선을 그린다.
	 * @param hbTop
	 * @param LINE_LENGTH
	 */
	public static void drawVLine(HBox hbTop, int LINE_LENGTH) {
		Line ln = new Line();
		ln.setStartX(0);
		ln.setStartY(0);
		ln.setEndX(0);
		ln.setEndY(LINE_LENGTH);
		ln.setStroke(Color.LIGHTGRAY);
		hbTop.getChildren().add(ln);
	}
	
	/**
	 * GUI상에서 셀의 색을 비운다. Board 데이터를 조작하지 않는다.
	 * @param rt
	 */
	public static void emptyColor(Rectangle rt) {
		rt.setFill(Color.WHITE);
		rt.setStroke(Color.LAVENDER);
	}
	
	public static void fillColor(Rectangle rt) {
		rt.setFill(Color.PLUM);
		rt.setStroke(Color.ORCHID);
	}
}
