package learning.ds.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author ashok
 *
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {

	private int front = -1;
	private int rear = -1;
	private int size = 0;

	private Object[] queue;

	public ArrayQueue(int size) {
		this.size = size;
		queue = new Object[size];

	}

	@Override
	public void enque(T element) {

		if (rear == size - 1) {
			throw new QueueFullException("The queue is full");
		}

		if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = element;
			return;
		}

		rear = rear + 1;
		queue[rear] = element;

	}

	@Override
	@SuppressWarnings("unchecked")

	public T deque() {
		if (front == -1) {
			throw new QueueEmptyException("The queue is empty");
		}

		if (front == rear) {
			T element = (T) queue[front];
			front = -1;
			rear = -1;
			return element;
		}

		T element = (T) queue[front];
		front = front + 1;
		return element;
	}

	@Override
	public int size() {
		if(front==-1) return 0;
		return (rear - front) + 1;
	}

	@Override
	public boolean isEmpty() {
		return front == -1;
	}

	@Override
	public Iterator<T> iterator() {

		return new QueueIterator<T>();
	}

	@SuppressWarnings("hiding")
	public class QueueIterator<T> implements Iterator<T> {
		
		private int frontCounter = front;
		private int rearCounter = rear;
		private int tempFront = front;
		private int tempRear = rear;
		@Override
		public boolean hasNext() {
			if(frontCounter!=front || rearCounter !=rear) throw new ConcurrentModificationException("Trying to add elements in queue while iterating");
			return tempFront<=tempRear;
		}

		@Override
		@SuppressWarnings("unchecked")

		public T next() {
			if(frontCounter!=front || rearCounter !=rear)  throw new ConcurrentModificationException("Trying to add elements in queue while iterating");
			T element = (T) queue[tempFront];
			tempFront = tempFront + 1;
			return element;
		}

	}

}
