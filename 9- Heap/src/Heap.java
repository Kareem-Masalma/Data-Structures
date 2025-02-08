
public class Heap {
	private int heapSize;
	private int[] heap;

	public Heap(int size) {
		heapSize = 1;
		heap = new int[size];
	}

	public Heap(int[] heap) {
		buildHeap(heap);
	}

	public int[] getHeap() {
		return heap;
	}

	public void setHeap(int[] heap) {
		this.heap = heap;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	public void buildHeap(int[] heap) {
		this.heapSize = heap.length - 1;
		this.heap = heap;
		for (int i = heapSize / 2; i >= 1; i--)
			maxHeapify(this.heap, i);
	}

	private void maxHeapify(int[] heap, int i) {
		int l = left(i);
		int r = right(i);
		int largest = l <= heapSize && heap[l] > (heap[i]) ? l : i;

		if (r <= heapSize && heap[r] > heap[largest])
			largest = r;

		if (largest != i) {
			int temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;
			maxHeapify(heap, largest);
		}
	}

	public int max() {
		return heapMax(heap);
	}

	private int heapMax(int[] heap) {
		return heap[1];
	}

	public int extractMax() {
		return extractMax(heap);
	}

	private int extractMax(int[] heap) {
		int max = heap[1];
		heap[1] = heap[heapSize];
		heapSize--;
		maxHeapify(heap, 1);
		return max;
	}

	public void insert(int value) {
		insert(heap, value);
	}

	private void insert(int[] heap, int value) {
		heapSize++;
		int i = heapSize - 1;
		heap[i] = value;
		while (i > 1 && heap[i] > heap[i / 2]) {
			int temp = heap[i];
			heap[i] = heap[i / 2];
			heap[i / 2] = temp;
			i /= 2;
		}
	}

	public int[] sort(int[] heap) {
		buildHeap(heap);
		int[] arr = new int[heapSize];
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = extractMax(this.heap);
		}
		return arr;
	}

	public int[] sort() {
		int[] arr = new int[heapSize];
		for (int i = heapSize - 1; i > 0; i--) {
			arr[i] = extractMax();
		}
		return arr;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	public void print() {
		for (int i : heap)
			System.out.println(i);
	}
}
