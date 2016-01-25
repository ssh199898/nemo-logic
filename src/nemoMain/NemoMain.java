/**
 * 
 */
package nemoMain;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 *org.dimigo.nemoMain
 *	|_ NemoMain
 *
 * 1. outline : 현 프로젝트의 시작점이다. 시작페이지로 Menu를 지정한다.
 * 2. Written Data : 2015. 11. 23.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class NemoMain extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		MainStageManager.initializeStageManager(stage, "/nemoGui/Menu.fxml");
		MainStageManager mainStageManager = MainStageManager.getMainStageManager(); //start fxml
		mainStageManager.showStage();
	}
}
