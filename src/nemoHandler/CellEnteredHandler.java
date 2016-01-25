/**
 * 
 */
package nemoHandler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 *org.dimigo.nemoHandle
 *	|_ CellHandle
 *
 * 1. outline : Cell에 마우스가 들어왔을때 Effect를 넣어준다.
 * 2. Written Data : 2015. 11. 24.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class CellEnteredHandler implements EventHandler<Event>{
	private final int BTN_SIZE;
	
	/**
	 * 크기를 지정한다.
	 * @param BTN_SIZE
	 */
	public CellEnteredHandler(int BTN_SIZE) {
		this.BTN_SIZE = BTN_SIZE;
	}
	
	/**
	 * 반투명 사각형을 Cell위에 Effect로 띄워준다.
	 */
	@Override
	public void handle(Event event) {
		Rectangle rt = (Rectangle) event.getSource();
		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);
		blend.setOpacity(0.5);
		blend.setTopInput(new ColorInput(0, 0, BTN_SIZE, BTN_SIZE, Color.SKYBLUE));
		rt.setEffect(blend);
	}
}
