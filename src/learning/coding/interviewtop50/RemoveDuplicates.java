package learning.coding.interviewtop50;

import learning.ds.sort.Sorter;
import learning.ds.sort.SorterTypeEnum;

public class RemoveDuplicates<T> {

	public static void main(String[] args) {

		RemoveDuplicates<String> duplicatesRemove = new RemoveDuplicates<>();

		String[] s = new String[] { "Ashok", "John", "Ashok", "Peter", "John", "Peter", "John", "Thomas", "Devi",
				"Devi" };

		duplicatesRemove.removeDuplicates(s);
		
		for(int i=0;s[i]!=null;i++) {
			System.out.println(s[i]);
		}
		System.out.println(s);
	}

	@SuppressWarnings("unchecked")
	public void removeDuplicates(T[] input) {
		int count = 1;
		Sorter<Object> sorter = SorterTypeEnum.getSorter(SorterTypeEnum.MERGE_SORT.getValue());
		sorter.sort(input);
		T temp = input[0];

		for (int i = 1; i < input.length; i++) {

			if (((Comparable) (input[i])).compareTo(temp) != 0) {
				input[count++] = input[i];
				temp = input[i];
			}
		}
		
		for(int i=count;i<input.length;i++) {
			input[i] = null;
		}
	}
}
