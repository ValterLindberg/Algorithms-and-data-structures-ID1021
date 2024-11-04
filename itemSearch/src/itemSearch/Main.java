package itemSearch;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			search(100, 1000, 100);
		}
		

	}

	
	private static void search(int k, int m, int n) {
		Random rnd = new Random();
		int sum = 0;
		int t_total = 0;
		
		int[] keys = new int[m];
		for(int i = 0; i < m; i++) {
			keys[i] = rnd.nextInt(n*10);
		}
		
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = rnd.nextInt(n*10);
		}
		for(int j = 0; j < k; j++) {
			long t0 = System.nanoTime();
			for(int ki = 0; ki < m; ki++) {
				int key = keys[ki];
				for(int i = 0; i < n; i++) {
					if(array[i] == key) {
						sum++;
						break;
					}
				}
			}
			t_total += (System.nanoTime() - t0);
		}
		System.out.println("Resolution " + t_total + " nanoseconds, " + sum + " keys found" );
	}

}
