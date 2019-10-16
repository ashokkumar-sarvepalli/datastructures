package learning.coding.interviewtop50;

import java.util.Scanner;

public class CheckAnagram {

	public static void main(String[] args) {
	
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String one");
		String str = sc.next();
		System.out.println("Enter the String two");
		String str2 = sc.next();
		System.out.println(isAnagram(str,str2));

	}

	private static boolean isAnagram(String first, String second) {
		
		if(first.length()!=second.length()) return false;
		
		int [] chars = new int[256];
		
		for(int i=0;i<first.length();i++) {
			chars[first.charAt(i)]++;
		}
		
		for(int i=0;i<second.length();i++) {
			
			chars[second.charAt(i)]--;
			
			// second string had more characters-- no more job to do return false
			if(chars[second.charAt(i)]<0) return false;
			
			
			// string to be read characters is less than the existing stuff
			if(chars[second.charAt(i)]>(second.length()-i)) return false;
		}
		
		
		for(int i=0;i<chars.length;i++) {
			if(chars[i]!=0) return false;
		}
		
		return true;
	}

}
