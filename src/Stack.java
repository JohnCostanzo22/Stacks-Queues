public class Stack {

	private Node head;
	private Node tail;
	private Node placeHolder;
	private int size;
	
	public Stack() {
		head = null;
		tail = null;
		placeHolder = null;
		size = 0;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void push(Node newNode) {
		if(tail == null) {
			tail = newNode;
			head = newNode;				//get track of head for now just in case we need it
		}
		else {
			newNode.setPrevious(tail);
			tail = newNode;
		}
		size++;
	}
	
	public Node pop() {
		placeHolder = tail;
		tail = tail.getPrevious();
		size--;
		return placeHolder;
	}
	
	public Node peek() {
		return tail;
	}
	
	/*
	public boolean find(String name) {
		boolean contains = false;
		placeHolder = head;
		for(int i = 0; i < size-1; i++) {
			int equals = placeHolder.getName().compareToIgnoreCase(name);
			if(equals == 0) 
				contains = true;
			placeHolder = placeHolder.getNext();
		}
		return contains;
	}
	
	public void forward() {
		if(head == null) {
			System.out.println("The list is empty");
		}
		else {
			placeHolder = head;
			for(int i = 0; i < size-1; i++) {
				System.out.println(placeHolder.getName());
				placeHolder = placeHolder.getNext();
			}
		}
	}
	
	public void backward() {
		if(head == null) {
			System.out.println("The list is empty");
		}
		else if(tail == null) {
			if(size == 1) {
				System.out.println(head.getName());
			}
			else {
				System.out.println("Error: The list does not have a tail");
			}
		}
		else {
			placeHolder = tail;
			for(int i = 0; i < size-1; i++) {
				System.out.println(placeHolder.getName());
				placeHolder = placeHolder.getPrevious();
			}
		}
	}
	
	public void delete(Node node) {
		if(node == head) {
			head = node.getNext();
			node.getNext().setPrevious(null);
		}
		else if(node == tail) {
			tail = node.getPrevious();
			node.getPrevious().setNext(null);
		}
		else {
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
		}
		size--;
	}
	
	public void delete() {
		head = null;
		tail = null;
	}
	*/
}