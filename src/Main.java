
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
		
		System.out.println("Peek on Stack: " + stack.peek().getName());
		
		System.out.println("On the Stack:");
		System.out.print(stack.pop().getName() + " ");
		System.out.print(stack.pop().getName() + " ");
		System.out.print(stack.pop().getName() + " ");
		System.out.println(stack.pop().getName() + " ");
		
		queue.enqueue(node1);
		queue.enqueue(node2);
		queue.enqueue(node3);
		queue.enqueue(node4);
		
		System.out.println("Peek on Queue: " + queue.peek().getName());
		
		System.out.println("On the Queue:");
		System.out.print(queue.dequeue().getName() + " ");
		System.out.print(queue.dequeue().getName() + " ");
		System.out.print(queue.dequeue().getName() + " ");
		System.out.println(queue.dequeue().getName() + " ");	
		
		stack.push(node4);
		stack.push(node3);
		stack.push(node2);
		stack.push(node1);
		
		stackToQueue(stack, queue);
		
		System.out.println("Stack to Queue");
		System.out.println("On the Queue:");
		System.out.print(queue.dequeue().getName() + " ");
		System.out.print(queue.dequeue().getName() + " ");
		System.out.print(queue.dequeue().getName() + " ");
		System.out.println(queue.dequeue().getName() + " ");	
		
		queue.enqueue(node1);
		queue.enqueue(node2);
		queue.enqueue(node3);
		queue.enqueue(node4);
		
		queueToStack(queue, stack);
		
		System.out.println("Queue to Stack");
		System.out.println("On the Stack:");
		System.out.print(stack.pop().getName() + " ");
		System.out.print(stack.pop().getName() + " ");
		System.out.print(stack.pop().getName() + " ");
		System.out.println(stack.pop().getName() + " ");
		
		stack.push(node4);
		stack.push(node3);
		stack.push(node2);
		stack.push(node1);
		
		Stack newStack = new Stack();
		newStack = stackToStack(stack);
		
		System.out.println("Stack to Stack");
		System.out.println("On the New Stack:");
		System.out.print(newStack.pop().getName() + " ");
		System.out.print(newStack.pop().getName() + " ");
		System.out.print(newStack.pop().getName() + " ");
		System.out.println(newStack.pop().getName() + " ");
		
		//testing of handling blank things
		stackToQueue(stack, queue);
		queueToStack(queue, stack);
		stackToStack(stack);
		
	}
	//works but have to deal with null pointer exception in queue and stack
	public static void stackToQueue(Stack stack, Queue queue) {
		try {
			stack.peek();
		} catch(IllegalArgumentException e) {
			System.out.println("The Stack is empty");
			return;
		}
		Node temp = stack.pop(); 
		while(temp != null) {
			queue.enqueue(temp);
			try {	
				temp = stack.pop();
			} catch(IllegalArgumentException e) {
				return;
			}
		}
	}
	
	public static void queueToStack(Queue queue, Stack stack) {
		try {
			queue.peek();
		} catch(IllegalArgumentException e) {
			System.out.println("The Queue is empty");
			return;
		}
		Node temp = queue.dequeue();
		Stack tempStack = new Stack();
		while(temp != null) {
			tempStack.push(temp);
			try {	
				temp = queue.dequeue();
			} catch(IllegalArgumentException e) {
				break;		//Going to get here. Need to handle the exception, but keep
							//going because method is not finished
			}
		}
		temp = tempStack.pop();
		while(temp != null) {
			stack.push(temp);
			try {	
				temp = tempStack.pop();
			} catch(IllegalArgumentException e) {
				return;
			}
		}
	}
	
	public static Stack stackToStack(Stack stack) {
		Queue tempQ = new Queue();
		Stack tempStack = new Stack();
		stackToQueue(stack, tempQ);
		queueToStack(tempQ, tempStack);
		return tempStack;
	}
}