/**
 * 
 */
package nemoPopup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import nemoHandler.ButtenEnteredDropShadow;
import nemoHandler.NodeEventNull;

/**
 * 
 *nemoGui
 *	|_ FailedPopup
 *
 * 1. outline : Editor에서 맵 생성에 실패시 띄워지는 팝업이다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class MakeFailPopup extends CommonPopup{

	public MakeFailPopup() {
		super();
		
		Button bt = new Button();
		Label lb = new Label();
		Rectangle rt = new Rectangle(20, 20);
		
		lb.setText("Invalid Map");
		lb.setFont(new Font("Segoe UI", 25));
		lb.setTextFill(Color.WHITE);
		rt.setFill(Color.TRANSPARENT);
		bt.setText("Check Out");
		bt.setStyle("-fx-background-color: Orange");
		bt.setFont(new Font("Segoe UI", 15));
		bt.setTextFill(Color.WHITE);
		bt.setOnMouseEntered(new ButtenEnteredDropShadow());
		bt.setOnMouseExited(new NodeEventNull());
		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//hide popup;
				popup.hide();
			}
		});
		
		vbContents.getChildren().addAll(lb, rt,bt);
	}
}
