package learning.coding.interviewtop50;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		String str = sc.next();
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {
		char [] array = str.toCharArray();
		int last = str.length()-1;
		
		for(int i=0;i<str.length()/2;i++) {
			if(array[i]!=array[last]) return false;
			last--;
		}
		return true;
	}

}
