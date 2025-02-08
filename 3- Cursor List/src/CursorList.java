
public class CursorList {
	private final int MAX_SIZE;
	private Node[] cursorArray;

	public CursorList(int size) {
		this.MAX_SIZE = size;
		initialization();
	}

	public void initialization() {
		cursorArray = new Node[MAX_SIZE];

		for (int i = 0; i < MAX_SIZE; i++)
			cursorArray[i] = new Node(null, i + 1);
		cursorArray[MAX_SIZE - 1].setNext(0);
	}

	public int cursorAlloc() {
		int p = cursorArray[0].getNext();
		cursorArray[0].setNext(cursorArray[p].getNext());
		return p;
	}

	public int creatList() {
		int l = cursorAlloc();
		if (l == 0)
			System.out.println("Array is full");
		else
			cursorArray[l] = new Node(null, 0);
		return l;
	}

	public void cursorFree(int p) {
		if (p <= 0 || p >= MAX_SIZE) {
			System.out.println("Out of bound");
			return;
		}
		cursorArray[p].setElement(null);
		cursorArray[p].setNext(cursorArray[0].getNext());
		cursorArray[0].setNext(p);
	}

	public boolean isNull(int l) {
		return cursorArray[l] == null;
	}

	public boolean isEmpty(int l) {
		return cursorArray[l].getNext() == 0;
	}

	public boolean isLast(int p) {
		return cursorArray[p].getNext() == 0;
	}

	public void insertAtHead(Object data, int l) {
		if (l < 0 || l >= MAX_SIZE) {
			System.out.println("Out of bound");
			return;
		}

		if (isNull(l)) {
			System.out.println("The List Does not exists");
			return;
		}

		int p = cursorAlloc();
		if (p == 0) {
			System.out.println("Cursor is full");
			return;
		}
		Node node = new Node(data, cursorArray[l].getNext());
		cursorArray[p] = node;
		cursorArray[l].setNext(p);
	}

	public int find(Object data, int l) {
		int p = cursorArray[l].getNext();
		while (p != 0 && cursorArray[p].getElement().equals(data))
			p = cursorArray[p].getNext();
		return p;
	}

	public void insert(Object data, int l, int p) {
		if (l <= 0 || l >= MAX_SIZE || p <= 0 || p >= MAX_SIZE) {
			System.out.println("Out of bound");
			return;
		}

		if (isNull(l)) {
			System.out.println("The List Does not exists");
			return;
		}

		if (p == 0) {
			insertAtHead(data, l);
			return;
		}

		int curr = cursorAlloc();
		if (curr == 0) {
			System.out.println("Cursor is full");
			return;
		}
		int prev = previous(data, l);
		cursorArray[curr] = new Node(data, p);
		cursorArray[prev].setNext(curr);
	}

	public int previous(Object data, int l) {
		while (l != 0 && data != null && cursorArray[cursorArray[l].getNext()].getElement().equals(data))
			l = cursorArray[l].getNext();
		return l;
	}

	public void traversList(int l) {
		if (l <= 0 || l >= MAX_SIZE) {
			System.out.println("Out of bound");
			return;
		}

		if (isNull(l)) {
			System.out.println("The List Does not exists");
			return;
		}
		while (cursorArray[l].getNext() != 0)
			System.out.println(cursorArray[l++].getElement());

	}

	public void remove(Object data, int l) {
		if (l <= 0 || l >= MAX_SIZE) {
			System.out.println("Out of bound");
			return;
		}

		if (isNull(l)) {
			System.out.println("The List Does not exists");
			return;
		}

		int prev = previous(data, l);

		if (cursorArray[prev].getNext() != 0) {
			int temp = cursorArray[prev].getNext();
			cursorArray[prev].setNext(cursorArray[temp].getNext());
			cursorFree(temp);
		}

	}
}
