public class Queue {

		private Node head;
		private Node tail;
		private Node placeHolder;
		private int size;
		
		public NodeList() {
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
		
		public void add(Node newNode) {
			//System.out.println(size);
			boolean last = true;
			placeHolder = head;
			if(size == 0) {
				head = newNode;
				last = false;
			}
			else if(size == 1) {
				//if head comes before newNode = 1
				if(newNode.getName().compareToIgnoreCase(head.getName()) > 0) {
					placeHolder.setNext(newNode);
					newNode.setPrevious(placeHolder);
					tail = newNode;
					tail.setNext(null);
				}
				else if(newNode.getName().compareToIgnoreCase(head.getName()) == 0) {
					System.out.println(newNode.getName() + " is a duplicate and therrefore was not added");
				}
				else {
					head.setPrevious(newNode);
					newNode.setNext(head);
					tail = head;
					head = newNode;
				}
				last = false;
			}
			else {
				//loop through list from head to tail -1 because tail is a special case
				for(int i = 0; i < size-1; i++) {
		
					//if its before placeHolder it returns -1
					int before = newNode.getName().compareToIgnoreCase(placeHolder.getName());
					//if its after placeHolder it returns a -1
					int after = newNode.getName().compareToIgnoreCase(placeHolder.getNext().getName());
					//if before > 0 then it is before placeHolder
					if(before < 0) {
						//if i = 0 then it is before head
						if(i == 0) {
							newNode.setNext(placeHolder);
							placeHolder.setPrevious(newNode);
							head = newNode;
						}
						else {
							newNode.setPrevious(placeHolder.getPrevious());
							newNode.setNext(placeHolder);
							placeHolder.getPrevious().setNext(newNode);
							placeHolder.setPrevious(newNode);
						}	
						last = false;
						break;
					}
					else if(after < 0) {
						newNode.setPrevious(placeHolder);
						newNode.setNext(placeHolder.getNext());
						placeHolder.getNext().setPrevious(newNode);
						placeHolder.setNext(newNode);
						last = false;
						break;
					}
					//if before = 0 or after is = 0 then it is a duplicate and do not allow user to add it
					else if(before == 0 || after == 0) {
						System.out.println(newNode.getName() + " is a duplicate and therefore was not added");
						last = false;
						break;
					}
					placeHolder = placeHolder.getNext();
				}
			}
			
			//if last = true then it is at the end of the list
			if(last) {
					newNode.setPrevious(tail);
					tail.setNext(newNode);
					tail = newNode;
			}
			size++;
		}
		
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
	}
	Contact GitHub API Training Shop Blog About
	© 2017 GitHub, Inc. Terms Privacy Security Status Help
}
