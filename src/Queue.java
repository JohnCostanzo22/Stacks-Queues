/*
 * Class that creates a Queue of Nodes
 */
public class Queue {

		//properties
		private Node tail;
		private Node placeHolder;
		
		/**
		 * Default constructor
		 */
		public Queue() {
			tail = null;
			placeHolder = null;
		}
		/**
		 * Adds a new Node to the bottom of the Queue
		 * @param node - Node to be added
		 */
		public void enqueue(Node node) {
			//handle if a bad node is passed in
			if(node == null) {
				throw new IllegalArgumentException("The Node is empty");
			}
			if(tail == null) {
				tail = node;
				return;
			}
			else if(tail.getPrevious() == null) {
				tail.setPrevious(node);
				return;
			}
			placeHolder = tail;
			while(placeHolder.getPrevious() != null) {
				placeHolder = placeHolder.getPrevious();
			}
			placeHolder.setPrevious(node);
		}
		
		/**
		 * Removes the top Node from the queue and returns it
		 * @return the top Node
		 */
		public Node dequeue() {
			if(tail == null) {
				throw new IllegalArgumentException("The Queue is empty");
			}
			else if (tail.getPrevious() == null) {
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
		 * Return the top of the Queue but do not delete
		 * @return the Top Node
		 */
		public Node peek() {
			if(tail == null) {
				throw new IllegalArgumentException("The Queue is empty");
			}
			else {
				return tail;
			}
		}
}
