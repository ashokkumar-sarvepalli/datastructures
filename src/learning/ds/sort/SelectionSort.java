package learning.ds.sort;

/**
 * @author ashok
 *
 * @param <T>
 */
public class SelectionSort<T> implements Sorter<T> {

	@Override
	@SuppressWarnings({ "unchecked" })
	public void sort(T[] arr) {
		System.out.println("In Selection Sort");
		for (int i = 0; i < arr.length; i++) {
			T min = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (((Comparable<T>) min).compareTo(arr[j]) > 0) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				T temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}

		}

	}

}
