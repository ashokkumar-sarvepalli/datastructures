package learning.ds.sort;

/**
 * @author ashok
 *
 * @param <T>
 */
public class BubbleSort<T> implements Sorter<T>{

	@Override
	@SuppressWarnings({ "unchecked" })
	public void sort(T[] arr) {
		System.out.println("In Bubble Sort");
		for(int i=0;i<arr.length-1;i++) {
			
			for(int j=0;j<arr.length-1-i;j++) {
				
				if(((Comparable<T>)arr[j]).compareTo(arr[j+1])>0) {
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
		
	}

}
