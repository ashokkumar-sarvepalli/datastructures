package learning.ds.sort;

import java.util.function.Supplier;

/**
 * @author ashok
 *
 */
public enum SorterTypeEnum {

	BUBBLE_SORT("Bubble", BubbleSort::new), INSERTION_SORT("Insertion", InsertionSort::new),
	MERGE_SORT("Merge", MergeSort::new), SELECTION_SORT("Selection", SelectionSort::new),
	HEAP_SORT("Heap",HeapSort::new);

	private String value;
	private Supplier<Sorter> sorter;

	SorterTypeEnum(String value, Supplier<Sorter> sorter ) {
		this.value = value;
		this.sorter = sorter;
	}

	public Sorter getIntance() {
		return this.sorter.get();
	}

	public static Sorter getSorter(String value) {

		for (SorterTypeEnum sorter : SorterTypeEnum.values()) {
			if (sorter.value.equalsIgnoreCase(value)) {
				return sorter.getIntance();
			}
		}

		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

		
}
