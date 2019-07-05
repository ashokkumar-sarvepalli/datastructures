package learning.ds.sort;

/**
 * @author ashok
 *
 * @param <T>
 */
public class InsertionSort<T> implements Sorter<T> {

	@Override
	@SuppressWarnings({ "unchecked" })
	public void sort(T[] arr) {
		System.out.println("In Insertion Sort");
		for (int i = 1; i < arr.length; i++) {
			T element = arr[i];
			int j = i - 1;
			while (j >= 0 && ((Comparable<T>) arr[j]).compareTo(element) > 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = element;
		}
	}

}
