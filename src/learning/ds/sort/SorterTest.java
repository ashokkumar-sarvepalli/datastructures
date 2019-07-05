package learning.ds.sort;

import java.util.Arrays;

/**
 * @author ashok
 *
 */
public class SorterTest {
	
	private static Integer [] input = new Integer[] {12,1,34,56,0,54,67,23,111,11};

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Sorter<Integer> sorter = SorterTypeEnum.getSorter(SorterTypeEnum.HEAP_SORT.getValue());
		sorter.sort(input);
		Arrays.asList(input).stream().forEach(System.out::println);
		
	}

}
