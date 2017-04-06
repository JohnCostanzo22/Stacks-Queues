public class Stack {

	private Node tail;
	private Node placeHolder;
	
	public Stack() {
		tail = null;
		placeHolder = null;
	}
	
	public void push(Node newNode) {
		if(tail == null) {
			tail = newNode;
		}
		else {
			newNode.setPrevious(tail);
			tail = newNode;
		}
	}
	
	public Node pop() {
		if(tail == null) {
			//System.out.println("The stack is empty");
			throw new IllegalArgumentException("The Stack is empty");
		}
		else if(tail.getPrevious() == null) {
			placeHolder = tail;
			tail = null;
			placeHolder.setPrevious(null);   				//reset the node so it can be reused
			return placeHolder;
		}
		placeHolder = tail;
		tail = tail.getPrevious();
		placeHolder.setPrevious(null);   				//reset the node so it can be reused
		return placeHolder;
	}
	
	public Node peek() {
		if(tail == null) {
			throw new IllegalArgumentException("The Stack is empty");
		}
		else {
			return tail;
		}
	}
}