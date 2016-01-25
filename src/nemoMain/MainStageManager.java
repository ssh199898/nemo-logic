/**
 * 
 */
package nemoMain;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * 
 *nemoMain
 *	|_ SceneManager
 *
 * 1. outline : 처음 실행시 생성되는 stage를 관리한다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */

//Singleton 클래스
public class MainStageManager {
	
	public static final String MENU_DIR = "/nemoGui/Menu.fxml";
	public static final String NEMO_DIR = "/nemoGui/Nemo.fxml";		
	public static final String EDIT_DIR = "/nemoGui/Editor.fxml";
	
	private String fxml;
	private Stage stage;
	private static MainStageManager manager;
	private static boolean isInitialized = false;
	
	/**
	 * constructor
	 * @param stage
	 * @param startingFxml
	 */
		private MainStageManager(Stage stage, String startingFxml) {
			this.stage = stage;
			this.fxml = startingFxml; //시작 페이지는 메뉴로 설정한다.
		}
	
	/**
	 * 스테이지를 설정하기 위한 이니셜라이저.
	 * @param stage
	 * @param startingFxml
	 */
	public static void initializeStageManager(Stage stage, String startingFxml) {
		
		if(isInitialized) {
			System.out.println("stage already exists");
			return;
		}
		
		manager = new MainStageManager(stage, startingFxml);
		isInitialized = true; //this never changes.
	}
	
	/**
	 * return singleton class
	 * @return
	 */
	public static MainStageManager getMainStageManager() {
		if(isInitialized) {
			return manager;
		}
		else {
			System.out.println("stage isn't initialized");
			return null;
		}
	}
	
	
	/**
	 * scene을 바꾼다.
	 * @param fxml
	 */
	public void changeMainStage (String fxml) {
		setStage(fxml);
		showStage();
	}
	
	/**
	 * scene을 설정한다
	 * @param fxml
	 */
	public void setStage(String fxml) {
		this.fxml = fxml;
	}
	
	/**
	 * 현재 설정된 scene을 stage에 올린다.
	 */
	public void showStage() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(fxml));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		stage.setScene(new Scene(root));
		stage.setTitle("Nemo Logic");
		stage.centerOnScreen();
		stage.setResizable(false);
		
		stage.show();
	}
	
	/**
	 * 현재 scene에 팝업을 띄우기 위한 함수.
	 * 들어오는 인자들은 모두 Popup으로 업캐스팅된다.
	 * @param popup
	 */
	public void showPopup(Popup popup) {
		popup.show(stage);
	}
}
