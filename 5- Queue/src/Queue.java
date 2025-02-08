
public class Queue {
	private Node front, rear;

	public Queue() {
		front = rear = null;
	}

	public void enQueue(Object element) {
		Node node = new Node(element);
		if (isEmpty()) {
			front = rear = node;
		} else {
			rear.setNext(node);
			rear = rear.getNext();
		}
	}

	public Object deQueue() {
		if (isEmpty()) {
			System.out.println("The list is empty");
			return null;
		} else {
			Object temp = front.getElement();
			front = front.getNext();
			return temp;
		}

	}

	public Object front() {
		return front.getElement();
	}

	public boolean isEmpty() {
		return front == null || rear == null;
	}
}
