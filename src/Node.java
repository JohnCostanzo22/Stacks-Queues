/*
 * Class that creates objects called Nodes That contain strings
 * and keeps track of the previous Node
 */
public class Node {
	
	//properties
	private String name = "";
	private Node previous;
	
	/**
	 * Constructor that sets name field and sets 
	 * @param name - String contained in the Node
	 */
	public Node(String name) {
		this.name = name;
		this.previous = null;
	}
	/**
	 * Mutator method that changes the previous node
	 * @param node - previous node
	 */
	public void setPrevious(Node node) {
		this.previous = node;
	}
	/**
	 * Accessor method
	 * @return The previous Node
	 */
	public Node getPrevious() {
		return previous;
	}
	/**
	 * Accessor method
	 * @return the Name of the Node
	 */
	public String getName() {
		return name;
	}
}