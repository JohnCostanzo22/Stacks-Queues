
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
	}
	//works but have to deal with null pointer exception in queue and stack
	public static void stackToQueue(Stack stack, Queue queue) {
		Node temp = stack.pop();
		while(temp != null) {
			queue.enqueue(temp);
				temp = stack.pop();
		}
	}
	
	public static void queueToStack(Queue queue, Stack stack) {
		Node temp = queue.dequeue();
		Stack tempStack = new Stack();
		while(temp != null) {
			tempStack.push(temp);
			temp = queue.dequeue();
		}
		temp = tempStack.pop();
		while(temp != null) {
			stack.push(temp);
			temp = tempStack.pop();
		}
	}
	
	public static void stackToStack(Stack stack) {
		Queue tempQ = new Queue();
		Stack tempStack = new Stack();
		stackToQueue(stack, tempQ);
		Node temp = tempQ.dequeue();
		while(temp != null) {
			tempStack.push(temp);
			temp = tempQ.dequeue();
		}
	}
}
// red is house the
// 

//the dog is red
//Stack: red,is,dog,the
//queue: the dog is red