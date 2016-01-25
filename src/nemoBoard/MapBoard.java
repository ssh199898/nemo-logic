/**
 * 
 */
package nemoBoard;

import java.util.ArrayList;
import java.util.List;

import nemoSystem.NemoMapLoader;

/**
 * 
 *org.dimigo.nemoBoard
 *	|_ MapBoard
 *
 * 1. outline : 네모 로직의 정답 데이터와 가로, 세로 숫자 정보를 가지고 있는 배열이다.
 * 2. Written Data : 2015. 11. 24.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class MapBoard extends Board{
	//현재 맵의 이름.
	private String mapName;
	
	/**
	 * 네모로직의 위와 옆에 띄울 숫자들을 담는 리스트이다.
	 */
	public List<ArrayList<Integer>> leftList = new ArrayList<ArrayList<Integer>>();
	public List<ArrayList<Integer>> topList = new ArrayList<ArrayList<Integer>>();
	
	/**
	 * constructor
	 */
	public MapBoard(String fileName) {
		this.mapName = fileName.substring(0, fileName.length() - 4);
		board = NemoMapLoader.load("maps/" + fileName);
		//첫번째 줄부터 마지막 줄까지 가로 방향으로 탐색.
		initLeftList();
		//첫번째 열부터 마지막 열까지 세로 방향으로 탐색.
		initTopList();
	};
	
	/**
	 * 첫번째 줄부터 마지막 줄까지 가로 방향으로 탐색.
	 */
	private void initLeftList() {
		for(int i = 0; i < HEIGHT; ++i) {
			leftList.add(new ArrayList<Integer>()); //리스트를 먼저 생성한다.
			
			int size = 0;
			for(int j = 0; j < WIDTH-1; ++j) {
				if(board[i][j] == 0)
					continue;
				
				if(board[i][j] == 1) {
					++size;
					
					if(board[i][j+1] == 0) {
						leftList.get(i).add(size);
						size = 0;
					}
				}
			}
			
			if(board[i][WIDTH-1] == 1) {
				++size;
				leftList.get(i).add(size);
			}
		}
	}
	
	/**
	 * list.get(j).get(i)꼴로. 보드의 넓이가 List의 길이가 된다.
	 * 첫번째 열부터 마지막 열까지 세로 방향으로 탐색.
	*/
	private void initTopList() {
		for(int j = 0; j < WIDTH; ++j) { //board[i][j]
			topList.add(new ArrayList<Integer>()); //리스트를 먼저 생성한다.
			
			int size = 0;
			for(int i = 0; i < HEIGHT-1; ++i) {
				if(board[i][j] == 0)
					continue;
				
				if(board[i][j] == 1) {
					++size;
					
					if(board[i+1][j] == 0) {
						topList.get(j).add(size);
						size = 0;
					}
				}
			}
			
			if(board[HEIGHT-1][j] == 1) {
				++size;
				topList.get(j).add(size);
			}
		}
	}
	
	/**
	 * @return mapName
	 */
	public String getMapName() {
		return mapName;
	}
}
