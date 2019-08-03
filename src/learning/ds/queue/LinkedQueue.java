package learning.ds.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


/**
 * @author ashok
 *
 * @param <T>
 */
public class LinkedQueue<T> implements Queue<T> {
	
	private Node<T> front = null;
	private Node<T> rear = null;
	private int size =0;
	
	

	/* 
	 * This method adds the element to the queue.
	 */
	@Override
	public void enque(T element) {
		Node<T> temp = new Node<T>(element,null);
		size = size+1;
		if(rear==null) {
			front = temp;
			rear = temp;
			return;
		}
		
		rear.next = temp;
		rear = temp;
		

	}

	@Override
	public T deque() {
		
		if(front == null) {
			throw new QueueEmptyException("Queue is Empty");
		}
		size = size-1;
		if(front==rear) {
			T temp = front.element;
			front = null;
			rear = null;
			return temp;
		}
		T temp = front.element;
		front = front.next;
		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front==null;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator<T>();
	}

	
	@SuppressWarnings({"hiding", "unchecked"})
	public class QueueIterator<T> implements Iterator<T> {
		
		private Node<T> counter = (Node<T>) front;
		private Node<T> temp = (Node<T>) front;

		@Override
		public boolean hasNext() {
			if(counter!=front) throw new ConcurrentModificationException("Trying to add elements in queue while iterating");
			return temp!=null;
		}

		@Override

		public T next() {
			if(counter!=front) throw new ConcurrentModificationException("Trying to add elements in queue while iterating");
			T element = temp.element;
			temp = temp.next;
			return element;
		}

	}

	
	private static class Node<T> {

		T element;
		Node<T> next;

		Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;

		}

	}

}
