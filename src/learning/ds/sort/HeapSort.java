package learning.ds.sort;

public class HeapSort<T> implements Sorter<T> {

	@Override
	public void sort(T[] arr) {
		buildHeap(arr);
		for (int i = arr.length - 1; i > 0; i--) {
			T temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}

	}

	@SuppressWarnings("unchecked")
	private void heapify(T[] arr, int n, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		T largest = arr[i];
		int largestIndex = i;

		if (left < n && ((Comparable<T>) largest).compareTo(arr[left]) < 0) {
			largest = arr[left];
			largestIndex = left;
		}
		if (right < n && ((Comparable<T>) largest).compareTo(arr[right]) < 0) {
			largest = arr[left];
			largestIndex = right;
		}

		if (largestIndex != i) {
			T temp = arr[largestIndex];
			arr[largestIndex] = arr[i];
			arr[i] = temp;

			heapify(arr, n, largestIndex);
		}

	}

	private void buildHeap(T[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}

	}

	

}
