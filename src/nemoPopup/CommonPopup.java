/**
 * 
 */
package nemoPopup;


import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

/**
 * 
 *nemoGui
 *	|_ BasicPopup
 *
 * 1. outline : 팝업들의 공통된 속성을 지정하였다. 다른 팝업들은 본 클래스를 상속받아야 한다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public abstract class CommonPopup extends Popup{
	protected Popup popup; //for event
	protected VBox vbContents;
	
	CommonPopup() {
		popup = this;
		/*
		this.setAnchorX(400);
		this.setAnchorY(350);
		*/
		
		vbContents = new VBox();
		vbContents.setPrefWidth(200);
		vbContents.setPrefHeight(150);
		vbContents.setStyle("-fx-background-color: Gray");
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.color(0.2, 0.3, 0.3));		
		vbContents.setEffect(shadow);
		vbContents.setAlignment(Pos.CENTER);
		
		this.getContent().add(vbContents);
	}
}
