package learning.coding.interviewtop50;

public class ArraySizeTest {

	public static void main(String[] args) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			try {
				int[] arr = new int[Integer.MAX_VALUE-i];
				System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE-i);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

	}

}
