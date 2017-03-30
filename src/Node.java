public class Node {
	
	private String name = "";
	private Node next;
	private Node previous;
	
	public Node(String name) {
		this.name = name;
		this.next = null;
		this.previous = null;
	}
	
	public Node getNext() {
		return next;
	}

	public void setPrevious(Node node) {
		this.previous = node;
	}
	//note

	public Node getPrevious() {
		return previous;
	}

	public void setNext(Node node) {
		this.next = node;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}