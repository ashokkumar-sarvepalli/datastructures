package learning.ds.setintersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HighestCommonIntersectionSet {

	public static void main(String[] args) {

		List<Set<Integer>> inputList = generateInput();
		List<List<Set<Integer>>> powerSet = computeNonEmptyPowerSet(inputList);
		print(powerSet);
		List<List<Set<Integer>>> powerSetsWithCommonElements = computeIntersectionsInPowerSet(powerSet);
		System.out.println("Print power set with common elements");
		print(powerSetsWithCommonElements);
		List<Set<Integer>> maxIntersectionSets = getHighestPossibleCombinationInIntersection(powerSetsWithCommonElements);
		
		System.out.println("Maximum combination of intersecting sets is ");
		maxIntersectionSets.forEach(System.out::println);

	}

	private static List<Set<Integer>> getHighestPossibleCombinationInIntersection(List<List<Set<Integer>>> powerSetsWithCommonElements) {
		
			
			int max = powerSetsWithCommonElements.get(0).size();
			List<Set<Integer>> maxIntersectionSets = powerSetsWithCommonElements.get(0);
			
			for(int i=1; i<powerSetsWithCommonElements.size(); i++) {
				
				if(powerSetsWithCommonElements.get(i).size()>max) {
					max =powerSetsWithCommonElements.get(i).size();
					maxIntersectionSets = powerSetsWithCommonElements.get(i);
					
				}
			}
			
			return maxIntersectionSets;
		
		}
		

	private static List<List<Set<Integer>>> computeIntersectionsInPowerSet(List<List<Set<Integer>>> powerSet) {
		List<List<Set<Integer>>> powerSetsWithCommonElements = new ArrayList<>();
		
		for(List<Set<Integer>> powerSetEntry : powerSet) {
			Set<Integer> tempSet = new HashSet<>(powerSetEntry.get(0));
			for(int i=1; i<powerSetEntry.size(); i++) {
				tempSet.retainAll(powerSetEntry.get(i));
			}
			
			System.out.println("printing inside "+tempSet);
			// there exists intersection
			if(tempSet.size()>0) {
				powerSetsWithCommonElements.add(powerSetEntry);
			}
		}
		return powerSetsWithCommonElements;
	}

	private static List<List<Set<Integer>>> computeNonEmptyPowerSet(List<Set<Integer>> inputList) {
		int n = inputList.size();
		List<List<Set<Integer>>> powerSet = new ArrayList<>();
		for (int i = 1; i < (1 << n); i++) {

			List<Set<Integer>> powerSetEntry = new ArrayList<>();
			int m = 1;
			for (int j = 0; j < n; j++) {

				if ((i & m) > 0) {
					powerSetEntry.add(inputList.get(j));
				}

				m = m << 1;
			}

			powerSet.add(powerSetEntry);

		}
		return powerSet;
	}

	private static void print(List<List<Set<Integer>>> powerSet) {
		int count =0;
		for(List<Set<Integer>> powerSetEntry : powerSet) {
			
			StringBuilder sb = new StringBuilder("{");
			
			for(Set<Integer> set : powerSetEntry) {
				
				sb.append("[");
				
				for(Integer i : set) {
					sb.append(i);
					sb.append(",");
				}
				
				sb.deleteCharAt(sb.length()-1);
				
				sb.append("]");
				sb.append(" ,");
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			sb.append("}");
			
			
			System.out.println("combination count "+ ++count +" : "+ sb.toString());
		}

	}

	private static List<Set<Integer>> generateInput() {
		List<Set<Integer>> myList = new ArrayList<>();

//		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(12, 24, 35, 46))));
//		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(12))));
//		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(24, 35))));
//		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(12, 24))));
//		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(12, 35))));
//		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(35, 46))));
		
		
		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(12))));
		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(24,12))));
		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(35))));
		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(11,12))));
		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(7))));
		myList.add(new HashSet<>(new ArrayList<Integer>(Arrays.asList(8))));

		return myList;
	}

}
