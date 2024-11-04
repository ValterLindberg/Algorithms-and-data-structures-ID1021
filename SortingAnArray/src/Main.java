import java.util.Random;
public class Main {

	public static void main(String[] args) {
		/* Random rnd = new Random();
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(500) + 1;
		} 
		insertionSort(arr);
		for(int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]); 
		} */
		
		int[] sizes = {10, 100, 1000, 10000, 20000, 30000,
			       40000, 50000, 60000, 70000, 80000, 90000, 100000 };
		for(int n : sizes) {
			time(100, n); 
		} 
		/* Random r = new Random();
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(300) + 1;
		}
		mergeSort(arr);
		for(int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]); 
		} */

	}

	public static void selectionSort(int[] array) {
		int cand;
		for(int i = 0; i < array.length; i++) {
			cand = i;
			for(int j = i; j < array.length; j++) {
				if(array[j] < array[cand]) {
					cand = j;
				}
			}
			int swap = array[i];
			array[i] = array[cand];
			array[cand] = swap;
		}
	}
	
	public static void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while(j >= 0  && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}
	
	public static void mergeSort(int[] org) {
		if(org.length == 0)
			return;
		int[] aux = new int[org.length];
		sort(org, aux, 0, org.length-1);
	}
	
	public static void sort(int[] org, int[] aux, int lo, int hi) {
		if(lo != hi) {
			int mid = lo + (hi - lo)/2;
			//lo to mid
			sort(org, aux, lo, mid);
			//mid+1 to hi
			sort(org, aux, mid+1, hi);
			//merge
			merge(org, aux, lo, mid, hi);
		}
	}
	
	private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
		for(int l = lo; l < hi; l++) {
			aux[l] = org[l];
		}
		
		int i = lo;
		int j = mid + 1;
		
		for(int k = lo; k <= hi; k++) {
			if(i > mid) {
				org[k] = aux[j];
				j++;
			}
			else if(j > hi) {
				org[k] = aux[i];
				i++;
			}
			else if(aux[i] < aux[j]) {
				org[k] = aux[i];
				i++;
			}
			else {
				org[k] = aux[j];
				j++;
			}
				
		}
	}
	
	
	public static void time(int tries, int n) {
		Random rnd = new Random();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = rnd.nextInt(500) + 1;
		}
		
		double min = Double.POSITIVE_INFINITY;
		double max = 0;
		double sum = 0;
		
		for(int j = 0; j < tries; j++) {
			double n0 = System.nanoTime();
			mergeSort(arr);
			double n1 = System.nanoTime();
			double t = (n1 - n0);
			if(t < min)
				min = t;
			if(t > max)
				max = t;
			sum += t;
		}
		System.out.printf("n: %6d \t min: %.2fns\t max: %.2fns\n", n, (min/(tries)), (max/(tries))); 
	}

}