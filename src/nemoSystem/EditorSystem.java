/**
 * 
 */
package nemoSystem;

import nemoBoard.EditBoard;

/**
 * 
 *org.dimigo.nemoSystem
 *	|_ MainSystem
 *
 * 1. outline : Editor의 backend 시스템이다. Singleton 클래스이다.
 * 2. Written Data : 2015. 11. 25.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class EditorSystem extends CommonSystem{
	
	/**
	 * EditBoard는 userBoard로 업캐스팅된다.
	 */
	private EditorSystem() {
		userBoard = new EditBoard();
	}
	
	/**
	 * 시스템을 initialize한다.
	 */
	protected static void initialize() {
		system = new EditorSystem();
		isInitalized = true;
		System.out.println("EditorSystem Initiated");
	}
	
	/**
	 * 싱글톤 클래스를 얻어온다.
	 * @return
	 */
	public static EditorSystem getSystem() {
		if(isInitalized == false) {
			initialize();
			return (EditorSystem)system;
		} else {
			return (EditorSystem)system;
		}
	}
	
	/**
	 * 맵을 작성한다. path는 맵의 이름이 된다.
	 * @param path
	 */
	public void writeBoard(String path) {
		EditorMapWriter.write(path, ((EditBoard)userBoard).getBoard());
	}

}
