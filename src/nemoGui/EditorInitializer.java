/**
 * 
 */
package nemoGui;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import nemoBoard.Board;
import nemoHandler.CellClickedHandler;
import nemoHandler.CellEnteredHandler;
import nemoHandler.NodeEventNull;
import nemoSystem.EditorSystem;

/**
 * 
 *org.dimigo.nemoMain
 *	|_ Initializer
 *
 * 1. outline : Editor컨트롤러를 Initialize하는 클래스이다. 모든 메소드들은 static으로 작성되어있다.
 * 2. Written Data : 2015. 11. 25.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class EditorInitializer {
	
	private static boolean isInitSet = false;
	private static EditorSystem editorSystem;
	
	/**
	 * EditorSystem을 불러와서 설정하기 위해 사용한다.
	 */
	public static void setInitializer() {
		editorSystem = EditorSystem.getSystem();
		isInitSet = true;
	}

	/**
	 * Scene에 사각형으로 채워진 보드를 그린다. 각 네모는 핸들러를 통해  해당 좌표값에 대응하는 board 좌표 값과 연결되어 조작할 수 있다.
	 * @param gdpBoard
	 * @param rtCells
	 * @param BTN_SIZE
	 */
	public static void initBoard(GridPane gdpBoard, Rectangle[][] rtCells, int BTN_SIZE) {
		if(!isInitSet) {
			System.out.println("Intializer not set");
			return;
		}
		
		for(int i = 0; i < Board.HEIGHT; ++i) {
			for(int j = 0; j < Board.WIDTH; ++j) {
				Rectangle rt = new Rectangle(BTN_SIZE-1, BTN_SIZE-1); //btCells[row][column]
				rt.setStyle("-fx-fill: white;" +
						"-fx-stroke: lavender;" +
						"-fx-stroke-width: 1;");
				//핸들러를 등록. Editor보드는 UserBoard를 상속받았으므로 업캐스팅 되어 인자로 넘어간다.
				rt.setOnMouseClicked(new CellClickedHandler(editorSystem.getUserBoard(), i, j));
				rt.setOnMouseEntered(new CellEnteredHandler(BTN_SIZE));
				rt.setOnMouseExited(new NodeEventNull());
				
				rtCells[i][j] = rt;
				gdpBoard.add(rtCells[i][j], j, i); //column : j, row : i
			}
		}
	}
	
	/**
	 * Edit이 완료되면 EditorSystem을 소멸시킨다.
	 * @param editorSystem
	 */
	public static void finalizeSystem(EditorSystem editorSystem) {
		editorSystem.finalize();
		editorSystem = null;
		isInitSet = false;
	}
}
