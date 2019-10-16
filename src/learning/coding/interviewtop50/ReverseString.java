package learning.coding.interviewtop50;

import java.util.Scanner;

public class ReverseString {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the String");
			String str = sc.next();
			System.out.println(reverse(str));
			System.out.println(reverseRecursively(str));

		}

		public static String reverse(String str) {
			char [] array = str.toCharArray();
			int last = str.length()-1;
			char temp;
			for(int i=0;i<str.length()/2;i++) {
				temp = array[i];
				array[i] = array[last];
				array[last] = temp;
				last--;
			}
			return String.valueOf(array);
		}

		
		public static String reverseRecursively(String str) {
			if(str.length()==1) return str;
			return str.substring(str.length()-1) + reverseRecursively(str.substring(0,str.length()-1));
		}
		

}
