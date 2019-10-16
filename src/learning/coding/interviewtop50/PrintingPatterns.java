package learning.coding.interviewtop50;

import java.util.Scanner;

public class PrintingPatterns {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number");
		int n = sc.nextInt();
		
		
		printRightTraingle(n);
		printRightTraingleOpposite(n);
		printPyramid(n);
		
	}

	public static void printRightTraingle(int n) {
		System.out.println();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();


	}

	public static void printRightTraingleOpposite(int n) {
		System.out.println();

		for(int i=0;i<n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();

		
	}

	public static void printPyramid(int n) {
		System.out.println();

		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			
			for(int j=1;j<=(2*i)-1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();


	}
}
