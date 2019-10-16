package learning.coding.interviewtop50;

import java.util.Scanner;

public class Gcd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1, num2;

		System.out.println("Enter the first number");

		num1 = sc.nextInt();

		System.out.println("Enter the second number");

		num2 = sc.nextInt();

		System.out.println(gcdIteratively(num1, num2));
		System.out.println(gcdRecursively(num1, num2));

	}

	private static int gcdRecursively(int num1, int num2) {
		
		if(num2==0) {
			return num1;
		}
		
		return gcdRecursively(num2,num1%num2);

	}

	private static int gcdIteratively(int num1, int num2) {

		int min = Math.min(num1, num2);

		if (num1 % min == 0 && num2 % min == 0)
			return min;

		// iterate from the mid of the smallest in backward direction.

		for (int i = min / 2; i >= 2; i--) {
			if (num1 % i == 0 && num2 % i == 0)
				return i;
		}
		return 1;
	}

}
