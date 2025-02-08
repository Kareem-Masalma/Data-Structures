
public class DoubleHash {
	private int tableSize;
	private Entery[] hash;
	private int elements;

	public DoubleHash(int tableSize) {
		hash = new Entery[tableSize];
		for (int i = 0; i < tableSize; i++)
			hash[i] = new Entery(0);
		elements = 0;
	}

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public Entery[] getHash() {
		return hash;
	}

	public void setHash(Entery[] hash) {
		this.hash = hash;
	}

	private int hashFunc(int k) {
		return k % tableSize;
	}

	private int hashFunc2(int k) {
		return R() - (k % R());
	}

	private int R() {
		int r;
		for (r = tableSize - 1; r > 0; r--) {
			if (isPrime(r))
				return r;
		}
		return r;
	}

	private int f(int i, int k) {
		return (hashFunc(k) + i * hashFunc2(k)) % tableSize;
	}

	public void add(int k) {

		int pos = hashFunc(k);
		if (hash[pos].getStatus() == 0) {
			hash[pos].setValue(k);
			hash[pos].setStatus(1);
			elements++;
			if (check())
				rehash();

			return;
		}

		int next = f(0, k);

		for (int i = 1; i < tableSize; i++) {
			if (hash[next].getStatus() == 0) {
				hash[next].setValue(k);
				hash[next].setStatus(1);
				elements++;
				if (check())
					rehash();

				return;
			}
			next = f(i, k);
		}
		System.out.println("Hash is Full");
	}

	private void rehash() {
		int newSize = newSize();
		tableSize = newSize;
		Entery[] temp = hash;
		hash = new Entery[tableSize];
		for (int i = 0; i < tableSize; i++)
			hash[i] = new Entery('E');
		elements = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].getStatus() == 'F')
				add(temp[i].getValue());
		}
	}

	private int newSize() {
		int newSize = tableSize * 2;
		for (int i = newSize; true; i++) {
			if (isPrime(i)) {
				newSize = i;
				break;
			}
		}
		return newSize;
	}

	private boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private boolean check() {
		return elements == tableSize / 2;
	}

	public void remove(int k) {
		int pos = hashFunc(k);
		if (hash[pos].getValue() == k) {
			hash[pos].setValue(0);
			hash[pos].setStatus(2);
			elements--;
			return;
		}

		int next = f(0, k);
		for (int i = 1; i < tableSize; i++) {
			if (hash[next].getStatus() == 0) {
				System.out.println("Not found");
				return;
			} else if (hash[next].getValue() == k) {
				hash[next].setValue(0);
				hash[next].setStatus(2);
				elements--;
				return;
			}
			next = f(i, k);
		}
		System.out.println("Not found");
	}

	public boolean contains(int k) {
		int pos = hashFunc(k);
		if (hash[pos].getValue() == k)
			return true;

		int next = f(0, k);
		for (int i = 1; i < tableSize; i++) {
			if (hash[next].getStatus() == 0)
				return false;
			else if (hash[next].getValue() == k)
				return true;
			next = f(i, k);
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < tableSize; i++) {
			System.out.println(hash[i].getValue());
		}
	}
}
