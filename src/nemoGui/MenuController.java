/**
 * 
 */
package nemoGui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import nemoHandler.ButtenEnteredDropShadow;
import nemoHandler.NodeEventNull;
import nemoMain.MainStageManager;

/**
 * 
 *nemoGui
 *	|_ MainController
 *
 * 1. outline : 메뉴 scene을 다루는 controller
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class MenuController implements Initializable{
	
	@FXML private Button btStart;
	@FXML private Button btEditor;
	@FXML private Button btExit;
	
	/**
	 * 메뉴 버튼 3개에 effect 핸들러를 등록한다.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btStart.setOnMouseEntered(new ButtenEnteredDropShadow());
		btEditor.setOnMouseEntered(new ButtenEnteredDropShadow());
		btExit.setOnMouseEntered(new ButtenEnteredDropShadow());
		btStart.setOnMouseExited(new NodeEventNull());
		btEditor.setOnMouseExited(new NodeEventNull());
		btExit.setOnMouseExited(new NodeEventNull());
	}
	
	/**
	 * Start버튼에서 Action이 실행되면 창을 옮긴다.
	 * @param e
	 */
	@FXML public void handleStartAction(ActionEvent e) {
		MainStageManager mainStageManager = MainStageManager.getMainStageManager();
		mainStageManager.setStage(MainStageManager.NEMO_DIR);
		mainStageManager.showStage();
	}
	
	/**
	 * Editor로 옮겨간다.
	 * @param e
	 */
	@FXML public void handleEditorAction(ActionEvent e) {
		MainStageManager mainStageManager = MainStageManager.getMainStageManager();
		mainStageManager.setStage(MainStageManager.EDIT_DIR);
		mainStageManager.showStage();
	}
	
	/**
	 * 종료버튼
	 * @param e
	 */
	@FXML public void handleExitAction(ActionEvent e) {
		Platform.exit();
	}
}
