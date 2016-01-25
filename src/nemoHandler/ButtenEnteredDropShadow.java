/**
 * 
 */
package nemoHandler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

/**
 * 
 *nemoHandler
 *	|_ ButtenEnteredHandler
 *
 * 1. outline : 마우스가 들어봤을때 그림자를 띄워주는 핸들러. 모든 버튼에 공통된 속성을 지정하기 위해 클래스로 생성하였다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class ButtenEnteredDropShadow implements EventHandler<Event> {

	@Override
	public void handle(Event event) {
		Button bt = (Button) event.getSource();
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(7.0);
		dropShadow.setColor(Color.color(0.2, 0.3, 0.3));
		bt.setEffect(dropShadow);
	}
}
