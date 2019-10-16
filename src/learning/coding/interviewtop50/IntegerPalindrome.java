package learning.coding.interviewtop50;

import java.util.Scanner;

public class IntegerPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		System.out.println(isPalindrome(number));
	}

	private static boolean isPalindrome(int number) {
	
		int rev =0;
		while(number>rev) {
			rev = rev * 10 + (number % 10);
			number = number/10;
		}
		return number==rev || number==rev/10;
	}
}
