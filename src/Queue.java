public class Queue {

		private Node tail;
		private Node placeHolder;
		
		public Queue() {
			tail = null;
			placeHolder = null;
		}
		
		public void enqueue(Node node) {
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
		
		public Node dequeue() {
			if(tail == null) {
				//System.out.println("The queue is empty");
				return null;
			}
			else if (tail.getPrevious() == null) {
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
			return tail;
		}
}
