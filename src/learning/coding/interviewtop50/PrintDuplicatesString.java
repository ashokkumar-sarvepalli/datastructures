package learning.coding.interviewtop50;

import java.util.Scanner;

public class PrintDuplicatesString {
	
	
	public static void main(String []args) {
		int [] chars = new int[256];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = sc.nextLine();
		
		for(int i=0;i<str.length();i++) {
			
			if(chars[str.charAt(i)]==1) {
				System.out.println(str.charAt(i));
			}
			
			chars[str.charAt(i)]++;
		}
	}
	

}
