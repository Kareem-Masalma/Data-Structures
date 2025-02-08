
public class BSTree {
	private Node root;

	public BSTree() {
		root = null;
	}

	public boolean contains(int element) {
		return contains(root, element);
	}

	private boolean contains(Node root, int element) {
		if (root == null)
			return false;
		else if (root.getElement() == element)
			return true;
		else if (element > root.getElement())
			return contains(root.getRight(), element);
		else
			return contains(root.getLeft(), element);
	}

	public Node find(int element) {
		return find(root, element);
	}

	private Node find(Node root, int element) {
		if (root == null)
			return null;
		else if (root.getElement() == element)
			return root;
		else if (element > root.getElement())
			return find(root.getRight(), element);
		else
			return find(root.getLeft(), element);
	}

	public int min() {
		if (root == null) {
			System.out.println("The tree is Empty");
			return -1;
		}
		return min(root).getElement();
	}

	public Node min(Node root) {
		if (root == null) {
			System.out.println("The tree is Empty");
			return null;
		} else if (root.getLeft() == null) {
			return root;
		}
		return min(root.getLeft());
	}

	public int max() {
		if (root == null) {
			System.out.println("The tree is Empty");
			return -1;
		}
		return max(root).getElement();
	}

	public Node max(Node root) {
		if (root == null) {
			System.out.println("The tree is Empty");
			return null;
		} else if (root.getRight() == null) {
			return root;
		}
		return max(root.getRight());
	}

	public void insert(int element) {
		root = insert(root, element);
	}

	private Node insert(Node root, int element) {
		if (root == null) {
			root = new Node(element);
			return root;
		} else {
			if (element > root.getElement())
				root.setRight(insert(root.getRight(), element));
			else if (element < root.getElement())
				root.setLeft(insert(root.getLeft(), element));

		}
		return root;
	}

	public void remove(int element) {
		root = remove(root, element);
	}

	private Node remove(Node root, int element) {
		if (root == null)
			return null;
		else {
			if (element > root.getElement())
				root.setRight(remove(root.getRight(), element));
			else if (element < root.getElement())
				root.setLeft(remove(root.getLeft(), element));
			else {
				if (root.getLeft() != null && root.getRight() != null) {
					root.setElement(min(root.getRight()).getElement());
					remove(root.getRight(), element);
				} else {
					root = root.getRight() != null ? root.getRight() : root.getLeft();
				}
			}
		}
		return root;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.println(root.getElement());
			inOrder(root.getRight());
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.getElement());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getElement());
		}
	}
}
