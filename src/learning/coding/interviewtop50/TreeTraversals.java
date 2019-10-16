package learning.coding.interviewtop50;

public class TreeTraversals {

	private static Tree root = new Tree(1, null, null);

	static {

		root.setLeft(2).setRight(3).getLeft().setLeft(4).setRight(5);
		root.getRight().setLeft(6).setRight(7);

	}

	public static void main(String[] args) {
		System.out.println("Preorder recursively");
		preOrderRecursively(root);
		
		System.out.println("PostOrder recursively");
		postOrderRecursively(root);
		
		System.out.println("InOrder recursively");
		inOrderRecursively(root);
		
		
		System.out.println("Leaves binary tree");
		printAllLeaves(root);
		
	}

	public static void inOrderRecursively(Tree root) {
		

		if (root != null) {
			inOrderRecursively(root.left);
			System.out.println(root.data);
			inOrderRecursively(root.right);


		}

	}

	public static void preOrderRecursively(Tree root) {

		if (root != null) {
			System.out.println(root.data);
			preOrderRecursively(root.left);
			preOrderRecursively(root.right);

		}
	}
	
	public static void printAllLeaves(Tree root) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				System.out.println(root.data);
				return;
				
			}
			printAllLeaves(root.left);
			printAllLeaves(root.right);

		}
	}

	public static void preOrderIteratively(Tree root) {

		if (root != null) {
			System.out.println(root.data);
			preOrderRecursively(root.left);
			preOrderRecursively(root.right);

		}
	}
	

	public static void postOrderRecursively(Tree root) {
		
		if (root != null) {
			postOrderRecursively(root.left);
			postOrderRecursively(root.right);
			System.out.println(root.data);


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

		public Tree setLeft(int data) {
			Tree newnode = new Tree(data, null, null);
			this.left = newnode;
			return this;

		}

		public Tree setRight(int data) {
			Tree newnode = new Tree(data, null, null);
			this.right = newnode;
			return this;

		}

		public Tree getLeft() {
			return this.left;
		}

		public Tree getRight() {
			return this.right;
		}

	}
}
