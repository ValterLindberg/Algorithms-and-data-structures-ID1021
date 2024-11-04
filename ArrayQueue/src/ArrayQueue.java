
public class ArrayQueue {
	static Integer head = 0;
	static int k = 0;
	
	
	public static Integer[] constructQueue(Integer[] a) {
		Integer[] arr = new Integer[a.length];
		
		for(int i = 0; i < a.length; i++) {
			arr[i] = i*2;
		}
		
		return arr;
	}
	
	public static Integer[] addToQueue(Integer element, Integer[] a) {
		int p = head;
		
		if( full(a)) {
			biggerQueue(a);
		}

		while(a[p] != null) {
			p++;
		}
		k++;
		a[p] = element;
		System.out.println(a[p] + " added to queue");
		return a;
	}
	
	public static void remove(Integer[] a) {
		if(a[head] == null) {
			System.out.println("nothing to remove");
			return;
		}
		else {
			System.out.println(a[head] + " removed");
			a[head] = null;
			head++;
		}
	}
	
	public static void printQueue(Integer[] a) {
		int i = head;
		if(a[i] == null) {
			System.out.println("queue is empty");
			return;
		}
		
		while(a[i] != null) {
			System.out.println(a[i]);
			i++;
		}
	}
	
	public static boolean full(Integer[] a) {
		if(k == a.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Integer[] biggerQueue(Integer[] a) {
		Integer[] biggerArray = new Integer[a.length*2];
		int index = 0;
		
		//copies the values in the old array into the new one
		for(int p = head; p < a.length; p++) {
			biggerArray[index] = a[p];
			index++;
		}
		head = 0;
		k = 0;
		
		a = biggerArray;
		
		return a;
	}

	public static void main(String[] args) {
		Integer[] n = new Integer[10];
		Integer[] arr = new Integer[n.length];
		for(int i = 0; i < arr.length-1; i++) {
			addToQueue(i*i, arr);
		}
		printQueue(arr);
		
	//	printQueue(arr);
	}

}
