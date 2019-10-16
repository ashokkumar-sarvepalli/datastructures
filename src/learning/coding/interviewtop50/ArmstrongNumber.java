package learning.coding.interviewtop50;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		System.out.println(isArmStrongNumber(number));
	}

	private static boolean isArmStrongNumber(int number) {
	    int input = number;
		int sum =0;
		while(input>0) {
			int temp =  (input % 10);
			sum = sum + (temp * temp * temp);
			input = input/10;
		}
		return number==sum;
	}

}
