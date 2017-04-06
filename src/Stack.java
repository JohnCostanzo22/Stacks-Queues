/**
 * Class that creates a Stack of Nodes
 *
 */
public class Stack {

	//properties
	private Node tail;
	private Node placeHolder;
	
	/**
	 * Default contructor
	 */
	public Stack() {
		tail = null;
		placeHolder = null;
	}
	
	/**
	 * Adds a new Node to the top of the stack
	 * @param newNode - Node to be added
	 */
	public void push(Node newNode) {
		//handle if a bad node is passed in
		if(newNode == null) {
			throw new IllegalArgumentException("The Node is empty");
		}
		if(tail == null) {
			tail = newNode;
		}
		else {
			newNode.setPrevious(tail);
			tail = newNode;
		}
	}
	
	/**
	 * Gets the top Node, removes it from the stack and returns the Node
	 * @return - Top Node
	 */
	public Node pop() {
		if(tail == null) {
			throw new IllegalArgumentException("The Stack is empty");
		}
		else if(tail.getPrevious() == null) {
			placeHolder = tail;
			tail = null;
			//reset the node so it can be reused
			placeHolder.setPrevious(null);  
			return placeHolder;
		}
		placeHolder = tail;
		tail = tail.getPrevious();
		//reset the node so it can be reused
		placeHolder.setPrevious(null);  
		return placeHolder;
	}
	/**
	 * Return the top Node but does not delete it
	 * @return - Top Node
	 */
	public Node peek() {
		if(tail == null) {
			throw new IllegalArgumentException("The Stack is empty");
		}
		else {
			return tail;
		}
	}
}