package learning.ds.list;

public class LinkedListTest {

	public static void main(String[] args) {
		
		List<String> myList = new LinkedList<>();
		
		myList.add("ashok");
		myList.add("devi");
		myList.add("thushith");
		myList.addAtFirst("murali");
		myList.addAtFirst("karthik");
		myList.add(5,"naresh");
		myList.add(5,"kartheek");

		System.out.println("Printing list");
		myList.forEach(System.out::println);
		
		
		myList.remove(5);
		myList.remove("karthik");
		
		System.out.println("Printing after removal");

		
		myList.forEach(System.out::println);
		
		System.out.println("------");
		
		System.out.println(myList.contains("ashok"));
		System.out.println(myList.contains("peter"));
		
		System.out.println(myList.get(3));
		System.out.println(myList.size());
		
		myList.reverse();
		
		System.out.println("After reversal");
		myList.forEach(System.out::println);
		myList.add("Peter");
		myList.add("murali");
		myList.add("ashok");
		myList.add("devi");
		myList.add("thushith");
		myList.add("naresh");
		
		
		System.out.println("adding reverse elements");
		myList.forEach(System.out::println);
		
		System.out.println("palindrome check"+myList.isPalindrome());
		
	}

}
