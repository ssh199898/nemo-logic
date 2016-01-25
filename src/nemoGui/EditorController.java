/**
 * 
 */
package nemoGui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import nemoBoard.Board;
import nemoHandler.ButtenEnteredDropShadow;
import nemoHandler.NodeEventNull;
import nemoMain.MainStageManager;
import nemoPopup.MakeFailPopup;
import nemoPopup.MakePopup;
import nemoSystem.EditorSystem;

/**
 * 
 *org.dimigo.nemotest
 *	|_ NemoController
 *
 * 1. outline : Editor Scene을 컨르롤한다.
 * 2. Written Data : 2015. 11. 23.
 *
 * @author		: ssh19
 * @version		: 1.0
 */

public class EditorController implements Initializable {
	private final int BTN_SIZE = 20;
	
	@FXML private GridPane gdpBoard;
	@FXML private Button btClear;
	@FXML private Button btMake;
	@FXML private TextField path;
	
	private Rectangle[][] rtCells = new Rectangle[20][25];
	private EditorSystem editorSystem;

	/**
	 * EditorBoard와 Scene을 연결한다.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		editorSystem = EditorSystem.getSystem();
		
		EditorInitializer.setInitializer();
		EditorInitializer.initBoard(gdpBoard, rtCells, BTN_SIZE);
	
		btClear.setOnMouseEntered(new ButtenEnteredDropShadow());
		btMake.setOnMouseEntered(new ButtenEnteredDropShadow());
		btClear.setOnMouseExited(new NodeEventNull());
		btMake.setOnMouseExited(new NodeEventNull());
	}

	/**
	 * Clear버튼의 핸들러. Controller 상에서 GUI보드를 비우고, system에서  Board 데이터를 비운다.
	 * @param e
	 */
	@FXML public void handleClearAction(ActionEvent e) {
		for(int i = 0; i < Board.HEIGHT; ++i) {
			for(int j = 0; j < Board.WIDTH; ++j) {	
				GUIDrawer.emptyColor(rtCells[i][j]);
			}
		}
		editorSystem.clearBoard();
	}	
	
	/**
	 * Make버튼의 핸들러. 문제가 없으면 성공 팝업을, 있을경우 실패 팝업을 띄운다.
	 * @param e
	 */
	@FXML public void handleMakeAction(ActionEvent e) {
		MainStageManager mainStageManager = MainStageManager.getMainStageManager();
		if(path.getText() == null || "".equals(path.getText().trim())) {
			mainStageManager.showPopup(new MakeFailPopup());
			return;
		}
		editorSystem.writeBoard(path.getText());
		EditorInitializer.finalizeSystem(editorSystem);
		editorSystem = null;
		btClear.setOnAction(null); //editorSystem의 소멸에 따른 NullPointerException을 막는다.
		btMake.setOnAction(null);
		mainStageManager.showPopup(new MakePopup());
	}
	
}
