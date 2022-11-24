package Spring.io.groundSystem.ZPractice.Java.LargeSize;

import java.util.Arrays;
import java.util.List;

public class QueueTest {
	public static void main(String[] args) {
		List asList = Arrays.asList("test1","test2","test3","test4","test5");
				
		QueueData.makeQueue();
		QueueData.getData();
		QueueData.addData("test1");
		QueueData.addData("test2");
		QueueData.addData("test3");
		QueueData.addData("test4");
		QueueData.addData("test5");
		
		System.out.println("first poll : " + QueueData.getData() +" size : " + QueueData.getSize());	
		System.out.println("first poll : " + QueueData.getData() +" size : " + QueueData.getSize());
		System.out.println("first poll : " + QueueData.getData() +" size : " + QueueData.getSize());
		System.out.println("first poll : " + QueueData.getData() +" size : " + QueueData.getSize());
		System.out.println("first poll : " + QueueData.getData() +" size : " + QueueData.getSize());
		System.out.println("first poll : " + QueueData.getData() +" size : " + QueueData.getSize());
	}
}
