/**
 * 
 */
package nemoBoard;

/**
 * 
 *nemoBoard
 *	|_ EditBoard
 *
 * 1. outline : 에디터에서 사용하기 위한 보드. UserBoard를 상속받은 이유는 네모로직과 같은 동작을 필요로 하기 때문이다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class EditBoard extends UserBoard{
	//only for writing board
		public byte[][] getBoard(){
			return this.board;
		}
}
