package learning.ds.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author ashok
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> , Iterable<T>{
	
	private Object [] arr;
	private int top = -1;
	private int size;
	
	public ArrayStack(int size) {
		arr = new Object[size];
		this.size = size;
	}

	@Override
	public void push(T element){
		
		if(top ==  size-1) {
			throw new StackOverFlowException("Cannot add more elements in to array stack, Stack is overflow");
		}
		
		top = top + 1;
		arr[top] = element;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T pop() {
		if(top==-1) {
			throw new StackUnderFlowException("No element in the stack to remove");
		}
		T temp = (T) arr[top];
		top = top-1;
		return temp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T peek() {
		if(top==-1) {
			return null;
		}
		T temp = (T) arr[top];
		return temp;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public int size() {
		return top+1;
	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator<T>();
	}

	
	@SuppressWarnings("hiding")
	public class StackIterator<T> implements Iterator<T> {
		
		
		
		int counter = top;
		int temp = top;

		@Override
		public boolean hasNext() {
			if(top!=counter) throw new ConcurrentModificationException("Concurrent modification while iterating");
			return temp!=-1;
		}

		@Override
		@SuppressWarnings("unchecked")

		public T next() {
			if(top!=counter) throw new ConcurrentModificationException("Concurrent modification while iterating");
			T ele = (T) arr[temp];
			temp = temp-1;
			return ele;
		}

	}

}
