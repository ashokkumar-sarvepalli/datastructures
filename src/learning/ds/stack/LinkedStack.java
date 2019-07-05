package learning.ds.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author ashok
 *
 * @param <T>
 */
public class LinkedStack<T> implements Stack<T> {
	
	private Node<T> top;
	private int size=0;
	
	@Override
	public void push(T element) {
		Node<T> temp = new Node<T>(element,null);
		
		size =size+1;
		if(top==null) {
			top = temp;
			return;
		}
		
		temp.next = top;
		top = temp;
		
		
		
	}

	@Override
	public T pop() {
		if(top==null) {
			throw new StackUnderFlowException("No element in the stack to remove");
		}
		T temp = top.element;
		top = top.next;
		size = size-1;
		return temp;
	}

	@Override
	public T peek() {
		if(top==null) {
			return null;
		}
		T temp = top.element;
		return temp;
	}
	
	public int size() {
		return size;
	}
	
	private static class Node<T>{
		
		T element;
		Node<T> next;
		
		Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
			
		}

	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new StackIterator<T>();
	}

	
	@SuppressWarnings({ "unchecked", "hiding" })
	private class StackIterator<T> implements Iterator<T> {
		
		
		Node<T> position = (Node<T>) top;
		Node<T> temp = (Node<T>) top;

		@Override
		public boolean hasNext() {
			if(top!=position) throw new ConcurrentModificationException("Concurrent modification while iterating");
			return temp!=null;
		}

		@Override
		public T next() {
			if(top!=position) throw new ConcurrentModificationException("Concurrent modification while iterating");
			T ele = (T) temp.element;
			temp = temp.next;
			return ele;
		}

	}

}
