package Spring.io.groundSystem.ZPractice.Java.LargeSize;

import java.util.LinkedList;
import java.util.Queue;

public class TestMain {
	
	private static Queue queue = new LinkedList<>();
	
	public static void main(String[] args) {
		
		TestMain tm = new TestMain();
		while(true) {
			long time = System.currentTimeMillis();	
			if(time%2 == 0) {
				tm.fn_call(time);
			}
			
			if(time%2 == 1) {
				System.out.println(queue.poll());
			}
		}
	}
	
	public void fn_call(long data) {
		System.out.println("add data");
		this.queue.add(data);
	}
}
