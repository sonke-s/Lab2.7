
public class StackAsList implements Stack { 

	private Node top;

	@Override
	public boolean isEmpty() {
		if(top != null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public String toString()
	{
		String s = "";
		Node current = top;
		while(current != null)
			{
				if(s.isEmpty()) {
					s = "" + current.getData();
					current = current.next;
				} else {
					s = s + "; " + current.getData();
					current = current.next;
				}
			}
		return s;
	}
	
	@Override
	public Object peek() {
		try {							// catches an exception for when 
		return top.getData();			// there is the request to peek	
		} catch (Exception e) {			// but the Stack is empty
			return "Error: The Stack is empty!";
		}
	}
	
	@Override
	public void push(Object elem) {
		try {
		Node newNode = new Node(elem);				// We don't really need this try-catch
		newNode.next = top;							// as the linked List could grow
		top = newNode;								// endlessly so the exception will
		} catch (Exception e) {						// never be thrown
			System.out.println("Error: The Stack is full");
		}
	}
	@Override
	public Object pop() {
		try {							// catches an exception for when 
		Node newNode = top;				// there is the request to pop
		top = top.next;					// but the Stack is empty
		return newNode.getData();
		} catch (Exception e) {
			return "Error: The Stack is empty!";
		}
	}

	private class Node {
		public Object data;
		public Node next;

		Node(Object data) {
			this.data = data;
		}
		
		public Object getData() {
			return data;
		}
	}

	public static void main(String[] args) {
		StackAsList stack = new StackAsList();		// we tested the console output by calling
													// the methods and triggering an exception
		String s = "Hello";							// in the end. 
		String t = "Good";
		String u = "Morning";
		
		System.out.println(stack.isEmpty());
		
		stack.push(s);
		stack.push(t);
		stack.push(u);
		
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.toString());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
