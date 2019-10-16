package learning.coding.interviewtop50;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number");
		int n = sc.nextInt();
		System.out.println(isPrime(n));

	}

	public static boolean isPrime(int n) {
		
		if(n<=1) return false;
		
		if(n==2 || n==3) return true;
		
		if(n%2==0) return false;
		
		int squareRootOfN = (int) (Math.sqrt(n));

		for(int i=3;i<=squareRootOfN;i=i+2) {
			if(n%i==0) return false;
		}
		
		return true;
	}

}
