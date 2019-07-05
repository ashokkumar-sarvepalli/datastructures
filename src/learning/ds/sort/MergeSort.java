package learning.ds.sort;

/**
 * @author ashok
 *
 * @param <T>
 */
public class MergeSort<T> implements Sorter<T> {

	@Override
	public void sort(T[] arr) {
		System.out.println("In Merge Sort");
		mergeSort(0,arr.length-1,arr);

	}

	private void mergeSort(int left, int right, T[] arr) {

		if (left < right) {

			int middle = (left + right) / 2;

			mergeSort(left, middle, arr);
			mergeSort(middle + 1, right, arr);

			merge(left, middle, right, arr);

		}
	}

	@SuppressWarnings("unchecked")
	private void merge(int left, int middle, int right, T[] arr) {

		int n1 = middle - left + 1;
		int n2 = right - middle;

		Object[] A = new Object[n1];
		Object[] B = new Object[n2];

		int l = 0, m = 0;

		for (int i = left; i <= middle; i++) {
			A[l++] = arr[i];
		}

		for (int i = middle + 1; i <= right; i++) {
			B[m++] = arr[i];
		}

		l = 0;
		m = 0;
		int k = left;

		while (l < n1 && m < n2) {

			if (((Comparable<T>) A[l]).compareTo((T)B[m]) < 0) {
				arr[k] = (T) A[l];
				k++;
				l++;
			}

			else {
				arr[k] = (T) B[m];
				k++;
				m++;

			}
		}

		while (l < n1) {
			arr[k] = (T) A[l];
			k++;
			l++;
		}

		while (m < n2) {
			arr[k] = (T) B[m];
			k++;
			m++;
		}

	}
}
