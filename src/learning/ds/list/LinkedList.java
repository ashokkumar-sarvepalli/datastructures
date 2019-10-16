package learning.ds.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class LinkedList<T> implements List<T> {
	
	private Node<T> head = null;
	private Node<T> rear = null;
	private int size = 0;
	private int changeCount =0;

	

	/*
	 * This method is responsible for adding element in to a list.
	 * It adds at the end of the list
	 */
	@Override
	public void add(T element) {
		Node<T> temp = new Node<T>(element,null);
		size++;
		changeCount++;
		if(head==null) {
			head = temp;
			rear = temp;
			return;
		}
		
		rear.next = temp;
		rear = temp;
		
	}
	
	
	/*
	 * This method is responsible for adding element at the beginning of the list
	 */
	@Override
	public void addAtFirst(T element) {
		Node<T> temp = new Node<T>(element,null);
		size++;
		changeCount++;
		if(head==null) {
			head = temp;
			rear = temp;
			return;
		}
		
		temp.next = head;
		head = temp;
		
	}
	
	/*
	 * This method is responsible for adding element at a particular index of the list
	 * If the index is out of bound it will throw exception
	 */
	@Override
	public void add(int index, T element) {
		
		if(index>size || index<0) {
			throw new ArrayIndexOutOfBoundsException("Out of the range of linked list");
		}
		
		if(index==size) {
			// add at last
			add(element);
			return;
		}
		
		if(index==0) {
			// add at beginning
			addAtFirst(element);
			return;
		}
		
		
		Node<T> temp = head;
		Node<T> prev = null;
		int pos =0;
		Node<T> newNode = new Node<T>(element,null);
		while(temp!=null) {
			if(index==pos) {
				newNode.next = temp;
				prev.next = newNode;
				size = size+1;
				changeCount = changeCount+1;
				return;
				
				
			}
			pos++;
			prev = temp;
			temp = temp.next;
		}
		
		
		
		
	}

	/*
	 * This method removes the particular element in the list
	 */
	@Override
	public boolean remove(T element) {
		
		Node<T> temp = head;
		Node<T> prev = null;
		
		while(temp!=null) {
			if(element!=null && temp.element!=null && temp.element.equals(element)) {
				if(prev==null) {
					head = head.next;
				}
				else {
					prev.next = temp.next;
				}
				size = size-1;
				changeCount = changeCount + 1;
				return true;
			}
			
			prev = temp;
			temp = temp.next;
		}
		
		
		return false;
		
		
	}
	
	/*
	 * This method removes the element in the beginning of the list
	 */
	public boolean removeAtBeginning() {
		
		if(head==null) {
			return false;
		}
		
		head = head.next;
		size = size-1;
		changeCount = changeCount + 1;
		
		return false;
	}

	
	/*
	 * This method is responsible for removing element in to a list.
	 * It removes based on a index being passed
	 */
	@Override
	public boolean remove(int index) {

		if(index>=size || index<0) {
			throw new ArrayIndexOutOfBoundsException("Out of the range of linked list");
		}
		
		if(index==0) {
			return removeAtBeginning();
		}
		
		Node<T> temp = head;
		Node<T> prev = null;
		int pos = 0;
		
		while(temp!=null) {
			
			if(index==pos) {
				prev.next = temp.next;
				size = size-1;
				changeCount = changeCount+1;
				return true;
				
			}
			
			pos = pos+1;
			prev = temp;
			temp = temp.next;
			
		}
		return false;
	}

	/*
	 * This method gets a element in a list based on the index being passed
	 */
	@Override
	public T get(int index) {
		if(index>=size || index<0) {
			throw new ArrayIndexOutOfBoundsException("Out of the range of linked list");
		}
		
		Node<T> temp = head;
		int pos = 0;
		
		while(temp!=null) {
			
			if(index==pos) {
				return temp.element;
			}
			pos = pos+1;
			temp = temp.next;
			
		}
		return null;
	}

	/*
	 * returns the number of elements in the list
	 * 
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * This method searches an element in the list
	 */
	@Override
	public boolean contains(T element) {
		Node<T> temp = head;
		
		while(temp!=null) {
			if(element!=null && temp.element!=null && temp.element.equals(element)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	
	/*
	 * This method completely reverses the linked list
	 * 
	 */
	@Override
	public void reverse() {
		
		if(head==null || head.next==null) return;
		
		Node<T> previous = head;
		Node<T> current = head.next;
		previous.next = null;
		Node<T> next = null;
		
		while(current!=null) {
			next = current.next;
			current.next = previous;
			
			previous = current;
			current = next;
		}
		rear = head;
		head = previous;
		
		
	}
	
	
	
	public boolean isPalindrome() {
		
		if(head==null) return false;
		if(head.next==null) return true;
		
		if(size()==2) { 
			
			if(head.element.equals(head.next.element)) return true;
			return false;
		}
		
		int middle = size()/2;
		int index =1;
		
		Node<T> previous = head;
		Node<T> current = head.next;
		previous.next = null;
		Node<T> next = null;
		
		while(index<middle) {
			
			next = current.next;
			current.next = previous;
			
			previous = current;
			current = next;
			
			index ++;
			
		}
		
		Node<T> backward = previous;
		Node<T> forward = null;
		if(size%2!=0) {
			forward = current.next;
		}
		else {
			forward = current;
		}
		
		
		
		while(backward!=null && forward!=null) {
			
			if(!forward.element.equals(backward.element)) {
				return false;
			}
			
			backward = backward.next;
			forward = forward.next;
		}
		
		if(backward!=null || forward!=null) return false;
		
		return true;
		
		
		
		
	}

	
	/*
	 * Iterator to iterate the linked list
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>();
	}
	
	
	/*
	 * This inner class is responsible for iterating the linked list
	 * while iteration no other thread should do the change 
	 * So change count is being checked.
	 */
	@SuppressWarnings({"hiding", "unchecked"})
	public class ListIterator<T> implements Iterator<T> {
		
		private int counter = changeCount;
		private Node<T> temp = (Node<T>) head;

		@Override
		public boolean hasNext() {
			if(counter!=changeCount) throw new ConcurrentModificationException("Trying to add/remove elements while iterating");
			return temp!=null;
		}

		@Override

		public T next() {
			if(counter!=changeCount) throw new ConcurrentModificationException("Trying to add/remove elements while iterating");
			T element = temp.element;
			temp = temp.next;
			return element;
		}

	}

	/*
	 * This is the node struct we are maintaining
	 * Containing the actual data and next element of the linked list
	 * 
	 */
	private static class Node<T>{
		T element;
		Node<T> next;
		
		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}
	}

}
