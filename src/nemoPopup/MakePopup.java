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
import nemoMain.MainStageManager;

/**
 * 
 *nemoGui
 *	|_ MakePopup
 *
 * 1. outline : 맵 생성 성공시 띄워지는 팝업이다. 버튼 클릭시 메뉴로 scene을 전환한다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class MakePopup extends CommonPopup{
	public MakePopup() {
		super();
		
		MainStageManager mainStageManager = MainStageManager.getMainStageManager();
		
		Button bt = new Button();
		Label lb = new Label();
		Rectangle rt = new Rectangle(20, 20);
		
		lb.setText("New Map is Made!");
		lb.setFont(new Font("Segoe UI", 25));
		lb.setTextFill(Color.WHITE);
		rt.setFill(Color.TRANSPARENT);
		bt.setText("Proceed to Menu");
		bt.setStyle("-fx-background-color: Orange");
		bt.setFont(new Font("Segoe UI", 15));
		bt.setTextFill(Color.WHITE);
		bt.setOnMouseEntered(new ButtenEnteredDropShadow());
		bt.setOnMouseExited(new NodeEventNull());
		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//change scene to menu;
				mainStageManager.setStage(MainStageManager.MENU_DIR);
				mainStageManager.showStage();
				//hide popup;
				popup.hide();
			}
		});
		
		vbContents.getChildren().addAll(lb, rt, bt);	
	}
}
