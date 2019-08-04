package learning.ds.backtracking;

import java.util.Scanner;

public class NQueenProblem {
	
	private static boolean isFound = false;
	private static int count =0;
	
	public static void main(String []args) {
		int n;
		System.out.println("Enter the number of squares");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		char [][] board = new char[n][n];
		
		initalizeBoard(board,n);
		System.out.println("Board before placing queens");
		printBoard(board,n);
		
		
		placeQueen(board,0,n);
		
		if(!isFound) {
			System.out.println("No solution");
		}
		else {
			System.out.println("Total solutions "+count);
		}
		
	}
	
	
	private static void placeQueen(char[][] board, int row, int n) {
		
		
		if(row==n) {
			System.out.println("N QUEEN SOLUTION");
			printBoard(board,n);
			isFound = true;
			count++;
			return;
		}
		
		
		for(int column=0;column<n;column++) {
			if(isCorrectPosition(board,row,column,n)) {
				board[row][column] = 'Q';
				placeQueen(board,row+1,n);
				// backtracking
				board[row][column] = 'X';
			}
		}
		
		
		
		
	}






	public static boolean isCorrectPosition(char [][]board, int i, int j, int n) {
		
		
	
		for(int m=0;m<n;m++) {
			if(board[i][m] == 'Q') return false;
			if(board[m][j] == 'Q') return false;
		}
		
		int p = i;
		int q = j;
		while(p<n && q<n) {
			if(board[p++][q++]=='Q') return false;
		}
		
		p = i;
		q = j;
		
		while(p>=0 && q>=0)
		{
			if(board[p--][q--]=='Q') return false;
		}
		
		
		p = i;
		q = j;
		
		while(p>=0 && q<n)
		{
			if(board[p--][q++]=='Q') return false;
		}
		
		
		p = i;
		q = j;
		
		while(q>=0 && p<n)
		{
			if(board[p++][q--]=='Q') return false;
		}
		
		
		return true;
		
		
	}
	
	
	public static void initalizeBoard(char [][]board, int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 'X';
			}
		}
	}
	
	
	public static void printBoard(char [][]board, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}
