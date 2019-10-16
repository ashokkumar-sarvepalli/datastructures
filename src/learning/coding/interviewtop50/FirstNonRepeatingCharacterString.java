package learning.coding.interviewtop50;

import java.util.Scanner;

public class FirstNonRepeatingCharacterString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First one");
		String str = sc.next();
		System.out.println(firstNonRepeatingCharacterOfaString(str));
		
		

	}

	private static char firstNonRepeatingCharacterOfaString(String str) {

		
        int [] chars = new int[256];
		
		for(int i=0;i<str.length();i++) {
			chars[str.charAt(i)]++;
		}
		
		for(int i=0;i<str.length();i++) {
			
			if(chars[str.charAt(i)]==1) return str.charAt(i);
		}
		
		return ' ';
		
	}

}
