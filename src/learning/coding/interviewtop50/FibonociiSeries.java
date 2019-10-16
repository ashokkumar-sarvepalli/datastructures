package learning.coding.interviewtop50;

import java.util.Scanner;

/*
 * Write a simple Java program which will print Fibonacci series e.g. 1 1 2 3 5 8 13 ... . up to a given number. 

 */
public class FibonociiSeries {
	
	private static int [] cache = new int[100000];
	private static int fibonaciiKnown = 0;
	
	static {
		cache[0] =0;
		cache[1] = 1;
		fibonaciiKnown = 2;
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter the number");
		int n = sc.nextInt();
		
		
		
		for(int i=0;i<n;i++) {
			System.out.println(fibanaciiOfN(i));
		}
		
		for(int i=0;i<n+n;i++) {
			System.out.println(fibanaciiOfN(i));
		}
		
		
		

	}
	
	
	public static int fibanaciiOfN(int n) {
		
		if(n==0) return 0;
		
		if(cache[n]!=0) {
			return cache[n];
		}
		
		int a =cache[fibonaciiKnown-2];
		int b =cache[fibonaciiKnown-1];
		
		int c = -1;
		
		for(int i=fibonaciiKnown;i<=n;i++) {
			c = a+b;
			cache[i] = c;
			a = b;
			b = c;
		}
		
		fibonaciiKnown = n+1;
		return cache[n];
		
	}
	
	

}
