package learning.coding.interviewtop50;

import java.util.Scanner;

public class SquareRootWithOutMathSqrt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number");
		int n = sc.nextInt();
		System.out.println(squareRootUsingLog(n));
		System.out.println(squareRootBinarySearch(n));
	}

	private static int squareRootBinarySearch(int n) {
		
		int start =0;
		int end = n;
		
		int middle = -1;
		int square = -1;
		int result = -1;
		
		while(start<=end) {
			middle = (start+end)/2;
			square = middle * middle;
			
			if(square==n) return middle;
			if(square > n) {
				end = middle -1;
			}
			
			else if(square<=n) {
				
				start = middle +1;
				result = middle;
			}
		}
		return result;
	}

	private static double squareRootUsingLog(int n) {
		
		
		return Math.pow(10, 0.5 * Math.log10(n));
	}

}
