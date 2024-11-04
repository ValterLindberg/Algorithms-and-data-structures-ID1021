package sortedSearch;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//int[] array = new int[100];
		//int sum = 0;
		//long t0 = System.nanoTime();
		//long t1 = System.nanoTime(); 
		//array[99] = 74;
		
		/* for(int j = 0; j < array.length; j++) {
			array[j] = j;
			sum += (t1 - t0);
		}
		System.out.println(search_unsorted(array, 74));
		System.out.println("resolution time " +sum); */
		
		Random random = new Random();
		/* int key = random.nextInt(999999);
		int[] n = sorted(1000000);
		for(int j = 0; j < n.length; j++) {
			sum += (t1 - t0);
			if(n[j] > key) {
				System.out.println("the array does not contain the key");
				break;
			}
			else if (n[j] == key) {
				System.out.println("key found!");
				break;
			}
			else {
				System.out.println("searching...");
			}
		}
		System.out.println("resolution time " +sum); */
		
		int[] sizes = {100,200,300,400,500,600,700,800,900,
					   1000,1100,1200,1300,1400,1500,1600};
		
		System.out.printf("# searching through an array of length n, time in ns\n");
		System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");
		
		for(int n : sizes) {
			int loop = 100;
			
			int[] array = sorted(n);
			int[] indx = keys(loop, n);
			
			System.out.printf("%8d", n);
			
			int k = 100;
			
			double min = Double.POSITIVE_INFINITY;
			
			for(int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				linear(array, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%8.0f", (min/loop)); 
			
			min = Double.POSITIVE_INFINITY;
			
			for(int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				binary(array, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min)
					min = t;
			}
			
			System.out.printf("%8.0f\n" , (min/loop));
		}

					   
		}
		
		
	
	public static void binarySearch(int[] array, int first, int last, int key) {
		int mid = (first + last)/2;
		
		while(first <= last) {
			if(array[mid] < key) {
				first = mid + 1;
			}
			else if(array[mid] == key) {
				System.out.println("Element found at position " + mid);
				break;
			}
			else {
				last = mid - 1;
			}
			mid = (first + last)/2;
		}
		if(first > last) {
			System.out.println("the array does not contain the key");
		}
	}
	
	
	public static boolean search_unsorted(int[] array, int key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	private static int[] sorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = 0;
		for(int i = 0; i < n; i++) {
			nxt += rnd.nextInt(10) + 1;
			array[i] = nxt;
		}
		return array;
	}
	
	private static int[] keys(int loop, int n) {
		Random rnd = new Random();
		int[] indx = new int[loop];
		for(int i = 0; i < loop; i++) {
			indx[i] = rnd.nextInt(n*5);
		}
		return indx;
	}
	
	private static void binary(int[] array, int[] indx) {
		for(int i = 0; i < indx.length; i++) {
			binary_search(array, indx[i]);
		}
	}
	
	
	public static boolean binary_search(int[] array, int key) {
		int first = 0;
		int last = array.length - 1;
		
		while(true) {
			//jump to the middle
			int i = last + first/2;
		
		if(array[i] == key) {
			//System.out.println("key found at " + i);
			break;
			
		}
		if(array[i] < key && i < last) {
			//the index position holds something that is less than
			//what we're looking for, what is the first possible page
			
			first = i + 1;
			continue;
		}
		if(array[i] > key && i > first) {
			//the index position holds something that is larger than
			//what we're looking for, what is the last possible page
			
			last = i - 1;
			continue;
		}
		continue;
		
	   }
	   return false;
	 }
	
	
	private static void linear(int[] array, int[] indx) {
		for(int i = 0; i < indx.length; i++) {
			linear_search(array, indx[i]);
		}
	}
	
	private static void linear_search(int[] array, int key) {
			
			for(int i = 0; i < array.length; i++) {
				array[i] = i;
			}
			search_unsorted(array,key);
		
	}
	
}
