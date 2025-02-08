
public class Node {
	private int element;
	private Node right, left;

	public Node(int element) {
		this(element, null, null);
	}

	public Node(int element, Node right, Node left) {
		this.element = element;
		this.right = right;
		this.left = left;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

}
