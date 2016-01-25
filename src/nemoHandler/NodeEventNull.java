/**
 * 
 */
package nemoHandler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

/**
 * 
 *nemoHandler
 *	|_ ButtenExitedNull
 *
 * 1. outline : 노드들의 모든 Effect를 지우고 원상태로 되돌린다.
 * 2. Written Data : 2015. 11. 26.
 *
 * @author		: ssh19
 * @version		: 1.0
 */
public class NodeEventNull implements EventHandler<Event> {

		@Override
		public void handle(Event event) {
			((Node) event.getSource()).setEffect(null);
		}
	}