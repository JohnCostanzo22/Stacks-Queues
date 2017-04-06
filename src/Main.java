
public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		Queue queue = new Queue();
		
		Node node1 = new Node("The");
		Node node2 = new Node("house");
		Node node3 = new Node("is");
		Node node4 = new Node("Red");
			
		stack.push(node4);
		stack.push(node3);
		stack.push(node2);
		stack.push(node1);
		
		/*System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
		
		queue.enqueue(node1);
		queue.enqueue(node2);
		queue.enqueue(node3);
		queue.enqueue(node4);	*/
		
		stackToQueue(stack, queue);
		
		System.out.println(queue.dequeue().getName());
		System.out.println(queue.dequeue().getName());
		System.out.println(queue.dequeue().getName());
		System.out.println(queue.dequeue().getName());	
		/*
		queueToStack(queue, stack);
		
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());	*/
	}

	public static void stackToQueue(Stack stack, Queue queue) {
		Node temp = stack.pop();
		while(temp != null) {
			queue.enqueue(temp);
			temp = stack.pop();
		}
	}
	
	public static void queueToStack(Queue queue, Stack stack) {
		Node temp = queue.dequeue();
		while(temp != null) {
			stack.push(temp);
			//System.out.println(temp.getName());
			temp = queue.dequeue();
		}
	}
}


//the dog is red
//Stack: red,is,dog,the
//queue: the dog is red