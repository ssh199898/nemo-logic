/**
 * 
 */
package nemoSystem;

import nemoBoard.Board;
import nemoBoard.UserBoard;

/**
 * 
 *nemoSystem
 *	|_ DefaultSystem
 *
 * 1. outline : 네모 로직의 BackEnd에 해당하며, Singleton 클래스이다. Controller에 의해 생성, 소멸된다. userBoard에 접근은 가능하지만 배열을 직접적으로는 수정하지 못한다.
 * 2. Written Data : 2015. 11. 27.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public abstract class CommonSystem {
	
	protected UserBoard userBoard;
	protected static CommonSystem system;
	protected static boolean isInitalized = false;
	
	/**
	 * 로직 및 Editor에서 판을 비울때 사용한다.
	 */
	public void clearBoard() {
		if(isInitalized == false) {
			System.out.println("System isn't initialized");
			return;
		}
		for(int i = 0; i < Board.HEIGHT; ++i) {
			for(int j = 0; j < Board.WIDTH; ++j) {
				userBoard.emptyCell(i, j);
			}
		}
	}
	
	/**
	 * 컨트롤러에서 UserBoard를 얻어 이벤트를 등록한다. 또는 Editor에서 맵 작성을 위해 호출한다.
	 * @return
	 */
	public UserBoard getUserBoard() {
		if(isInitalized == false) {
			System.out.println("System isn't initialized");
			return null;
		}
		return system.userBoard;
	}
	
	/**
	 * destructor
	 */
	public void finalize() {
		System.out.println("System Destroyed");
		system = null;
		isInitalized = false; //다음 get시도에서는 새로운 NemoSystem이 return된다.
	}
}
