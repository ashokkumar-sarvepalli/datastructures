package learning.ds.string;

import java.util.Map;

public class MapEquality {

	public static void main(String[] args) {

	}

	public boolean isBothAreEqual(Map<Character, Integer> originalMap, Map<Character, Integer> tempMap) {
		return originalMap.entrySet().stream()
				.allMatch((element -> element.getValue().equals(tempMap.get(element.getKey()))));

	}

}
