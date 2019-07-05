package learning.ds.queue;

/**
 * @author ashok
 *
 * @param <T>
 */
public interface Queue<T> extends Iterable<T> {
	
	public void enque(T element);
	
	public T deque();
	
	public int size();
	
	public boolean isEmpty();

}
