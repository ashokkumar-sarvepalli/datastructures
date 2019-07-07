package learning.ds.list;

public interface List<T> extends Iterable<T> {

	public void add(T element);
	
	public void addAtFirst(T element);
	
	public boolean remove(T element);
	
	public void add(int index, T element);
	
	public boolean remove(int index);
	
	public T get(int index);
	
	public int size();
	
	public boolean contains(T element);
	
	public void reverse();
	
	public boolean isPalindrome();
	
}
