package learning.coding.interviewtop50;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number");
		int n = sc.nextInt();
		System.out.println(factorial(n));
		System.out.println(factorialRecursively(n));


	}

	public static int factorial(int n) {
		
		if(n==0 || n==1) return 1;
		
		int fact = 1;
		
		for(int i=2;i<=n;i++)
		{
			fact = fact * i;
		}
		
		return fact;
	}
	
	
	public static int factorialRecursively(int n) {
		
		if(n==0 || n==1) return 1;
		
		return n  * factorialRecursively(n-1);
		
	}

}
