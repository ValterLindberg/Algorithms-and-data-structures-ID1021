import java.util.Random;
public class Main {
	
	public static void main(String[] args) {
		
			for(int i = 0; i < 5; i++) {
			benchmark(100, 100, 100);
		}
		
	}
	
	private static double access(int[] array, int[]index) {
		int l = index.length;
		double sum = 0;
		for(int i = 0; i < l; i++) {
			sum += array[index[i]];
		}
		return sum;
	}
	
	private static void benchmark(int k, int n, int l) {
		Random rnd = new Random();
		int sum = 0;
		
		int[] index = new int[l];
		for(int i = 0; i < index.length; i++) {
			index[i] = rnd.nextInt(k);
		}
		
		int[] array = new int[k];
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		//int average = 0;
		for(int i = 0; i < n; i++) {
			long n0 = System.nanoTime();
			long n1 = System.nanoTime();
			access(array, index);
			sum += (n1 - n0);
			 //average = (sum / 5);
		}
		System.out.println("Resolution " + sum + " nanoseconds");
	}
}
