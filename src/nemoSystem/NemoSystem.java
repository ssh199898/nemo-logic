/**
 * 
 */
package nemoSystem;

import java.util.Random;

import nemoBoard.Board;
import nemoBoard.MapBoard;
import nemoBoard.UserBoard;

/**
 * 
 *org.dimigo.nemoSystem
 *	|_ MainSystem
 *
 * 1. outline : Nemo의 backend 시스템이다. Singleton 클래스이며, 프로젝트의 메인 로직이 구현되어있다.
 * 2. Written Data : 2015. 11. 25.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class NemoSystem extends CommonSystem{
	
	private MapBoard mapBoard;
	
	/**
	 * nemoSystem의 생성자.
	 * txt파일을 불러와 mapBoard에 담는다.
	 */
	private NemoSystem() {
		String[] mapFiles = NemoMapLoader.searchFolder();
		int r = (new Random()).nextInt(mapFiles.length);
		userBoard = new UserBoard();
		mapBoard = new MapBoard(mapFiles[r]); //to random
	}
	
	/**
	 * initalizer
	 */
	private static void initialize() {
		system = new NemoSystem();
		isInitalized = true;
		System.out.println("NemoSystem Initiated");
	}
	
	/**
	 * system 클래스를 얻어온다.
	 * @return
	 */
	public static NemoSystem getSystem() {
		if(isInitalized == false) {
			initialize();
			return (NemoSystem)system;
		} else {
			return (NemoSystem)system;
		}
	}
	
	/**
	 * mapBoard를 리턴한다.
	 * @return
	 */
	public MapBoard getMapBoard() {
		if(isInitalized == false) {
			System.out.println("System isn't initialized");
			return null;
		}
		return ((NemoSystem)system).mapBoard;
	}
	
	/**
	 * userBoard와 mapBoard의 데이터를 비요한다. 같을 경우 true를 리턴한다.
	 * @return
	 */
	public boolean checkBoard() {
		if(isInitalized == false) {
			System.out.println("System isn't initialized");
			return false;
		}
		int wrongCount = 0;
		
		for(int i = 0; i < Board.HEIGHT; ++i) {
			for(int j = 0; j < Board.WIDTH; ++j) {
				if(userBoard.isCellFilled(i, j) != mapBoard.isCellFilled(i, j)) {
					++wrongCount;
				}
			}
		}
		
		if(wrongCount == 0) {
			System.out.println("성공");
			return true;
		} else {
			System.out.println("실패");
			return false;
		}
	}
	
	/**
	 * userBoard를 모두 비운다.
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

}
