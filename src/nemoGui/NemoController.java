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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import nemoBoard.Board;
import nemoHandler.ButtenEnteredDropShadow;
import nemoHandler.NodeEventNull;
import nemoMain.MainStageManager;
import nemoPopup.FailPopup;
import nemoPopup.SuccessPopup;
import nemoSystem.NemoSystem;

/**
 * 
 *org.dimigo.nemotest
 *	|_ NemoController
 *
 * 1. outline : 네모 로직의 컨트롤러. 가장 먼저 개발되었다.
 * 2. Written Data : 2015. 11. 23.
 *
 * @author		: ssh19
 * @version		: 1.0
 */

public class NemoController implements Initializable {
	private final int BTN_SIZE = 20;
	
	@FXML private GridPane gdpBoard;
	@FXML private HBox hbTop;
	@FXML private VBox vbLeft;
	@FXML private Button btClear;
	@FXML private Button btSubmit;
	@FXML private Label lbMapName;
	
	private Rectangle[][] rtCells = new Rectangle[20][25];
	private NemoSystem nemoSystem;
	
	
	/**
	 * 네모 로직을 위해 GUI를 설정하고, Cell들을 Board와 연결한다. 각 Cell들은 현재 좌표값에 대응하는 Board의 값을 수정할 수 있다.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nemoSystem = NemoSystem.getSystem();
		
		NemoInitializer.setInitializer();
		NemoInitializer.initBoard(gdpBoard, rtCells, BTN_SIZE);
		NemoInitializer.initLeftLine(vbLeft, BTN_SIZE);
		NemoInitializer.initTopLine(hbTop, BTN_SIZE);
		
		//버튼에 Effect를 넣는다.
		btClear.setOnMouseEntered(new ButtenEnteredDropShadow());
		btSubmit.setOnMouseEntered(new ButtenEnteredDropShadow());
		btClear.setOnMouseExited(new NodeEventNull());
		btSubmit.setOnMouseExited(new NodeEventNull());
		
		//라벨에 맵 이름을 등록한다.
		lbMapName.setText(nemoSystem.getMapBoard().getMapName());
	}

	/**
	 * Clear버튼의 handler를 등록한다. 컨트롤러는 GUI상의 cell에만 접근 가능하고, board의 데이터를 지우는 것은 nemoSystem에서 한다.
	 * @param e
	 */
	@FXML public void handleClearAction(ActionEvent e) {
		for(int i = 0; i < Board.HEIGHT; ++i) {
			for(int j = 0; j < Board.WIDTH; ++j) {	
				GUIDrawer.emptyColor(rtCells[i][j]);
			}
		}
		
		nemoSystem.clearBoard();
	}
	
	/**
	 * 제출버튼이 눌릴 경우 성공시, nemoSystem을 소멸시키고, 성공 팝업을 띄운다.
	 * 실패시 실패 팝업만 띄운다.
	 * @param e
	 */
	@FXML public void handleSubmitAction(ActionEvent e) {
		
		MainStageManager mainStageManager = MainStageManager.getMainStageManager();
		
		if(nemoSystem.checkBoard() == true) {
			NemoInitializer.finalizeSystem(nemoSystem);
			nemoSystem = null;
			btSubmit.setOnAction(null); //nemoSystem의 소멸에 따른 Null Pointer Exception을 막는다.
			btClear.setOnAction(null);
			mainStageManager.showPopup(new SuccessPopup());
		} else {
			mainStageManager.showPopup(new FailPopup());
		}
	}
	
}
