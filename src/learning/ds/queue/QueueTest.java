package learning.ds.queue;

public class QueueTest {
	
	public static void main(String []args) {
		
		Queue<Integer> myQueue = new ArrayQueue<Integer>(10);
		myQueue.enque(10);
		myQueue.enque(25);
		myQueue.enque(8);
		myQueue.enque(27);
		myQueue.enque(21);
		
		
		System.out.println("BeforeRemoving queue content");
		myQueue.forEach(System.out::println);
		
		System.out.println("Element removed is "+myQueue.deque());
		
		System.out.println("AfterRemoving queue content");
		myQueue.forEach(System.out::println);
		
		System.out.println("Number of elements in the queue "+myQueue.size());
		
		while(!myQueue.isEmpty()) {
			myQueue.deque();
		}
		
		System.out.println("Number of elements in the queue "+myQueue.size());
	}

}
