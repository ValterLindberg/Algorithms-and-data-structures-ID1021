import java.util.Random;
public class Benchmark {
	
	
	public static boolean search_unsorted(int[] array, int key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	private static void binary_search(int[] array, int key) {
		int first = 0;
		int last = array.length - 1;
		//int mid = last + first;
		while(last - first > 1) {
			int mid = (last + first)/2;
			if(array[mid] == key) {
				break;
			}
			if(array[mid] < key) {
				first = mid + 1;
				continue;
			}
			if(array[mid] > key) {
				last = mid - 1;
				continue;
			}
		}
		
	}
	
	private static void evenBetter(int[] array, int[] key) {
		int firstF = -1;
		int nextF = firstF + 1;
		int firstS = -1;
		int nextS = firstS + 1;
		
		for(int i = 0; i < array.length; i++) {
			if(key[nextS] < array[nextF]) {
				nextS++;
				continue;
			}
			if(key[nextS] == array[nextF]) {
				nextF++;
				continue;
			}
			if(key[nextS] > array[nextF]) {
				nextF++;
				continue;
			}
		}
		
		
	}
	
	
	
	
	private static void linear(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
		    search_unsorted(array, indx[i]);
		}
	   }
	    

	    private static void binary(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
		     binary_search(array, indx[i]);
		}
	   }

	       
	    private static int[] sorted(int n) {
		Random rnd = new Random();	
		int[] array = new int[n];
		int nxt = rnd.nextInt(10);

		for (int i = 0; i < n ; i++) {
		    array[i] = nxt;
		    nxt += rnd.nextInt(10) + 1 ;
		}	
		return array;
	    }


	    private static int[] keys(int loop, int n) {
		Random rnd = new Random();	
		int[] indx = new int[loop];
		for (int i = 0; i < loop ; i++) {
		    indx[i] = rnd.nextInt(n*5);
		}	
		return indx;
	    }
	
	public static void main(String[] args) {
		
	//int[] sizes = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,11000,12000,13000,14000,15000,16000};
	int[] sizes = {1000,10000,100000,1000000,5000000};
	//  int[] sizes = {64000000};
	
	System.out.printf("# searching through an array of length n, time in ns\n");
	System.out.printf("#%7s%8s%8s\n", "n", "evenBetter", "binary");
		for ( int n : sizes) {

		    int loop = n;
		    
		    int[] array = sorted(n);
		    int[] indx = keys(loop, n);

		    System.out.printf("%8d", n);

		    int k = 100;
		    
		    double min = Double.POSITIVE_INFINITY;

		    /*for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			linear(array, indx);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
			    min = t;
		    }

		    System.out.printf("%8.0f", (min/loop));	  */   

		    min = Double.POSITIVE_INFINITY;
		    
		    for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			evenBetter(array, indx);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
			    min = t;
		    }

		    System.out.printf("%8.0f\n" , (min/loop));	 
		    
		}
	  }
}


