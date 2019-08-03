package learning.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintNodesAtKDistance {

	public static void main(String[] args) {
		Tree data1 = new Tree(4, null, null);
		Tree data2 = new Tree(5, null, null);
		Tree data3 = new Tree(8, null, null);

		Tree data4 = new Tree(2, data1, data2);
		Tree data5 = new Tree(3, data3, null);
		Tree root = new Tree(1, data4, data5);

		printNodesAtKDistance(root, 2);
		System.out.println("print all paths");
		printAllPathsInATree(root);

	}

	private static void printAllPathsInATree(Tree root) {
		
		List<Integer> paths = new ArrayList<>();
		printAllPathsInATreeRecursively(root,paths);
		
		
	}

	private static void printAllPathsInATreeRecursively(Tree root, List<Integer> paths) {
		
		if(root!=null) {
			
			paths.add(root.data);
			
			if(root.left==null && root.right==null)
			{
				System.out.println(paths);
				
				return;
			}
			
			
			printAllPathsInATreeRecursively(root.left,paths);
			
			// backtrack
			paths.remove(paths.size()-1);
						
			printAllPathsInATreeRecursively(root.right,paths);
			
			// backtrack
			paths.remove(paths.size()-1);
			
			
		}
		
		
		
	}

	private static void printNodesAtKDistance(Tree root, int distance) {

		printNodesAtKDistanceRecursively(root, distance, 0);
		System.out.println("Bfs way");
		printNodesAtKDistanceBfs(root,distance);

	}

	private static void printNodesAtKDistanceBfs(Tree root, int distance) {
		
		
		Queue<Tree> bfsQueue = new LinkedList<>();
		
		bfsQueue.add(root);
		int depth =0;
		
		while(!bfsQueue.isEmpty()) {
			depth  = depth + 1;
			
			if(depth>distance)  break;
			
			Queue<Tree> tempQueue = new LinkedList<>();
			while(!bfsQueue.isEmpty()) {
				Tree temp = bfsQueue.poll();
				
				if(temp.left!=null)
				{
				tempQueue.add(temp.left);
				}
				
				if(temp.right!=null) {
					tempQueue.add(temp.right);
				}
				
			}
			
			if(depth == distance) {
				tempQueue.forEach(tree -> System.out.println(tree.data));
			}
			
			
			bfsQueue = tempQueue;
			
			
			
		}
		
	}

	private static void printNodesAtKDistanceRecursively(Tree root, int distance, int depth) {

		if (root != null && depth<=distance) {
			if (depth == distance) {
				System.out.println(root.data);
			}

			printNodesAtKDistanceRecursively(root.left, distance, depth + 1);
			printNodesAtKDistanceRecursively(root.right, distance, depth + 1);

		}

	}

	private static class Tree {

		int data;
		Tree left;
		Tree right;

		public Tree(int data, Tree left, Tree right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

}
