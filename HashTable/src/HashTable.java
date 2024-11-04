import java.io.BufferedReader;
import java.io.FileReader;
public class HashTable {
	
	Node[] data;
	int max;
	
	public class Node{
		String code;
		String name;
		Integer pop;
		
		public Node(String code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}
	
	public HashTable(String file) {
		data = new Node[10000];
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				//Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
				
				for(String index : row) {
					System.out.printf("%-10s", index);
				}
				System.out.println(); 
			}
			max = i-1;
		} catch(Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public static void lookup(String key, Node[] data) {
		int i = 0;
		while(i < 9675) {
			if(key.equals(data[i].code)) {
				System.out.println(key + " found in the array");
				return;
			}
			else {
				i++;
			}
		}
		System.out.println(key + " not present in the array");
	}
	
	
	
	public static String binarySearch(String key, Node[] data, int low, int high) {
		
		if(high >= low) {
			int mid = (low + high) / 2;
			
			if(key.equals(data[mid].code)) {
				System.out.println(key + " found in the array");
				return data[mid].code;
			}
			
			else if(Integer.valueOf(key) > Integer.valueOf(data[mid].code)) {
				return binarySearch(key, data, mid+1, high);
			}
			
			else {
				return binarySearch(key, data, low, mid-1);
			}
		}
		return "false";
	} 
	
	
	
	
	
	
	public static void main(String[] args)throws Exception {
		HashTable table = new HashTable("src\\postnummer.csv");
	
	/*	for(int i = 0; i < 9675; i++) {
			System.out.println(table.data[i].code);
		} 
		
		long t0 = System.nanoTime();
		lookup("111 15", table.data);
		long t1 = System.nanoTime();
		long total = (t1 - t0);
		
		System.out.println("time to find key: " + total + " ns");  
		
		for(int i = 0; i < 9675; i++) {
			table.data[i].code = table.data[i].code.replaceAll("\\s+","");
			//System.out.println(table.data[i].code);
		} 
		
		long t2 = System.nanoTime();
		binarySearch("11115", table.data, 0, 9674);
		long t3 = System.nanoTime();
		long totalTime = (t3 - t2);
		
		System.out.println("time to find key: " + totalTime + " ns"); */
		
		 
	} 

}
