package learning.ds.stack;

/**
 * @author ashok
 *
 */
public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> myStack = new ArrayStack<>(10);
		
		myStack.push(10);
		myStack.push(25);
		myStack.push(1);
		
		
		System.out.println("Stack Conent is ");
		myStack.forEach(System.out::println);
		
		
		System.out.println("Elemnt popped off is "+myStack.pop());
		System.out.println("The top of the stack is "+myStack.peek());
		
		System.out.println("Stack Conent is ");
		myStack.forEach(System.out::println);
	}

}
