public class Queue {

		private Node tail;
		private Node placeHolder;
		
		public Queue() {
			tail = null;
			placeHolder = null;
		}
		
		public void enqueue(Node node) {
			if(tail == null) {
				node = tail;
				return;
			}
			placeHolder = tail;
			while(tail.getPrevious() != null) {
				placeHolder = tail.getPrevious();
			}
			placeHolder.setPrevious(node);
		}
		
		public Node dequeue() {
			if(tail == null) {
				System.out.println("The queue is empty");
				return null;
			}
			else if (tail.getPrevious() == null) {
				placeHolder = tail;
				tail = null;
				return tail;
			}
			placeHolder = tail;
			tail = tail.getPrevious();
			return placeHolder;
		}
		
		public Node peek() {
			return tail;
		}
}
