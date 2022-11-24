package Spring.io.groundSystem.ZPractice.Java.LargeSize;

import java.util.LinkedList;
import java.util.Queue;

public class QueueData {

	private static Queue queue;
	
	public static <E, e> void makeQueue() {
		queue = new LinkedList<e>();
	}
	
	public static <E, e> void addData(E e) {
		queue.add(e);
	}

	public static <T> T getData() {
		return (T) queue.poll();
	}
	
	public static int getSize() {
		return queue.size();
	}

}
