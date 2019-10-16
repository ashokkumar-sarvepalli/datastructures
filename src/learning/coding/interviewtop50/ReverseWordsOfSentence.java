package learning.coding.interviewtop50;

import java.util.Scanner;

public class ReverseWordsOfSentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = sc.nextLine();
		
		String [] words = str.split("\\s+");
		int length = words.length-1;
		
		for(int i=0;i<words.length/2;i++) {
			String temp = words[i];
			words[i] = words[length];
			words[length] = temp;
			
			length--;
		}
		
		for(int i=0; i<words.length; i++) {
			System.out.print(words[i]+" ");
		}
		
	}

}
