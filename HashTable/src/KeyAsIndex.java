import java.io.BufferedReader;
import java.io.FileReader;

public class KeyAsIndex {

	Node[] data;
	int max;
	Integer[] keys = new Integer[9675];
	static Integer[][] buckets = new Integer[100000][10000];
	
	public class Node{
		Integer code;
		String name;
		Integer pop;
		Node next;
		
		public Node(Integer code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
			this.next = null;
		}
	}
	
	public KeyAsIndex(String file) {
		data = new Node[100000];
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				keys[i] = code;
				data[keys[i]] = new Node(code, row[1], Integer.valueOf(row[2]));
				i++;
				
		/*		for(String index : row) {
					System.out.printf("%-10s", index);
				}
				System.out.println(); */
			}
			max = i-1;
		} catch(Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	
	public static void lookupInteger(int key, Node[] data) {
		
		int i = 0;
		while(i < 9675) {
			if(key == data[i].code) {
				System.out.println(key + " found in the array");
				return;
			}
			else {
				i++;
			}
		}
		System.out.println(key + " not present in the array");
	}
	
	
	public static void lookupKai(int key, Node[] data, Integer[] keys) {
		
		int i = 0;
		while(keys[i] != null) {
			if(data[keys[i]].code == key) {
				System.out.println(key + " found");
				return;
			}
			else {
				i++;
			}
		}
	}
	
	
public static Integer binarySearchInteger(int key, Node[] data, int low, int high) {
		
		if(high >= low) {
			int mid = (low + high) / 2;
			
			if(data[mid].code == key) {
				System.out.println(key + " found in the array");
				return data[mid].code;
			}
			
			else if(key > data[mid].code) {
				return binarySearchInteger(key, data, mid+1, high);
			}
			
			else {
				return binarySearchInteger(key, data, low, mid-1);
			}
		}
		System.out.println("key not found");
		return -1;
	}
	

	public static void lookupHash(int key, Integer[] keys) {
		
	
		
		
		
		
		
		
		/*	int j = 0;
		while(buckets[j].code != null) {
			if(buckets[j].code == key) {
				System.out.println(key + " found in the bucket list");
				return;
			}
			else if(buckets[j].next.code != null) {
				while(buckets[j].next.code != null) {
					
				}
			}
		} */
	}
	

	public void collisions(int mod) {
		int[] data = new int[mod];
		int[] cols = new int[10];
		//buckets = new Node[mod];
		int j = 0;
		for(int i = 0; i < max; i++) {
			Integer index = keys[i] % mod;
			cols[data[index]]++;
			data[index]++;
			
			if(cols[data[index]] > 1) {
				buckets[index][j++] = keys[i];
			}
			else {
				buckets[index][j] = keys[i];
			}
			
			
		}
		
		System.out.print(mod);
		for(int i = 0; i < 10; i++) {
			System.out.print("\t" + cols[i]);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		KeyAsIndex table = new KeyAsIndex("src\\postnummer.csv");
		
	/*	for(int i = 0; i < 9675; i++) {
			System.out.println(table.data[i].code);
			System.out.println(table.keys[i] + " keys that will be used as index");
		} */
		
		
	/*	long t4 = System.nanoTime();
		lookupKai(11115, table.data, table.keys);
		long t5 = System.nanoTime();
		long time = (t5 - t4);
		System.out.println("time to find key " + time + " ns"); */
		
		table.collisions(20000);
		int k = 10000 % 10000;
		System.out.println(k);
		for(int i = 0; i < buckets.length; i++) {
			for(int j = 0; j < 11; j++) {
				if(buckets[i][j] != null) {
					System.out.println(buckets[i][j]);
				}
				else {
					continue;
				}
			}
		}
		
/*		long t0 = System.nanoTime();
		lookupInteger(11115, table.data);
		long t1 = System.nanoTime();
		long total = (t1 - t0);
		System.out.println("total time linear search: " + total + " ns");
		
		
		long t2 = System.nanoTime();
		binarySearchInteger(98499, table.data, 0, 9674);
		long t3 = System.nanoTime();
		long totalTime = (t3 - t2);
		System.out.println("total time binary search: " + totalTime + " ns");*/
	} 
}
