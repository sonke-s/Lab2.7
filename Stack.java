public interface Stack<E> {
	
	abstract void push(E elem);
	
	abstract boolean isEmpty();
	
	abstract String toString();
	
	default E peek() {
		return (E) "is this";
	}
	
	default E pop() {
		return (E) "is this";
	}
}
