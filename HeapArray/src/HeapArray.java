
public class HeapArray {

	static int[] array;
	static int n;
	static int heapSize;
	static int front;
	public HeapArray(int n) {
		this.n = n;
		heapSize = 0;
		array = new int[n];
	}
	
	public static int getMinimum() {
		return array[0];
	}
	
	public static int getLeftChild(int i) {
		return 2*i+1;
	}
	
	public static int getRightChild(int i) {
		return 2*i+2;
	}
	
	public static int getParent(int i) {
		return (i-1) / 2;
	}
	
	public static void add(int value) {
		if(full()) {
			System.out.println("heap is full");
			return;
		}
		else {
			heapSize++;
			int i = heapSize-1;
			array[i] = value;
			System.out.println(array[i] + " added");
			while(i != 0 && array[i] < array[getParent(i)]) {
				swap(i, getParent(i));
				i = getParent(i);
			}
		}
	}
	
	public static int remove() {
		if(empty()) {
			System.out.println("empty heap");
			return -1;
		}
		else {
			int min = array[0];
			swap(0, heapSize-1);
			heapSize--;
			heapify(0);
			System.out.println(min + " REMOVED");
			return min;
		}
	}
	
	private static void heapify(int i ) {
		int left = 2*i+1;
		int right = 2*i+2;
		int smallest = 0;
		if(left < heapSize && array[left] < array[i]) {
			smallest = left;
		}
		else {
			smallest = i;
		}
		if(right < heapSize && array[right] < array[smallest]) {
			smallest = right;
		}
		if(smallest != i) {
			swap(smallest, i);
			heapify(smallest);
		}
	}
	
	public static void sink(int i, int value) {
		if(i < heapSize) {
			array[i] = value;
			
			while(i != 0 && array[i] < array[getParent(i)]) {
				swap(i, getParent(i));
				i = getParent(i);
			}
		}
	}
	
	public static void delete(int i) {
		if(empty()) {
			System.out.println("heap is empty");
			return;
		}
		else {
			sink(i, Integer.MIN_VALUE);
			remove();
		}
	}
	
	private static void swap(int a, int b) {
		int t = array[a];
		System.out.println(array[a] + " swapped with " + array[b]);
		array[a] = array[b];
		array[b] = t;
	}
	
	public static boolean empty() {
		return heapSize == 0;
	}
	
	public static boolean full() {
		return heapSize == n;
	}
	
	public static void printHeapTree() {
		for(int i = 0; i < heapSize/2; i++) {
			System.out.println("parent node: " + array[i] + " Left child: "
				+ array[2*i+1] + " right child : " + array[2*i+2]);
		}
	}
	
	
	public static void main(String[] args) {
		HeapArray a = new HeapArray(20);
		
		add(3);
		add(4);
		add(3);
		add(10);
		add(7);
		add(6);
		add(5);
		add(2);
		add(15);
		add(20);
		add(1);
		add(30);
		remove();
		remove();
		remove();
		remove();
		printHeapTree();

	}

}
