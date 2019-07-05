package learning.ds.stack;

/**
 * @author ashok
 *
 * @param <T>
 */
public interface Stack<T> extends Iterable<T>{
	
	public void push(T element);
	
	public T pop();
	
	public T peek();
	
	public int size();
	
	public boolean isEmpty();

}
