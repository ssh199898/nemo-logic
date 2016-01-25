/**
 * 
 */
package nemoGui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import nemoBoard.Board;
import nemoHandler.CellClickedHandler;
import nemoHandler.CellEnteredHandler;
import nemoHandler.NodeEventNull;
import nemoSystem.NemoSystem;

/**
 * 
 *org.dimigo.nemoMain
 *	|_ Initializer
 *
 * 1. outline : 네모 컨트롤러를 Initializing 한다.
 * 2. Written Data : 2015. 11. 25.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class NemoInitializer {
	
	//좌측과 상단에 그릴 선의 길이.
	private static final int LINE_LENGTH = 200;
	
	private static boolean isInitSet = false;
	private static NemoSystem nemoSystem;
	
	/**
	 * Initializing을 위해 먼저 세팅을 한다.

	 */
	public static void setInitializer() {
		nemoSystem = NemoSystem.getSystem();
		isInitSet = true;
	}
	
	/**
	 * GUI에 Cell들을 그리고 각 Cell에 대응하는 UserBoard의 칸을 연결한다.
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
				rt.setOnMouseClicked(new CellClickedHandler(nemoSystem.getUserBoard(), i, j)); //핸들러 등록
				rt.setOnMouseEntered(new CellEnteredHandler(BTN_SIZE));
				rt.setOnMouseExited(new NodeEventNull());
				
				rtCells[i][j] = rt;
				gdpBoard.add(rtCells[i][j], j, i); //column : j, row : i
			}
		}
	}
	
	/**
	 * nemoSystem으로부터 좌측 숫자들에 대한 정보를 불러와서 GUI에 넣는다.
	 * @param vbLeft
	 * @param BTN_SIZE
	 */
	public static void initLeftLine(VBox vbLeft, int BTN_SIZE) {
		if(!isInitSet){
			System.out.println("Intializer not set");
			return;
		}
		
		NemoSystem nemoSystem = NemoSystem.getSystem();
		
		for(int i = 0; i < Board.HEIGHT; ++i) {
			HBox hBox = new HBox();
			
			//Draws Horizontal Line to LeftList;
			GUIDrawer.drawHLine(vbLeft, LINE_LENGTH);
			
			List<ArrayList<Integer>> vList = nemoSystem.getMapBoard().leftList;
			
			for(int j = 0; j < vList.get(i).size(); ++j){
				Label lb = new Label(Integer.toString(vList.get(i).get(j)));
				lb.setPrefSize(BTN_SIZE, BTN_SIZE-1);
				lb.setAlignment(Pos.CENTER);
				lb.setFont(new Font("Segoe UI", 12));
				hBox.getChildren().add(lb);
			}
			
			if(hBox.getChildren().isEmpty()) {
				Rectangle rt = new Rectangle(BTN_SIZE, BTN_SIZE-1);
				rt.setFill(Color.TRANSPARENT);
				hBox.getChildren().add(rt);
			}
			
			hBox.getStyleClass().add("hb-lList");
			hBox.setAlignment(Pos.CENTER_RIGHT);
			vbLeft.getChildren().add(hBox);
		}
		
		//Draws Horizontal Line to LeftList;
		GUIDrawer.drawHLine(vbLeft, LINE_LENGTH);
	}
	
	/**
	 * nemoSystem으로부터 위쪽 숫자들에 대한 정보를 불러와서 GUI에 넣는다.
	 * @param hbTop
	 * @param BTN_SIZE
	 */
	public static void initTopLine(HBox hbTop, int BTN_SIZE) {
		if(!isInitSet){
			System.out.println("Intializer not set");
			return;
		}
		
		for(int i = 0; i < Board.WIDTH; ++i) {
			VBox vBox = new VBox();
			
			//Draws Vertical Line to TopList;
			GUIDrawer.drawVLine(hbTop, LINE_LENGTH);
			
			List<ArrayList<Integer>> hList = nemoSystem.getMapBoard().topList;
			
			for(int j = 0; j < hList.get(i).size(); ++j){
				Label lb = new Label(Integer.toString(hList.get(i).get(j)));
				lb.setPrefSize(BTN_SIZE-1, BTN_SIZE);
				lb.setAlignment(Pos.CENTER);
				lb.setFont(new Font("Segoe UI", 12));
				vBox.getChildren().add(lb);
			}
			
			if(vBox.getChildren().isEmpty()) {
				Rectangle rt = new Rectangle(BTN_SIZE-1, BTN_SIZE);
				rt.setFill(Color.TRANSPARENT);
				vBox.getChildren().add(rt);
			}
			
			vBox.getStyleClass().add("vb-tList");
			vBox.setAlignment(Pos.BOTTOM_CENTER);
			hbTop.getChildren().add(vBox);
		}
		
		//Draws Vertical Line to TopList;
		GUIDrawer.drawVLine(hbTop, LINE_LENGTH);
	}
	
	//nemoSystem을 소멸시킨다.
	public static void finalizeSystem(NemoSystem nemoSystem) {
		nemoSystem.finalize();
		nemoSystem = null;
		isInitSet = false;
	}
}
